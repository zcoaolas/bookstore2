<%--
  Created by IntelliJ IDEA.
  User: zcoaolas
  Date: 3/18/2017
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>Zen Bookstore</title>
</head>
<body>
<h1><small>Books Detail</small></h1>
<table>
    <c:forEach var="i" items="${book}">
        <tbody>
        <tr>
            <td>Book# ${i.bookId}</td><td>${i.bookName}</td>
        </tr>
        <tr>
            <td>Information</td><td>${i.bookInfo}</td>
        </tr>
        <tr>
            <td>Author</td><td>${i.bookAuthor}</td>
        </tr>
        <tr>
            <td>Category</td><td>${i.category}</td>
        </tr>
        <tr>
            <td>Price</td><td>$ ${i.bookPrice}</td>
        </tr>

        <form id="loginForm" action="${ctx }/book/bookAddCart?" method=POST>
            <input type="hidden" id="id" name="id" value="${i.bookId}">
            <input type="number" id="amount" name="amount">
            <div>
                <button type="submit" id="btn">Order it</button>
            </div>
        </form>
        </tbody>
    </c:forEach>
</table>

</body>
</html>
