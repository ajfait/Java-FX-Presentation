-- Create database
DROP DATABASE IF EXISTS attendees;
CREATE DATABASE IF NOT EXISTS attendees;
-- Use database
USE attendees;
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
    phone       INT(10),
    phone_optin TINYINT(1)
);