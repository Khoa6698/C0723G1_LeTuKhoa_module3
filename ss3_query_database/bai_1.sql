use library;
insert into category(id,name)
values(1,'Tự nhiên'),(2,'Xã hội'),(3,'Truyện'),(4,'Tiểu thuyết'),(5,'Khác');

insert into authors(id, name)
values(1,'Nguyễn Thái Học'),(2,'Trần Minh Hoàng'),
(3,'Dương Trung Quốc'),(4,'Lê Văn Hiếu'),(5,'Hà Văn Minh');

insert into students(id,name,birthday,class_name)
values(1,'Nguyễn Văn A','1999-12-12','C0822G1'),(2,'Nguyễn Văn B','1999-12-13','C0822G1'),
(3,'Nguyễn Văn C','1999-12-14','C0822G1'),(4,'Nguyễn Văn D','1999-12-15','C0922G1'),
(5,'Nguyễn Văn E','1999-12-16','C0122G1');

insert into books(id,title,page_size,authors_id,category_id)
values(1,'Toán',45,1,1),(2,'Văn',34,2,2),(3,'Sử',56,3,2),(4,'Địa',76,4,2),(5,'Hóa',32,5,1);

insert into borrows(id,students_id,books_id,borrow_date,return_date)
values(1,1,1,'2022-12-12','2022-12-13'),
(2,2,2,'2022-12-12','2022-12-15'),(3,3,3,'2022-12-12','2022-12-15'),
(4,4,4,'2022-12-12','2022-12-12'),(5,1,5,'2022-12-13','2022-12-15'),
(6,1,5,'2022-12-14','2022-12-14'),(7,3,4,'2022-12-15','2022-12-29'),
(8,3,3,'2022-12-08','2022-12-14'),(9,1,2,'2022-12-06','2022-12-30');


-- Lấy ra toàn bộ sách có trong thư viện, cùng với tên thể loại và tác giả
SELECT 
    b.id , b.title, c.name, a.name
FROM
    books b
        JOIN
    category c ON c.id = b.category_id
        JOIN
    authors a ON b.authors_id = a.id;

-- Lấy ra danh sách các học viên đã từng mượn sách và sắp xếp danh sách theo theo tên từ a->z
SELECT 
    students.*, borrows.borrow_date, borrows.return_date
FROM
    students
        JOIN
    borrows ON students.id = borrows.students_id
WHERE
    books_id >= 1
ORDER BY students.name;

--  Lấy ra  2 quyển sách được mượn nhiều nhất
SELECT 
    b.title, COUNT(b.id) AS max
FROM
    books b
        JOIN
    category c ON c.id = b.category_id
        JOIN
    authors a ON b.authors_id = a.id
        JOIN
    borrows ON borrows.books_id = b.id
GROUP BY b.id
HAVING max IN (SELECT 
        MAX(max)
    FROM
        (SELECT 
            b.title, COUNT(b.id) AS max
        FROM
            books b
        JOIN borrows ON borrows.books_id = b.id
        GROUP BY b.id) bt)
LIMIT 2;
       