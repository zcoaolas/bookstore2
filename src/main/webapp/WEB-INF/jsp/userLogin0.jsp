<%--
  Created by IntelliJ IDEA.
  User: zcoaolas
  Date: 3/14/2017
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>
    <small>Log in</small>
</h1>
<form id="loginForm" action="${ctx }/user/userLogin" method=POST>
    <div>
        Username:
    </div>
    <div>
        <input title="Username" type="text" id="username" name="username">
    </div>
    <div>
        Password:
    </div>
    <div>
        <input title="Password" type="password" id="password" name="password">
    </div>
    <div>
        <button type="submit" id="btn">Log in</button>
    </div>
</form>
</body>
</html>
