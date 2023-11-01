<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <a class="btn btn-outline-primary" href="/book?action=add" role="button">Them moi sách</a>
    <p><%=request.getParameter("mess")%></p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>STT</th>
            <th>Title</th>
            <th>Page Size</th>
            <th>Author</th>
            <th>Category</th>
            <th>Xóa</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="book" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${book.title}</td>
                <td>${book.pageSize}</td>
                <td>${book.author}</td>
                <td>${book.category.name}</td>
                <td>
                    <button type="button" class="btn btn-outline-danger"
                            data-bs-toggle="modal" data-bs-target="#exampleModal"
                            onclick="sendInf('${book.id}','${book.title}')">
                        Remove
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <form action="/book?action=delete" method="post">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Remove book</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" name="id" id="id">
                        Ban co chac chan xoa <span id="nameDel" class="text-danger"> </span> ?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-danger">Remove</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function sendInf(id, title) {
        document.getElementById("title").innerText = title;
        document.getElementById("id").value = id;
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>