<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/26/2023
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="book?action=new" method="post">
    <tr>
        <td><label for="title">Title Book: </label></td>
        <td><input type="text" id="title" name="title" required></td>
    </tr>
    <br>
    <tr>
        <td><label for="pageSize">Page Size Book: </label></td>
        <td><input type="number" id="pageSize" name="pageSize" required></td>
    </tr>
    <br>
    <tr>
        <td><label for="author">Author Book: </label></td>
        <td><input type="text" id="author" name="author" required></td>
    </tr>
    <br>
    <tr>
        <td><label for="category">Category Book: </label></td>
        <td><input type="text" id="category" name="category" required></td>
    </tr>
    <br>
    <tr>
        <td colspan="2"><input type="submit" value="Add"></td>
    </tr>
</form>
</body>
</html>
