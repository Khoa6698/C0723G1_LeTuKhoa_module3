use library;

--  Thông kê các đầu sách được mượn nhiều nhất
SELECT 
    b.title, COUNT(b.id) AS max
FROM
    books b
        JOIN
    borrows br ON b.id = br.books_id
GROUP BY b.id
HAVING max IN (SELECT 
        MAX(max)
    FROM
        (SELECT 
            COUNT(b.id) AS max, b.title
        FROM
            books b
        JOIN borrows br ON b.id = br.books_id
        GROUP BY b.id) AS so_luong);
        
-- Thông kê các đầu sách chưa được mượn
SELECT 
    b.id
FROM
    books b
WHERE
    id NOT IN (SELECT 
            b.id
        FROM
            books b
                JOIN
            borrows br ON b.id = br.books_id);

-- Lấy ra danh sách các học viên đã từng mượn sách và sắp xếp theo số lượng mượn sách từ lớn đến nhỏ
SELECT 
    s.name, COUNT(s.id) AS so_luong
FROM
    students s
        JOIN
    borrows br ON s.id = br.students_id
GROUP BY s.id
ORDER BY so_luong DESC;

-- Lấy ra các học viên mượn sách nhiều nhất của thư viện
SELECT 
    s.name, COUNT(s.id) AS so_luong
FROM
    students s
        JOIN
    borrows br ON s.id = br.students_id
GROUP BY s.id
ORDER BY so_luong DESC
LIMIT 1;

                 