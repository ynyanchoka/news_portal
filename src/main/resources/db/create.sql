CREATE TABLE IF NOT EXISTS department(
 id int PRIMARY KEY auto_increment,
 departmentname VARCHAR,
 description VARCHAR,
 departmentsize INTEGER
);

CREATE TABLE IF NOT EXISTS user (
 id int PRIMARY KEY auto_increment,
 name VARCHAR,
 position VARCHAR,
 role VARCHAR,
 department VARCHAR,
);