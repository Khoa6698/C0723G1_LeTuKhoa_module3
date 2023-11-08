<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 11/7/2023
  Time: 2:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container" style="background-color: white; height: 100%">
    <div class="row">
        <h3>Sách bạn muốn tìm có thể là ></h3>
    </div>
    <c:choose>
        <c:when test="${book.size()!=0}">
            <c:forEach items="${book}" var="list">
                <!--    BORROW DETAIL-->
                <div class="row">
                    <div class="col-lg-4">
                        <div class="card mb-3" style="width: 18rem;">
                            <img src="${list.img}" class="card-img-top" alt="Avatar">
                        </div>
                    </div>

                    <div class="col-lg-8">
                        <table class="table table-striped">
                            <tr>
                                <td>
                                    Tên sách: ${list.name}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Năm phát hành: ${list.publishYear}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Tên tác giả: ${list.author}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Thể loại: ${list.bookType}
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Số lượng: ${list.bookQuantity}
                                </td>
                            </tr>
                        </table>
                    </div>
                </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
            <h2 class="text-warning"> Không có sách nào với từ bạn đang tìm</h2>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>
