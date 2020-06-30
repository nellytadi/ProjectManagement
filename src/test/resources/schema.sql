CREATE SEQUENCE IF NOT EXISTS employee_seq;

CREATE TABLE IF NOT EXISTS employee (

employee_id BIGINT NOT NULL DEFAULT nextval('employee_seq') PRIMARY KEY,
email VARCHAR(100) NOT NULL,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL

);

CREATE SEQUENCE IF NOT EXISTS project_seq;

CREATE TABLE IF NOT EXISTS project (

project_id BIGINT NOT NULL DEFAULT nextval('project_seq') PRIMARY KEY,
name VARCHAR(100) NOT NULL,
stage VARCHAR(100) NOT NULL,
description VARCHAR(500) NOT NULL

);


CREATE TABLE IF NOT EXISTS project_employee (

project_id BIGINT REFERENCES project, 
employee_id BIGINT REFERENCES employee

);


CREATE SEQUENCE IF NOT EXISTS user_seq;

CREATE TABLE IF NOT EXISTS users (

user_id BIGINT NOT NULL DEFAULT nextval('user_seq') PRIMARY KEY,
full_name VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
password VARCHAR(100) NOT NULL

);
