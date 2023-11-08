<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/5/2023
  Time: 9:00 AM
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
    <script src="https://www.gstatic.com/firebasejs/7.7.0/firebase-app.js"></script>
    <script src="https://www.gstatic.com/firebasejs/7.7.0/firebase-storage.js"></script>
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

    .form-control-plaintext {
        color: unset;
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
                        <a class="nav-link" href="/employee">Quản lý nhân viên</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</div>

<!--MAIN-CONTENT-->
<div class="container" style="background-color: white; height: 100%">
    <div class="row">
        <h3>Chỉnh sửa nhân viên ></h3>
    </div>
    <form id="form-submit" action="/employee?action=update" method="post">
        <!--    BORROW DETAIL-->
        <div class="row">
            <div class="col-lg-4">
                <div class="card mb-3" style="width: 18rem;">
                    <img src="${employee.img}" class="card-img-top" alt="avatar">
                </div>
            </div>
            <div class="col-lg-8">
                <table class="table table-striped">
                    <tr>
                        <td>
                            <div class="row">
                                <label for="id" class="col-sm-2 col-form-label">Id:</label>
                                <div class="col-sm-10">
                                    <input type="text" readonly class="form-control-plaintext" id="id" name="id"
                                           value="${employee.id}">
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="row">
                                <label for="name" class="col-sm-2 col-form-label">Nhân viên:</label>
                                <div class="col-sm-10">
                                    <input type="text" oninput="checkName()" required class="form-control-plaintext" id="name" name="name"
                                           value="${employee.name}">
                                    <small style="color: red" id="errorName"></small>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="row">
                                <label for="birthDay" class="col-sm-2 col-form-label">Ngày sinh:</label>
                                <div class="col-sm-10">
                                    <input type="date" required class="form-control-plaintext" id="birthDay"
                                           name="birthDay"
                                           value="${employee.birthDay}">
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="row">
                                <label for="phone" class="col-sm-2 col-form-label">Số điện thoại:</label>
                                <div class="col-sm-10">
                                    <input type="text" oninput="checkPhone()"  required class="form-control-plaintext" id="phone" name="phone"
                                           value="${employee.phone}">
                                    <small style="color: red" id="errorPhone"></small>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="row">
                                <label for="file-img" class="col-sm-2 col-form-label">Link Ảnh:</label>
                                <div class="col-sm-10">
                                    <input  id="file-img" type="file">
                                    <input name="img" hidden="hidden" type="text" id="img-url">
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="row">
                                <label for="accountId" class="col-sm-2 col-form-label">Username</label>
                                <div class="col-sm-10">
                                    <input type="text" readonly class="form-control-plaintext" id="accountId"
                                           name="accountId"
                                           value="${employee.account.id}">Tên account ${employee.account.name}
                                </div>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button class="btn-warning" onclick="save()" type="submit" disabled id="btn-send">Sửa</button>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </form>
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
<form>

    <button onclick="save()" type="button">save</button>
</form>
<script>
    function checkName() {
        let name = document.getElementById("name").value;
        let regName =/^([A-Z][a-z]+)(\s([A-Z][a-z]+))*$/;
        let checkName = regName.test(name);
        if (name==""){
            document.getElementById("errorName").innerText="Yêu cầu phải nhập tên";
            document.getElementById("btn-send").disabled= true;
            document.getElementById("btn-send").style.background= 'gray';
        }else if (!checkName) {
            document.getElementById("errorName").innerText="Tên không đúng định dạng";
            document.getElementById("btn-send").disabled= true;
            document.getElementById("btn-send").style.background= 'gray';
        } else {
            document.getElementById("errorName").innerText="";
            document.getElementById("btn-send").disabled= false;
            document.getElementById("btn-send").style.background= 'green';
        }
    }

    function checkPhone(){
        let phone = document.getElementById("phone").value;
        let regPhone =/((09|03|07|08|05)+([0-9]{8})\b)/g;
        let checkPhone = regPhone.test(phone);
        if (phone==""){
            document.getElementById("errorPhone").innerText="Yêu cầu phải nhập số điên thoại";
            document.getElementById("btn-send").disabled= true;
            document.getElementById("btn-send").style.background= 'gray';
        }else if (!checkPhone) {
            document.getElementById("errorPhone").innerText="Số điện thoại không đúng định dạng";
            document.getElementById("btn-send").disabled= true;
            document.getElementById("btn-send").style.background= 'gray';
        } else {
            document.getElementById("errorPhone").innerText="";
            document.getElementById("btn-send").disabled= false;
            document.getElementById("btn-send").style.background= 'green';
        }
    }

    const firebaseConfig = {
        apiKey: "AIzaSyBdEoSfhh9piQTDMGx6K_jT2YRAfUrk_TI",
        authDomain: "project-module-3-212d5.firebaseapp.com",
        projectId: "project-module-3-212d5",
        storageBucket: "project-module-3-212d5.appspot.com",
        messagingSenderId: "962059435626",
        appId: "1:962059435626:web:d72e220b5a733687645413"
    };
    // Initialize Firebase
    firebase.initializeApp(firebaseConfig);
    function save() {
        // lưu hình ảnh lên firebase => firebase trả về một đường dẫn => sau đó mới submit lên server
        // Initialize Firebase
        const ref = firebase.storage().ref();
        const file = document.querySelector("#file-img").files[0];
        const name = +new Date() + "-" + file.name;
        const metadata = {
            contentType: file.type
        };
        const task = ref.child(name).put(file, metadata);
        console.log("task: ", task);
        task
            .then(snapshot => snapshot.ref.getDownloadURL())
            .then(url => {
                console.log(url);
                alert('image uploaded successfully', url);
                document.getElementById("img-url").value = url;
                document.getElementById("form-submit").submit();
            })
            .catch(() => {
                alert("Error Image!!!!!!!!!")
            });
    }
</script>
</body>
</html>
