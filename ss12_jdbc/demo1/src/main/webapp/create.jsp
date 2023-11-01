<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 10/31/2023
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/book?action=create" method="post">
    <label>Id</label>
    <label>Tên: <input type="text" name="title"></label>
    <label>Page size: <input type="number" name="pageSize"></label>
    <label>Author: <input type="number" name="author"></label>
    <select name="categoryId">
        <c:forEach items="${list}" var="category">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <input value="them moi" type="submit">
</form>
</body>
</html>
