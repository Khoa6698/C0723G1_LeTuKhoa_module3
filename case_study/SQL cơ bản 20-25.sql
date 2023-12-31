USE case_study;

-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các
-- nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho một hoặc nhiều
-- khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.
CREATE VIEW v_nhan_vien AS
    SELECT 
        nv.ma_nhan_vien,
        nv.ho_ten,
        nv.email,
        nv.so_dien_thoai,
        nv.ngay_sinh,
        nv.dia_chi
    FROM
        nhan_vien nv
            JOIN
        hop_dong hd ON nv.ma_nhan_vien = hd.ma_nhan_vien
    WHERE
        nv.dia_chi LIKE '%Hải Châu%'
            AND hd.ngay_lam_hop_dong = '2019-12-12';

-- 22. Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành
--  “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
UPDATE v_nhan_vien
SET dia_chi = 'Liên Chiểu';

-- 23. Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với 
-- ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.
delimiter // 
CREATE PROCEDURE sp_xoa_khach_hang(
ma_khach_hang VARCHAR(45)
)
BEGIN
DELETE FROM khach_hang
WHERE ma_khach_hang = ma_khach_hang;
END //
delimiter ;

-- 24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong
-- với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu
-- bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu
-- đến các bảng liên quan.