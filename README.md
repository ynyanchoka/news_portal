# Organisational News Portal 
By Ymelda Monari



## Table of contents
+ [Description](#Description)
+ [User stories](#user-stories)
+ [Project resources](#project-resources)
+ [Setup/Installation Requirements](#setupinstallation-requirements)
+ [Technologies used](#technologies-used)
+ [Contact Information](#contact-information)
+ [Copyright and License](#copyright-and-license-information)


## Description
This is a REST API or querying and retrieving scoped news and information in an organisation. A user can create news,departments and employees.The news can be departmental or general news.

## User Stories
1. As a user, I should be able to create news(departmental and general),departments and employees.
2. As a user, I want to see individual users, their details, i.e position in the company, their roles, which department(s) they are associated with.
3. As a user, I want to see specific information such as the Departments name, description, number of employees in the department.
4. As a user, I want to be able to Post some news relating to a department.
5. As a user, I want to see all users from a specific Department, the news relating to that department.


## Setup/Installation Requirements
#### To recreate database:

1.Launch postgres

2.Type in psql -U (username) then run the following
- CREATE DATABASE newsportal;
- \c newsportal;

- CREATE TABLE department (id serial PRIMARY KEY, departmentname varchar, description varchar, departmentsize varchar);

- CREATE TABLE users (id serial PRIMARY KEY, name varchar, position varchar, role varchar, department varchar, departmentid int);
- CREATE TABLE news (id serial PRIMARY KEY, title varchar, description varchar, type varchar, departmentid int, createdat BIGINT);
- CREATE TABLE departments_staff (id serial PRIMARY KEY, userid int, departmentid int);

- CREATE DATABASE newsportal_test WITH TEMPLATE newsportal;

#### To clone the repository:
- Clone this repository using:
  git clone 'https://github.com/ynyanchoka/news_portal.git'
- Navigate to the directory:
  cd news_portal
- Open the directory with your preferred text editor.

## Technologies used
+ IntelliJ IDEA
+ Java
+ Gradle
+ Postgres




## Contact information
+ Ymelda Monari : `monaryymelda@gmail.com`

## Copyright and license information

Copyright (c) 2022 [click here to view license](LICENSE)