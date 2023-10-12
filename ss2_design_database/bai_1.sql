create database library;
use library;

create table authors(
id int primary key auto_increment,
name varchar(50)
);

create table category(
id int primary key auto_increment,
name varchar(50)
);

create table books(
id int primary key auto_increment,
title varchar(50),
page_size int,
authors_id int,
category_id int,
foreign key(authors_id) references authors(id),
foreign key(category_id) references category(id)
);

create table students(
id int primary key auto_increment,
name varchar(50),
birthday date,
class_name varchar(10)
);

create table borrows(
id int primary key auto_increment,
students_id int,
books_id int,
borrow_date date,
return_date date,
foreign key(students_id) references students(id),
foreign key(books_id) references books(id)
);