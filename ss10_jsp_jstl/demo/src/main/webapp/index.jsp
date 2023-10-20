<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>LIST STUDENT</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">NAME</th>
        <th scope="col">GENDER</th>
        <th scope="col">POINT</th>
        <th scope="col">CLASSIFICATION</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${studentList}" varStatus="loop" var="student">
        <tr>
            <th scope="row">${loop.count}</th>
            <td>${student.name}</td>
            <td>${student.gender}</td>
            <td>${student.point}</td>
            <td>
                <c:if test="${student.point < 6}">
                    <p>Yếu</p>
                </c:if>
                <c:if test="${student.point >= 6 && student.point < 8}">
                    <p>Trung bình</p>
                </c:if>
                <c:if test="${student.point >= 8 && student.point < 9}">
                    <p>Khá</p>
                </c:if>
                <c:if test="${student.point >= 9}">
                    <p>Giỏi</p>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>