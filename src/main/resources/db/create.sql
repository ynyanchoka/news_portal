CREATE TABLE IF NOT EXISTS department(
 id int PRIMARY KEY auto_increment,
 departmentname VARCHAR,
 description VARCHAR,
 departmentsize INTEGER
);

CREATE TABLE IF NOT EXISTS users (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 position VARCHAR,
 role VARCHAR,
 department VARCHAR,
 departmentid INT,
);

CREATE TABLE IF NOT EXISTS news (
 id int PRIMARY KEY auto_increment,
 title VARCHAR,
 description VARCHAR,
 departmentname VARCHAR,
 type VARCHAR,
);