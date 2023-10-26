<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/24/2023
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="book?action=edit" method="post">
    <tr>
        <td><label for="id">Id Book: </label> </td>
        <td><input type="number" id="id" name="id" readonly value="${book.id}"></td>
    </tr><br>
    <tr>
        <td><label for="title">Title Book: </label> </td>
        <td><input type="text" id="title" name="title" value="${book.title}"></td>
    </tr><br>
    <tr>
        <td><label for="pageSize">Page Size Book: </label> </td>
        <td><input type="number" id="pageSize" name="pageSize" value="${book.pageSize}"></td>
    </tr><br>
    <tr>
        <td><label for="author">Author Book: </label> </td>
        <td><input type="text" id="author" name="author" value="${book.author}"></td>
    </tr><br>
    <tr>
        <td><label for="category">Category Book: </label> </td>
        <td><input type="text" id="category" name="category" value="${book.category}"></td>
    </tr><br>
    <tr>
        <td colspan="2"> <input type="submit" value="Save"></td>
    </tr>
</form>
<p><a href="/book">Back to Book list</a></p>
</body>
</html>
