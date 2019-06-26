<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <br/><br/>
    <form action="${pageContext.request.contextPath}/login/authenticate" method="POST" class="form-signin" style="width:30%;margin:auto">
        <h3 class="form-signin-heading">LOGIN PAGE</h3>

        <br/>
        <div align="center" th:if="${param.error}">
            <p style="font-size: 20px; color: #FF1C19;">Username or password is invalid</p>
        </div>

        <input type="text" id="username" name="username" class="form-control" /> <br/>
        <input type="password" id="password" name="password" class="form-control" /> <br />

        <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit"></button>
    </form>
</div>
</body>
</html>
