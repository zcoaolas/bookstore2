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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <![endif]-->
    <title>Zen Bookstore</title>
    <!-- BOOTSTRAP CORE STYLE  -->
    <link href="${ctx}/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONT AWESOME STYLE  -->
    <link href="${ctx}/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- DATATABLE STYLE  -->
    <link href="${ctx}/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
    <!-- CUSTOM STYLE  -->
    <link href="${ctx}/assets/css/style.css" rel="stylesheet" />
    <!-- GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />

</head>
<style>
    body{
        /*Set the background picture on the bottom left*/
        background-image:url("/assets/img/bg_book.jpg");
        background-repeat:no-repeat;
        background-attachment:fixed;
        background-position:left bottom;
    }
</style>
<body>
<div class="navbar navbar-inverse set-radius-zero" >
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">
                <img src="${ctx}/assets/img/logo.png" />
            </a>

        </div>
    </div>
</div>
<!-- LOGO HEADER END-->

<div class="content-wrapper">
    <div class="container">
    <div style="padding-left: 25%; padding-right: 25%">
    <div class="panel panel-info">
        <div class="panel-heading">
            LOG IN
        </div>
        <div class="panel-body">
            <form role="form" id="loginForm" action="${ctx }/user/userLogin" method=POST>
                <div class="form-group">
                    <label>Username</label>
                    <input class="form-control" type="text" id="username" name="username" />

                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input class="form-control" type="password" id="password" name="password" />

                    <p class="help-block" style="color: red"></p>
                </div>
                <button type="submit" class="btn btn-info" style="float: right">Log In </button>

            </form>
        </div>
    </div>
</div>
    </div>
</div>

<!-- FOOTER SECTION END-->
<!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
<!-- CORE JQUERY  -->
<script src="${ctx}/assets/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS  -->
<script src="${ctx}/assets/js/bootstrap.js"></script>
<!-- CUSTOM SCRIPTS  -->
<script src="${ctx}/assets/js/custom.js"></script>
</body>
</html>
