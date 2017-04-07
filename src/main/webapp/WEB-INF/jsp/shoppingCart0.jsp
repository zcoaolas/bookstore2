<%@ page import="java.util.List" %>
<%@ page import="javafx.util.Pair" %><%--
  Created by IntelliJ IDEA.
  User: zcoaolas
  Date: 3/18/2017
  Time: 21:41
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

<h1><small>Shopping Cart</small></h1>
<c:if test="${!empty cart}">
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Number</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="i" items="${cart}">
        <tr>
            <td>${i.getKey().getBookId()}</td>
            <td>${i.getKey().getBookName()}</td>
            <td>${i.getKey().getBookPrice()}</td>
            <td>${i.getValue()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
    <div>
        <p>Total Price:   $ ${total.toString()}</p>
    </div>

    <form id="loginForm" action="${ctx }/cart/pay" method=POST>
        <div>
            Payment Password:
            <input type="password" id="password" name="password">
        </div>
        <div>
            <button type="submit" id="btn">Pay</button>
        </div>
    </form>
</c:if>

<c:if test="${empty cart}">
    <h2>Shopping Cart is Empty...</h2>
</c:if>

</body>
</html>
