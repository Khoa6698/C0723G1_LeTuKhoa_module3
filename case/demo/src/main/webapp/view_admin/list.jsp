<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/3/2023
  Time: 3:26 PM
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
            <form class="d-flex w-50" action="/book?action=search" method="post">
                <input class="form-control" type="search" placeholder="Nhập tên sách, tác giả hoặc thể loại để tìm"
                       aria-label="Search" name="name">
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
        <h3>Quản lý nhân viên ></h3>
    </div>
    <div class="row">
        <ul class="d-flex justify-content-center align-items-center">
            <li>
                <!-- Button trigger modal -->
                <button type="button" class="btn-create-search btn-success" data-bs-toggle="modal"
                        data-bs-target="#create">
                    Thêm mới
                </button>
            </li>
            <li>
                <button type="button" class="btn-create-search btn-primary" data-bs-toggle="modal"
                        data-bs-target="#search">
                    Tìm kiếm
                </button>
            </li>
        </ul>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-8">
            <table class="table table-striped table-hover">
                <tr>
                    <th>User</th>
                    <th>Tên</th>
                    <th>Chi tiết</th>
                    <th>Sửa</th>
                    <th>Xóa</th>
                </tr>
                <c:forEach items="${list}" var="list">
                    <tr>
                        <td>${list.account.name}</td>
                        <td>${list.name}</td>
                        <td>
                            <a href="/employee?action=detail&id=${list.id}">Chi tiết</a>
                        </td>
                        <td>
                            <button class="btn-warning" style="color: white"><a
                                    href="/employee?action=update&id=${list.id}">Sửa</a></button>
                        </td>
                        <td>
                            <button class="btn-danger" data-bs-toggle="modal" data-bs-target="#delete"
                                    onclick="send('${list.id}','${list.name}')">Xoá
                            </button>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <div class="modal fade" id="search" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <form action="/employee?action=search" method="post">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel1">Tìm kiếm theo tên</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <input class="form-control me-2" type="search" placeholder="Nhập tên nhân viên"
                                       name="name">
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button class="btn btn-outline-success" type="submit">Search</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog">
                    <form action="/employee?action=delete" method="post">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h1 class="modal-title fs-5" id="exampleModalLabel">Remove book</h1>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <input type="hidden" name="id" id="id">
                                Ban co chac chan xoa <span id="name" class="text-danger"> </span> ?
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn-danger" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn-danger">Remove</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="create" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <form action="/employee?action=create" method="post">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabel">Thêm mới</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"
                                        aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <div class="mb-3">
                                    <label for="username" class="form-label">User name(*): </label><br>
                                    <input type="text" class="form-control" placeholder="Username" aria-label="Username"
                                           aria-describedby="basic-addon1" name="name" id="username"
                                           onchange="handleValidBtn()" oninput="handleValidBtn()">
                                    <div style="display: none" class="alert alert-danger" role="alert" id="err-username"></div>
                                </div>
                                <div class="mb-3">
                                    <label for="password" class="form-label">Password: </label><br>
                                    <input type="text" class="form-control" id="password" name="passWord" placeholder="Password"
                                           onchange="handleValidBtn()" oninput="handleValidBtn()">
                                    <div style="display: none" class="alert alert-danger" role="alert" id="err-password"></div>
                                </div>
                                <div class="mb-3 form-check">
                                    <label for="type" class="form-label">Type account: </label><br>
                                    <input type="text" class="form-control" id="type" placeholder="Username"
                                           aria-label="Username"
                                           aria-describedby="basic-addon1" name="typeAc" readonly value="employee">
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn-danger" data-bs-dismiss="modal">Close</button>
                                <button type="submit" class="btn-danger" onclick="handleClickBtn()" id="btn-send">Thêm
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
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
<script>
    function handleClickBtn() {
        const btnSend = document.getElementById("btn-send");
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;
        const regName = /^[a-zA-Z]{3,16}$/;
        // /^([A-Z][a-z]+)(\s([A-Z][a-z]+))*$/
        const checkName = regName.test(username);
        if (btnSend.getAttribute("type") === 'button') {
            if (!username) {
                document.getElementById("err-username").innerText = "Yêu cầu phải nhập tên";
                document.getElementById("err-username").style.display = "block";
            }else if (!checkName){
                document.getElementById("err-username").innerText = "Tên không đúng định dạng";
                document.getElementById("err-username").style.display = "block";
            }
            if (!password) {
                document.getElementById("err-password").innerText = "Yêu cầu phải nhập mật khẩu";
                document.getElementById("err-password").style.display = "block";
            }
        }
    }

    function handleValidBtn() {
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;
        const btnSend = document.getElementById("btn-send");
        const regName = /^[a-zA-Z]{3,16}$/;
        // /^([A-Z][a-z]+)(\s([A-Z][a-z]+))*$/
        const checkName = regName.test(username);
        if (username) {
            document.getElementById("err-username").style.display = "none";
        }else if(checkName){
            document.getElementById("err-username").style.display = "none";
        }
        if (password) {
            document.getElementById("err-password").style.display = "none";
        }
        if (username && password) { //da nhap
            btnSend.setAttribute('type', 'submit');
            btnSend.setAttribute("class", "btn-danger")
        } else { // chua nhap
            btnSend.setAttribute('type', 'button');
            btnSend.setAttribute('class', "btn-secondary")
        }
    }

    handleValidBtn()
</script>
<script>
    function send(id, name) {
        document.getElementById("id").value = id;
        document.getElementById("name").innerText = name;
    }

    function checkName() {
        let name = document.getElementById("username").value;
        let regName = /^([A-Z][a-z]+)(\s([A-Z][a-z]+))*$/;
        let checkName = regName.test(name);
        if (name == "") {
            document.getElementById("errorName").innerText = "Yêu cầu phải nhập tên";
            document.getElementById("btn-send").disabled = true;
            document.getElementById("btn-send").style.background = 'gray';
        } else if (!checkName) {
            document.getElementById("errorName").innerText = "Tên không đúng định dạng";
            document.getElementById("btn-send").disabled = true;
            document.getElementById("btn-send").style.background = 'gray';
        } else {
            document.getElementById("errorName").innerText = "";
            document.getElementById("btn-send").disabled = false;
            document.getElementById("btn-send").style.background = 'green';
        }
    }
</script>
</body>
</html>
