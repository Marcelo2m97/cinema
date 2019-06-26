<%--
  Created by IntelliJ IDEA.
  User: ralvarenga
  Date: 06-24-19
  Time: 03:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>Login</title>
    <!-- Bootstrap core CSS -->
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="/resources/css/mdb.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">
    <script src="resources/js/sweetalert2.min.js"></script>
    <link rel="stylesheet" href="resources/css/sweetalert2.min.css">
    <script src="https://cdn.jsdelivr.net/npm/promise-polyfill"></script>
    <script src="resources/js/jquery-3.3.0.js"></script>
    <script type="application/javascript">
        function login(){
            var username = document.getElementById('username').value;
            var password = document.getElementById('password').value;
            $.ajax({
                url: "${pageContext.request.contextPath}/login/authenticate",
                type: "POST",
                data: {
                    username: username,
                    password: password
                },
                success: function (data){
                    console.log(data);
                },
                error: function (error) {
                    console.log(error);
                }
            })
        }
    </script>
</head>

<body>

<div class="container">
    <br/><br/>
    <form action="${pageContext.request.contextPath}/login/authenticate" method="POST" class="form-signin" style="width:30%;margin:auto">
        <h3 class="form-signin-heading">LOGIN PAGE</h3>

        <br/>
        <input type="text" id="username" name="username"
               class="form-control" /> <br/>
        <input type="password"
               id="password" name="password" class="form-control" /> <br />


        <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit"></button>
    </form>
</div>
</body>
</html>
