USE library;

-- Tao index cho cột  title của bảng books
create index books_title on books(title);

-- Tạo 1 view để lấy ra danh sách các quyển sách đã được mượn, có hiển thị thêm cột số lần đã được mượn
CREATE VIEW books_view AS
    (SELECT 
        b.title, COUNT(b.id) AS so_luong
    FROM
        books b
            JOIN
        borrows br ON b.id = br.books_id);
        
-- Viết 1 stored procedure thêm mới book trong database với tham số kiểu IN
delimiter //
create procedure books_procedure( title varchar(50), page_size int, authors_id int, category_id int)
   begin 
   insert into books (title, page_size, authors_id, category_id)
   values(title, page_size, authors_id, category_id);
   end // 
  delimiter ;
  
call books_procedure ('sinh', 50, 2,1);