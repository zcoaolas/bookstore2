<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: haoyuyang
  Date: 2016/11/25
  Time: 上午11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"/>
<html lang="en">
<style>
    body{
        /*Set the background picture on the bottom left*/
        background-image:url("/assets/img/bg_book.jpg");
        background-repeat:no-repeat;
        background-attachment:fixed;
        background-position:left bottom;
    }
</style>
<head>
    <title>Zen Bookstore</title>
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
    <script src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.min.js"></script>
    <script src="http://cdn.bootcss.com/stomp.js/2.3.3/stomp.js"></script>
    <script src="http://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            //connect();
            //checkoutUserlist();
        });

        //ajax 访问函数
        function checkoutUserlist(){

            // alert("request for user list by ajax.");
            var url = "/feed "; //请求的地址
            $.post(url,{
                    greeting:"hello xiaotang" //[逗号 连接 ]
                },
                function(data){ // 回调函数 .
                    alert(data);
                },"json");
        }

        var stompClient = null;

        function setConnected(connected) {
            document.getElementById('connect').disabled = connected;
            document.getElementById('disconnect').disabled = !connected;
            document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
            document.getElementById('response').innerHTML = '';
        }

        //this line.
        function connect() {
            var userid = document.getElementById('name').value;
            var socket = new SockJS("/hello");
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/greetings', function(greeting){
                    showGreeting(JSON.parse(greeting.body).content);
                });

                stompClient.subscribe('/user/' + userid + '/message',function(greeting){
                    alert(JSON.parse(greeting.body).content);
                    showGreeting(JSON.parse(greeting.body).content);
                });
            });
        }

        function sendName() {
            var name = document.getElementById('name').value;
            var msg = document.getElementById('msg').value;
            stompClient.send("/app/hello", {atytopic:"greetings"}, JSON.stringify({ 'name': name, 'msg': msg }));
        }

        function connectAny() {
            var socket = new SockJS("/hello");
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                setConnected(true);
                console.log('Connected: ' + frame);
                stompClient.subscribe('/topic/feed', function(greeting){
                    alert(JSON.parse(greeting.body).content);
                    showGreeting(JSON.parse(greeting.body).content);
                });
            });
        }

        function disconnect() {
            if (stompClient != null) {
                stompClient.disconnect();
            }
            setConnected(false);
            console.log("Disconnected");
        }


        function showGreeting(message) {
            var response = document.getElementById('response');
            var div = document.createElement('div');
            div.className = 'chat-widget-left';
            div.innerHTML = message;
            response.appendChild(div);
            /*response.append(<hr />);*/
        }
    </script>
</head>
<body>
<noscript><h2 style="color: #ff0000">Seems your browser doesn't support Javascript! Websocket relies on Javascript being enabled. Please enable
    Javascript and reload this page!</h2></noscript>
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

<div>
    <div id="conversationDiv">
        <div style="padding-left: 25%; padding-right: 25%">
        <div class="panel panel-info">
            <div class="panel-body">
                <div class="form-group">
                    <label>Chat Name</label>
                    <input class="form-control" type="text" id="name"/>
                </div>
                <div class="form-group">
                    <label>Message</label>
                    <input class="form-control" type="text" id="msg"/>
                </div>
                <button id="connect" onclick="connect();" class="btn btn-success">Connect</button>
                <button id="disconnect" disabled="disabled" onclick="disconnect();" class="btn btn-danger">Disconnect</button>
                <button id="sendName" onclick="sendName();" style="float:right;" class="btn btn-primary">Send</button>
            </div>
        </div>

        <div class="panel panel-primary ">
            <div class="panel-heading">
                Recent Chat History
            </div>
            <div class="panel-body chat-widget-main" id="response">

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
