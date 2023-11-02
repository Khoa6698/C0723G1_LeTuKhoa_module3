<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/2/2023
  Time: 2:18 PM
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
    <label>Tên: <input type="text" name="title"></label><br>
    <label>Page size: <input type="number" name="pageSize"></label><br>
    <select name="author">
        <option value="1">Nguyễn Thái Học</option>
        <option value="2">Trần Minh Hoàng</option>
        <option value="3">Dương Trung Quốc</option>
        <option value="4">Lê Văn Hiếu</option>
        <option value="5">Hà Văn Minh</option>
    </select><br>
    <select name="category">
        <c:forEach items="${list}" var="ct">
            <option value="${ct.id}">${ct.name}</option>
        </c:forEach>
    </select><br>
    <input value="them moi" type="submit">
</form>
</body>
</html>
