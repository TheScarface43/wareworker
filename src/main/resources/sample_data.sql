INSERT INTO warehouse_user (login, password, is_enabled, first_name, last_name, email, telephone) VALUES ('admin', '12345', TRUE, 'John', 'Smith', 'john.smith@wareworker.com', '100200300');
INSERT INTO warehouse_type (name) VALUES ('Fruit & Car Warehouse');
INSERT INTO warehouse (name, location, warehouse_type_id) VALUES ('Main Warehouse', '66 Ware St., Madison, WI 53703', 1);
INSERT INTO ware_category (name) VALUES ('Fruits');
INSERT INTO ware_category (name) VALUES ('Cars');
INSERT INTO ware_category (name) VALUES ('Rocks');
INSERT INTO ware (name, unit, permit_decimal, ean, ware_category_id) VALUES ('Apple', 'pcs.', FALSE, '1234567890123', 1);
INSERT INTO ware (name, unit, permit_decimal, ean, ware_category_id) VALUES ('Pear', 'pcs.', FALSE, '2345678901234', 1);
INSERT INTO ware (name, unit, permit_decimal, ean, ware_category_id) VALUES ('Subaru Impreza', 'pcs.', FALSE, '3456789012345', 2);
INSERT INTO ware (name, unit, permit_decimal, ean, ware_category_id) VALUES ('Orange', 'pcs.', FALSE, '4567890123456', 1);
INSERT INTO ware (name, unit, permit_decimal, ean, ware_category_id) VALUES ('DeLorean', 'pcs.', FALSE, '5678901234567', 2);
INSERT INTO ware (name, unit, permit_decimal, ean, ware_category_id) VALUES ('Volkswagen Scirocco', 'pcs.', FALSE, '6789012345678', 2);
INSERT INTO ware (name, unit, permit_decimal, ean, ware_category_id) VALUES ('Granite', 'kg', TRUE, '7890123456789', 3);
INSERT INTO ware (name, unit, permit_decimal, ean, ware_category_id) VALUES ('Some long and obnoxious fruit name', 'pcs.', TRUE, '8901234567890', 1);
INSERT INTO location_type (name) VALUES ('Regular Pallet Space');
INSERT INTO location_type (name) VALUES ('Small Shelf');
INSERT INTO location_type (name) VALUES ('Car Parking Spot');
INSERT INTO location (rack, spot, level, warehouse_id, location_type_id) VALUES ('A', 1, 1, 1, 1);
INSERT INTO location (rack, spot, level, warehouse_id, location_type_id) VALUES ('A', 2, 1, 1, 1);
INSERT INTO location (rack, spot, level, warehouse_id, location_type_id) VALUES ('A', 3, 1, 1, 1);
INSERT INTO location (rack, spot, level, warehouse_id, location_type_id) VALUES ('A', 4, 1, 1, 1);
INSERT INTO location (rack, spot, level, warehouse_id, location_type_id) VALUES ('A', 5, 1, 1, 1);
INSERT INTO location (rack, spot, level, warehouse_id, location_type_id) VALUES ('A', 1, 2, 1, 1);
INSERT INTO location (rack, spot, level, warehouse_id, location_type_id) VALUES ('A', 2, 2, 1, 1);
INSERT INTO location (rack, spot, level, warehouse_id, location_type_id) VALUES ('A', 3, 2, 1, 1);
INSERT INTO location (rack, spot, level, warehouse_id, location_type_id) VALUES ('A', 4, 2, 1, 1);
INSERT INTO location (rack, spot, level, warehouse_id, location_type_id) VALUES ('A', 5, 2, 1, 1);
INSERT INTO location (rack, spot, level, warehouse_id, location_type_id) VALUES ('B', 1, 1, 1, 3);
INSERT INTO location (rack, spot, level, warehouse_id, location_type_id) VALUES ('B', 2, 1, 1, 3);
INSERT INTO location (rack, spot, level, warehouse_id, location_type_id) VALUES ('B', 3, 1, 1, 3);
INSERT INTO location (rack, spot, level, warehouse_id, location_type_id) VALUES ('B', 4, 1, 1, 3);
INSERT INTO location (rack, spot, level, warehouse_id, location_type_id) VALUES ('B', 5, 1, 1, 3);
INSERT INTO location (rack, spot, level, warehouse_id, location_type_id) VALUES ('Z', 1, 1, 1, 2);
INSERT INTO location (rack, spot, level, warehouse_id, location_type_id) VALUES ('Z', 2, 1, 1, 2);
INSERT INTO operation (type, amount, time, warehouse_user_id, ware_id, location_id) VALUES (1, 1440, '2024-01-23 09:48:32', 1, 1, 1);
INSERT INTO operation (type, amount, time, warehouse_user_id, ware_id, location_id) VALUES (1, 1440, '2024-01-23 10:01:13', 1, 1, 2);
INSERT INTO operation (type, amount, time, warehouse_user_id, ware_id, location_id) VALUES (1, 1440, '2024-01-23 10:05:58', 1, 1, 3);
INSERT INTO operation (type, amount, time, warehouse_user_id, ware_id, location_id) VALUES (1, 1440, '2024-01-23 10:16:27', 1, 2, 6);
INSERT INTO operation (type, amount, time, warehouse_user_id, ware_id, location_id) VALUES (1, 1440, '2024-01-23 10:19:33', 1, 2, 7);
INSERT INTO operation (type, amount, time, warehouse_user_id, ware_id, location_id) VALUES (1, 1, '2024-01-23 12:52:11', 1, 3, 11);
INSERT INTO operation (type, amount, time, warehouse_user_id, ware_id, location_id) VALUES (1, 1, '2024-01-23 12:59:40', 1, 5, 12);
INSERT INTO operation (type, amount, time, warehouse_user_id, ware_id, location_id) VALUES (1, 1, '2024-01-23 13:07:21', 1, 6, 14);
INSERT INTO operation (type, amount, time, warehouse_user_id, ware_id, location_id) VALUES (1, 60, '2024-01-23 14:15:37', 1, 4, 16);
INSERT INTO operation (type, amount, time, warehouse_user_id, ware_id, location_id) VALUES (1, 12, '2024-01-23 14:49:12', 1, 4, 16);
INSERT INTO operation (type, amount, time, warehouse_user_id, ware_id, location_id) VALUES (2, 24, '2024-01-24 08:05:25', 1, 1, 1);
INSERT INTO operation (type, amount, time, warehouse_user_id, ware_id, location_id) VALUES (2, 6, '2024-01-24 08:11:53', 1, 4, 16);
INSERT INTO operation (type, amount, time, warehouse_user_id, ware_id, location_id) VALUES (1, 560.25, '2024-01-24 11:22:33', 1, 7, 5);
INSERT INTO operation (type, amount, time, warehouse_user_id, ware_id, location_id) VALUES (1, 6, '2024-01-24 12:07:15', 1, 8, 16);