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
id_authors int,
id_category int,
foreign key(id_authors) references authors(id),
foreign key(id_category) references category(id)
);

create table students(
id int primary key auto_increment,
name varchar(50),
birthday date,
class_name varchar(10)
);

create table borrows(
students_id int,
books_id int,
borrow_date date,
return_date date,
primary key(students_id,books_id),
foreign key(students_id) references students(id),
foreign key(books_id) references books(id)
);