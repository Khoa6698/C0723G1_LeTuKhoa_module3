create database shop_manage;
use shop_manage;

create table loai_khach(
ma_loai_khach int primary key auto_increment,
ten_loai_khach varchar(45)
);
insert into loai_khach(ten_loai_khach)
values('Vip'),('Member'),('Other');

create table khach_hang(
ma_khach_hang int primary key auto_increment,
ho_ten varchar(45),
so_dien_thoai varchar(10),
email varchar(45),
loai_khach_hang int,
foreign key(loai_khach_hang) references `loai_khach`(ma_loai_khach)
);

create table may_tinh(
ma_may int primary key auto_increment,
hang_san_xuat varchar(50),
vi_tri_dat_may varchar(50)
);

create table dich_vu_di_kem(
ma_dich_vu_di_kem int primary key auto_increment,
ten_dich_vu_di_kem varchar(45),
gia double
);
insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia)
values('Nước ngọt',20000),('banh mì',15000),('mì tôm',10000);

create table dich_vu(
ma_dich_vu int primary key auto_increment,
ma_may int,
foreign key(ma_may) references `may_tinh`(ma_may),
ma_khach_hang int,
foreign key(ma_khach_hang) references `khach_hang`(ma_khach_hang),
thoi_gian_bat_dau datetime,
thoi_gian_ket_thuc datetime,
dich_vu_di_kem int,
foreign key(dich_vu_di_kem) references `dich_vu_di_kem`(ma_dich_vu_di_kem),
tong_tien_thanh_toan double
);