<%--
  Created by IntelliJ IDEA.
  User: zcoaolas
  Date: 3/18/2017
  Time: 14:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>

<%--<!DOCTYPE html>--%>
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

<script type="text/javascript">
    function getBook(bId) {

        var successProcess = function(data){
            document.getElementById("bName").innerHTML =data.bookName;
            document.getElementById("bInfo").innerHTML =data.bookInfo;
            document.getElementById("bAuthor").innerHTML =data.bookAuthor;
            document.getElementById("bCategory").innerHTML =data.bookCategory;
            document.getElementById("bPrice").innerHTML ='$ '+ data.bookPrice;
        };

        $.ajax({
            type: 'GET',
            contentType : 'application/json;charset=utf-8',
            url: '/book/bookDetail/' + bId,
            success: successProcess,
            cache:false
        });

    }

    function getBookRest(bId) {
        $.ajax({
            type: "GET",
            url: "/rest/book/"+bId,
            contentType: "application/json;charset=utf-8",

            success: function(data) {
                var ss = JSON.stringify(data);
                var jsonObj = eval( '(' + ss + ')' );

                console.log(jsonObj);
                alert( "bookAuthor: " + jsonObj.bookAuthor +
                    "\n\nbookId: " + jsonObj.bookId +
                    "\n\nbookInfo: " + jsonObj.bookInfo +
                    "\n\nbookName: " + jsonObj.bookName +
                    "\n\nbookPrice: " + jsonObj.bookPrice +
                    "\n\ncategory: " + jsonObj.category);
            }
        });
    }
</script>

<body onload =getBook(${bookId})>

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
                        <li><a href="${ctx}/cart/cartList">Shopping Cart</a></li>
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
                <h4 class="header-line">BOOK INFO</h4>
            </div>

        </div>
        <div class="row">
            <div class="col-md-12">
                <!-- Advanced Tables -->
                <%--<div class="panel panel-default">
                    <div class="panel-heading">
                        Books
                    </div>--%>
                <div class="panel-body">
                    <div class="table-responsive">

                            <table class="table table-bordered" id="dataTables-example">
                                <tbody>
                                <tr>
                                    <td rowspan="5"><img src="${ctx}/assets/img/cover.png"></td>
                                    <td colspan="2" id="bName"></td>
                                </tr>
                                <tr>
                                    <td>Information</td>
                                    <td id="bInfo"></td>
                                </tr>
                                <tr>
                                    <td>Author</td>
                                    <td id="bAuthor"></td>
                                </tr>
                                <tr>
                                    <td>Category</td>
                                    <td id="bCategory"></td>
                                </tr>
                                <tr>
                                    <td>Price</td>
                                    <td id="bPrice"></td>
                                </tr>

                                </tbody>

                            </table>

                        <form id="orderBookForm" action="${ctx}/book/bookAddCart" method="POST">
                            <div class="input-group" style="width: 20%; float:right">
                            <input type="hidden" id="id" name="id" value="${bookId}">
                            <input type="number" class="form-control" min="1" max="10" id="amount" value="1"
                                   name="amount">
                            <span class="form-group input-group-btn">
                                <button class="btn btn-info" type="submit" id="btn">Order!</button>
                            </span>
                            </div>
                        </form>

                    </div>
                </div>
                <!--End Advanced Tables -->
            </div>
        </div>
    </div>
    <!-- /. ROW  -->
    <div>
        <!-- Section to demonstrate Restful web service -->
        <button class="btn btn-info" type="submit" id="restbtn" onclick="getBookRest(${bookId})">Rest API</button>
        <!-- Section to demonstrate Restful web service -->
    </div>
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