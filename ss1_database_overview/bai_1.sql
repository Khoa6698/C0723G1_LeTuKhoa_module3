CREATE DATABASE book_management;
USE book_management;

CREATE TABLE books(
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(20),
page_size INT NOT NULL,
authur VARCHAR(50)
);
INSERT INTO books(id,title,page_size,authur)
VALUES(1,'Toán',45,'Nguyễn Thái Học'),
	(2,'VăN',34,'TrẦN Minh Hoàng'),
    (3,'Sử',56,'Dương TRUNG Quốc'),
    (4,'Địa',76,'Lê VĂN Hiếu'),
    (5,'Hóa',32,'Hà VĂn MinH');

-- CẬP nhật số trang pAge_size=50 với sách có title = "Sử" 
UPDATE books 
SET page_size =50
WHERE ID = 3;

-- XoÁ Sách có id =5
DELETE FROM books 
WHERE
    id = 5;

-- Xoá bẢNG books
DROP TABLE books;

-- Xoá cơ sở dữ liệu book_MANaGEMENt
DROP DATABASE book_management;

