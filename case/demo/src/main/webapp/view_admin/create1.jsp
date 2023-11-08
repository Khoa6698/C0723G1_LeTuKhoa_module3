<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/3/2023
  Time: 3:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Haitenz.net</title>
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css"
    />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<style>

    html {
        font-family: Tahoma, Helvetica, Arial, sans-serif;
    }

    body {
        background-color: #EBEBEB;
    }

    .header {
        background-color: #721799;
    }

    ul {
        list-style-type: none;
    }

    a {
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }

    #header {
        position: sticky;
        top: 0;
        z-index: 100;
    }

    .log-in a {
        color: white;
    }

    .log-in a:hover {
        color: black;
        text-decoration: underline;
    }

    .navbar-nav li {
        margin: 0 10vh;
        padding: 0;
    }

    .navbar-nav li:hover {
        background-color: #b8c7d0;
    }

    .navbar-nav li:hover a {
        color: #721799;
    }

    .container h3 {
        padding: 1%;
        color: #074091;
    }

    button {
        border-radius: 10px;
    }

    .btn-create-search {
        width: 100px;
        margin: 0 10vh;
    }

</style>
<body>

<!--HEADER-->
<div id="header">
    <!-- Header-->
    <nav class="navbar navbar-light header">
        <div class="container">
            <a class="navbar-brand py-0" href="#">
                <img src="./img/Logo.jpg" alt="logo" width="100%" height="25">
            </a>
            <form class="d-flex w-50">
                <input class="form-control" type="search" placeholder="Nhập tên sách, tác giả hoặc thể loại để tìm"
                       aria-label="Search">
                <button class="btn btn-outline-light ms-1" type="submit">Search</button>
            </form>
            <ul class="d-flex m-0 log-in">
                <a class="d-flex" href="#">
                    <li>
                        <i class="fa-regular fa-user" style="color: #ffffff;"></i>
                    </li>
                    <li class="px-2"> Hi, admin-1</li>
                </a>

                <a class="d-flex" href="#">
                    <li>
                        <i class="fa-solid fa-right-to-bracket" style="color: #ffffff;"></i>
                    </li>
                    <li class="px-2">Đăng xuất</li>
                </a>
            </ul>
        </div>
    </nav>

    <!--    NAV BAR-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light p-0">
        <div class="container-fluid">
            <div class="collapse navbar-collapse d-flex justify-content-center align-items-center"
                 id="navbarSupportedContent">
                <ul class="navbar-nav mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Trang chủ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Quản lý nhân viên</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>

<!--MAIN-CONTENT-->
<div class="container" style="background-color: white; height: 100%">
    <div class="row">
        <h3>Thêm mới nhân viên ></h3>
    </div>

    <!--    BORROW DETAIL-->
    <div class="row">
        <div class="col-lg-4">
            <div class="card mb-3" style="width: 18rem;">
                <img src="https://tiemanhsky.com/wp-content/uploads/2020/03/61103071_2361422507447925_6222318223514140672_n_1.jpg"
                     class="card-img-top" alt="...">
            </div>
        </div>

        <div class="col-lg-8">
            <form action="/employee?action=create" method="post" enctype="multipart/form-data">
                <table class="table table-striped">
                    <tr>
                        <td>
                            <label>Nhân viên: <input type="text" value="name" name="name"></label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Ngày sinh: <input type="date" value="Ngày sinh" name="birthDay"></label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Số điện thoại: <input type="text" value="Số điện thoại" name="phone"></label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>Image: <input type="file" value="file ảnh" name="image"></label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <select name="accountId">
                                <c:forEach items="${list}" var="list">
                                    <option value="${list.id}">${list.name}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn-create-search btn-primary"><input type="submit" value="Thêm mới"></button>
                        </td>
                    </tr>
                    <%--                <tr>--%>
                    <%--                    <td>--%>
                    <%--                        Email:--%>
                    <%--                    </td>--%>
                    <%--                </tr>--%>
                    <%--                <tr>--%>
                    <%--                    <td>--%>
                    <%--                        Ngày vào làm:--%>
                    <%--                    </td>--%>
                    <%--                </tr>--%>
                </table>
            </form>
        </div>
    </div>

</div>

<!--FOOTER-->
<div class="card text-center mt-5">
    <div class="card-header">
        <img src="img/logo_footer.png" width="10%"/></div>
    <div class="card-body">
        <h5 class="card-title">Thư viện Online C0723G1 - Team 2</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary">Trở lại đầu trang</a>
    </div>
    <div class="card-footer text-muted">
        Since 2023
    </div>
</div>
</body>
</html>
