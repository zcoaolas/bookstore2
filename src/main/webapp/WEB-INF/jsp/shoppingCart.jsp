<%--
  Created by IntelliJ IDEA.
  User: zcoaolas
  Date: 3/18/2017
  Time: 21:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <!--[if IE]>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <![endif]-->
    <title>Zen Bookstore</title>
    <!-- BOOTSTRAP CORE STYLE  -->
    <link href="${ctx}/assets/css/bootstrap.css" rel="stylesheet"/>
    <!-- FONT AWESOME STYLE  -->
    <link href="${ctx}/assets/css/font-awesome.css" rel="stylesheet"/>
    <!-- DATATABLE STYLE  -->
    <link href="${ctx}/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet"/>
    <!-- CUSTOM STYLE  -->
    <link href="${ctx}/assets/css/style.css" rel="stylesheet"/>
    <!-- GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'/>

</head>
<body>

<section class="menu-section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <a class="navbar-brand zen_logo" href="${ctx}/book/bookList">
                    <img src="${ctx}/assets/img/logo.png"/>
                </a>
                <div class="navbar-collapse collapse ">
                    <ul id="menu-top" class="nav navbar-nav navbar-right">
                        <shiro:hasRole name="admin">
                            <li>
                                <a href="#" class="dropdown-toggle" id="ddlmenuItem" data-toggle="dropdown">Admin Only
                                    <i class="fa fa-angle-down"></i></a>
                                <ul class="dropdown-menu" role="menu" aria-labelledby="ddlmenuItem">
                                    <li role="presentation"><a role="menuitem" tabindex="-1"
                                                               href="${ctx}/admin/adminCenter">Info Tables</a></li>
                                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Manage Info</a>
                                    </li>
                                </ul>
                            </li>
                        </shiro:hasRole>
                        <li><a href="${ctx}/book/bookList">Books on sale</a></li>
                        <li><a href="${ctx}/order/showOrder">History Orders</a></li>
                        <li><a href="${ctx}/cart/cartList" class="menu-top-active">Shopping Cart</a></li>
                        <%--<li><a href="${ctx}/admin/adminCenter" class="menu-top-active" >Admin Only</a></li>--%>

                        <li><a href="${ctx}/user/userLogout" class="btn btn-info pull-right">LOG ME OUT</a></li>
                    </ul>
                </div>

            </div>

        </div>
    </div>
</section>
<!-- MENU SECTION END-->

<div class="content-wrapper">
    <div class="container">
        <div class="row pad-botm">
            <div class="col-md-12">
                <h4 class="header-line">SHOPPING CART</h4>
            </div>
        </div>
        <c:if test="${!empty cart}">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-primary">
                    <div class="panel-heading">
                        &nbsp;
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th>Book #</th>
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

                        </div>
                    </div>

                    <div class="panel-footer">
                        <div class="row">
                        <form id="placeOrderForm" action="${ctx }/cart/submit" method="POST">
                            <p style="padding-left: 50px; color: red">
                                Total:   $ ${total.toString()}
                            </p>
                            <button class="btn btn-danger" style="float: right; margin-right: 10px" type="submit" id="btn">
                                Place Order!
                            </button>
                        </form>

                        </div>
                    </div>

                </div>
            </div>
        </div>
        </c:if>

        <c:if test="${empty cart}">
            <h2>It's Empty...</h2>
        </c:if>
    </div>
    <!-- /. ROW  -->
</div>

<!-- CONTENT-WRAPPER SECTION END-->

<section class="footer-section">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                &copy; 2017 Chen Zhan, Software Engineering, Shanghai Jiao Tong University
            </div>
        </div>
    </div>
</section>
<!-- FOOTER SECTION END-->
<!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
<!-- CORE JQUERY  -->
<script src="${ctx}/assets/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS  -->
<script src="${ctx}/assets/js/bootstrap.js"></script>
<!-- DATATABLE SCRIPTS  -->
<script src="${ctx}/assets/js/dataTables/jquery.dataTables.js"></script>
<script src="${ctx}/assets/js/dataTables/dataTables.bootstrap.js"></script>
<!-- CUSTOM SCRIPTS  -->
<script src="${ctx}/assets/js/custom.js"></script>
</body>
</html>
