-- Create database
DROP DATABASE IF EXISTS attendees_test;
CREATE DATABASE IF NOT EXISTS attendees_test;
-- Use database
USE attendees_test;
-- Drop tables
DROP TABLE IF EXISTS madison042025;
-- Create table
CREATE TABLE IF NOT EXISTS madison042025
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    first_name  VARCHAR(50),
    last_name   VARCHAR(50),
    email       VARCHAR(50),
    email_optin TINYINT(1),
    phone       VARCHAR(15),
    phone_optin TINYINT(1)
);

-- Sample data
INSERT INTO madison042025 (first_name, last_name, email, email_optin, phone, phone_optin)
VALUES ('jordy', 'fait', 'jordyfait@gmail.com', 0, '715-111-2233', 0),
       ('alby', 'fait', 'albyfait@gmail.com', 1, '608-555-1212', 1),
       ('juliet', 'fait', 'julietfait@gmail.com', 1, '608-100-2000', 0);