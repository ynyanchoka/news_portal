CREATE TABLE IF NOT EXISTS department(
 id int PRIMARY KEY auto_increment,
 departmentname VARCHAR,
 description VARCHAR,
 departmentsize INTEGER
);

CREATE TABLE IF NOT EXISTS users (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 positions VARCHAR,
 role VARCHAR,
 department VARCHAR,
);