<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<%@taglib prefix="mvc" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Bookstore</title>
</head>
<body>
<div>
    <a href="?lang=en_US">English</a> | <a href="?lang=zh_CN">中文</a>
</div>
<h2>
    <spring:message code="welcome" />
</h2>
<button onclick="window.location.href='${ctx}/user/userLogin'"><spring:message code="login" /></button>

<button onclick="window.location.href='${ctx}/user/userRegister'"><spring:message code="register" /></button>

<button onclick="window.location.href='${ctx}/chat'"><spring:message code="chatroom" /></button>
</body>
</html>

