<%--
  Created by IntelliJ IDEA.
  User: drjr
  Date: 17-3-17
  Time: 下午3:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>Zen Bookstore</title>
</head>
<body>
<h1><small>Books on sale</small></h1>
<a href="${ctx }/cart/cartList">Shopping Cart</a>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Category</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var="i" items="${books}">
            <tr>
                <td>${i.bookId}</td>
                <td>
                    <a href="${ctx }/book/bookDetail?id=${i.bookId}">${i.bookName}</a>
                </td>
                <td>${i.category}</td>
                <td>$${i.bookPrice}</td>
            </tr>
        </c:forEach>
    </tbody>

</table>

<div>
    <a href="${ctx }/admin/adminCenter">Admin Center</a>
</div>
<div>
    <a href="${ctx }/user/userLogout">Log out</a>
</div>
</body>
</html>
