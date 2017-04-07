<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>

<html>
<head>
    <title>Bookstore</title>
</head>
<body>

<h2>Welcome to Zen Bookstore</h2>

<button onclick="window.location.href='${ctx }/user/userLogin'">Log in</button>

<button onclick="window.location.href='${ctx }/user/userRegister'">Register</button>


</body>
</html>

