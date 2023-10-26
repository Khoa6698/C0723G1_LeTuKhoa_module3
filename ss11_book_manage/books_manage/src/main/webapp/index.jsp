<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Book Manage</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<form class="d-flex" role="search" action="/book?action=search" method="post">
    <input class="form-control me-2" type="search" placeholder="Nhap ten sach"  name="title">
    <button class="btn btn-outline-success" type="submit">Search</button>
</form>
<table class="table">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Title</th>
        <th scope="col">pageSize</th>
        <th scope="col">Author</th>
        <th scope="col">Category</th>
        <th scope="col">Update</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="books" varStatus="loop">
        <tr>
            <th scope="row">${loop.count}</th>
            <td>${books.title}</td>
            <td>${books.pageSize}</td>
            <td>${books.author}</td>
            <td>${books.category}</td>
            <td><a href="book?action=edit&id=${books.id}">Update</a></td>
            <td><a href="book?action=delete&id=${books.id}">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<tr>
    <th><a href="/new_book.jsp">Add new book</a></th>
</tr>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>