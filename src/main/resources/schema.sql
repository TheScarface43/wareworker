CREATE TABLE IF NOT EXISTS warehouse_user (
    id SERIAL PRIMARY KEY,
    user_login VARCHAR(64) UNIQUE NOT NULL,
    user_password CHAR(85) NOT NULL,
    is_enabled BIT NOT NULL DEFAULT '1',
    first_name VARCHAR(32) NOT NULL,
    last_name VARCHAR(32) NOT NULL,
    email VARCHAR(64),
    telephone VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS warehouse_type (
    id SERIAL PRIMARY KEY,
    type_name VARCHAR(64) UNIQUE NOT NULL,
    description VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS warehouse (
    id SERIAL PRIMARY KEY,
    warehouse_name VARCHAR(64) UNIQUE NOT NULL,
    warehouse_location VARCHAR(128),
    description VARCHAR(256),
    warehouse_type_id INT NOT NULL,
    FOREIGN KEY (warehouse_type_id) REFERENCES warehouse_type (id)
);

CREATE TABLE IF NOT EXISTS permission (
    id SERIAL PRIMARY KEY,
    permission INT NOT NULL,
    -- 000000 - read only, 
    -- 000001 - add ware amounts to locations,
    -- 000010 - remove ware amounts from locations,
    -- 000100 - manage ware detials (add or remove wares from database, edit existing ones),
    -- 001000 - manage location details (add, remove or change the layout of a given warehouse),
    -- 010000 - warehouse admin (change name, type and address of a given warehouse, manage users and their rights under that warehouse),
    -- 100000 - global admin (add, remove and change all warehouses and all users)
    -- mix and match for a desired set of permissions, for example 000011 to move wares to and from locations, or 011111 for total control over one warehouse
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES warehouse_user (id),
    warehouse_id INT,
    FOREIGN KEY (warehouse_id) REFERENCES warehouse (id),
    CHECK (permission >= 32 or warehouse_id is not null)
);

CREATE TABLE IF NOT EXISTS location_type (
    id SERIAL PRIMARY KEY,
    type_name VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS location (
    id SERIAL PRIMARY KEY,
    rack VARCHAR(16) NOT NULL,
    spot INT NOT NULL,
    level INT NOT NULL,
    warehouse_id INT NOT NULL,
    FOREIGN KEY (warehouse_id) REFERENCES warehouse (id),
    location_type_id INT NOT NULL,
    FOREIGN KEY (location_type_id) REFERENCES location_type (id),
    CONSTRAINT unique_location UNIQUE (rack, spot, level, warehouse_id)
);

CREATE TABLE IF NOT EXISTS ware_category (
    id SERIAL PRIMARY KEY,
    category_name VARCHAR(64) UNIQUE NOT NULL,
    description VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS ware (
    id SERIAL PRIMARY KEY,
    ware_name VARCHAR(64) UNIQUE NOT NULL,
    unit VARCHAR(10) NOT NULL,
    permit_decimal BIT NOT NULL DEFAULT '1',
    permit_decimal BIT NOT NULL DEFAULT '1',
    ean VARCHAR(13) UNIQUE,
    price DECIMAL(10,2),
    vat INT,
    weight DECIMAL(10,5),
    max_per_pallet INT,
    description VARCHAR(256),
    ware_category_id INT NOT NULL,
    FOREIGN KEY (ware_category_id) REFERENCES ware_category (id)
);

CREATE TABLE IF NOT EXISTS operation (
    id SERIAL PRIMARY KEY,
    operation_type INT NOT NULL,
    amount DECIMAL(10,5) NOT NULL,
    operation_time TIMESTAMP NOT NULL,
    expiration_date date,
    ware_id INT NOT NULL,
    FOREIGN KEY (ware_id) REFERENCES ware (id),
    location_id INT NOT NULL,
    FOREIGN KEY (location_id) REFERENCES location (id),
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES warehouse_user (id)
);

INSERT INTO warehouse_user (user_login, user_password, first_name, last_name)
    SELECT 'global_admin', 'change_me', 'Global', 'Admin' WHERE NOT EXISTS (SELECT user_login FROM warehouse_user WHERE user_login = 'global_admin');
INSERT INTO permission (permission, user_id)
    SELECT 63, 1 WHERE NOT EXISTS (SELECT user_id FROM permission WHERE user_id = 1);
