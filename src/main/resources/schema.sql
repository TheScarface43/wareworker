CREATE TABLE IF NOT EXISTS warehouse_user (
    user_id SERIAL PRIMARY KEY,
    login VARCHAR(64) UNIQUE NOT NULL,
    password CHAR(85) NOT NULL,
    enabled BIT NOT NULL DEFAULT 1,
    first_name VARCHAR(32) NOT NULL,
    last_name VARCHAR(32) NOT NULL,
    email VARCHAR(64),
    telephone VARCHAR(15)
);

CREATE TABLE IF NOT EXISTS warehouse_type (
    warehouse_type_id SERIAL PRIMARY KEY,
    name VARCHAR(64) UNIQUE NOT NULL,
    description VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS warehouse (
    warehouse_id SERIAL PRIMARY KEY,
    name VARCHAR(64) UNIQUE NOT NULL,
    location VARCHAR(128),
    description VARCHAR(256),
    warehouse_type_id INT NOT NULL,
    FOREIGN KEY (warehouse_type_id) REFERENCES warehouse_type (warehouse_type_id)
);

CREATE TABLE IF NOT EXISTS permission (
    permission_id SERIAL PRIMARY KEY,
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
    FOREIGN KEY (user_id) REFERENCES warehouse_user (user_id),
    warehouse_id INT,
    FOREIGN KEY (warehouse_id) REFERENCES warehouse (warehouse_id),
    CHECK (permission >= 32 or warehouse_id is not null)
);

CREATE TABLE IF NOT EXISTS location_type (
    location_type_id SERIAL PRIMARY KEY,
    name VARCHAR(64)
);

CREATE TABLE IF NOT EXISTS location (
    location_id SERIAL PRIMARY KEY,
    rack VARCHAR(16) NOT NULL,
    spot INT NOT NULL,
    level INT NOT NULL,
    warehouse_id INT NOT NULL,
    FOREIGN KEY (warehouse_id) REFERENCES warehouse (warehouse_id),
    location_type_id INT NOT NULL,
    FOREIGN KEY (location_type_id) REFERENCES location_type (location_type_id),
    CONSTRAINT unique_location UNIQUE (rack, spot, level, warehouse_id)
);

CREATE TABLE IF NOT EXISTS ware_category (
    ware_category_id SERIAL PRIMARY KEY,
    name VARCHAR(64) UNIQUE NOT NULL,
    description VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS ware (
    ware_id SERIAL PRIMARY KEY,
    name VARCHAR(64) UNIQUE NOT NULL,
    unit VARCHAR(10) NOT NULL,
    permit_decimal BIT NOT NULL DEFAULT 1,
    ean VARCHAR(13) UNIQUE,
    price DECIMAL(10,2),
    vat INT,
    weight DECIMAL(10,5),
    max_per_pallet INT,
    description VARCHAR(256),
    ware_category_id INT NOT NULL,
    FOREIGN KEY (ware_category_id) REFERENCES ware_category (ware_category_id)
);

CREATE TABLE IF NOT EXISTS operation (
    operation_id SERIAL PRIMARY KEY,
    type INT NOT NULL,
    amount DECIMAL(10,5) NOT NULL,
    operation_timestamp TIMESTAMP NOT NULL,
    expiration_date date,
    ware_id INT NOT NULL,
    FOREIGN KEY (ware_id) REFERENCES ware (ware_id),
    location_id INT NOT NULL,
    FOREIGN KEY (location_id) REFERENCES location (location_id),
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES warehouse_user (user_id)
);

INSERT INTO warehouse_user (login, password, first_name, last_name) VALUES ('global_admin', 'change_me', 'Global', 'Admin');
INSERT INTO permission (permission, user_id) VALUES (63, 1);
