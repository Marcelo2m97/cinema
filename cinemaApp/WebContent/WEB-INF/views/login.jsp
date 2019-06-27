<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <title>Login</title>
    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="resources/css/mdb.css" rel="stylesheet">
    <link href="resources/js/mdb.js" rel="stylesheet">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <script src="resources/js/sweetalert2.min.js"></script>
    <link rel="stylesheet" href="resources/css/sweetalert2.min.css">
    <script src="https://cdn.jsdelivr.net/npm/promise-polyfill"></script>
    <script src="resources/js/jquery-3.3.0.js"></script>
    <script type="application/javascript">
        function login(){
            var username = document.getElementById('username').value;
            var password = document.getElementById('password').value;
            var user = {
                username: username,
                password: password
            };
            var Toast = Swal.mixin({
                toast: true,
                position: 'top-end',
                showConfirmButton: false,
                timer: 2000
            });

            $.ajax({
                url: "${pageContext.request.contextPath}/login/authenticate",
                type: "POST",
                dataType: 'json',
                contentType: 'application/json',
                data: JSON.stringify(user),
                success: function (data){
                    localStorage.setItem('jwt', data.token);
                    localStorage.setItem('rol ' + data.username, data.roles[0]);
                    localStorage.setItem('User', data.username);
                    Toast.fire({
                        type: 'success',
                        title: 'Inicio de sesión correcto'
                    }).then(function() {
                        if (data.roles[0] === 'Administrador') {
                            window.location.href = '${pageContext.request.contextPath}/admin';
                        }else{
                        	window.location.href = '${pageContext.request.contextPath}/user';
                        }
                    });
                },
                error: function (error) {
                    if (error.responseJSON.status === 404) {
                        Swal.fire({
                            type: 'error',
                            title: 'Credenciales incorrectas',
                            text: error.responseJSON.message,
                            showConfirmButton: false,
                            timer: 2000,
                        });
                    }
                    if (error.responseJSON.status === 422) {
                        Swal.fire({
                            type: 'error',
                            title: 'Oops!',
                            text: error.responseJSON.message,
                            showConfirmButton: false,
                            timer: 2000,
                        });
                    }
                    if (error.responseJSON.status === 499) {
                        Swal.fire({
                            type: 'error',
                            title: 'Cuenta inactiva',
                            text: error.responseJSON.message,
                            showConfirmButton: false,
                            timer: 2000,
                        });
                    }
                    if (error.responseJSON.status === 498) {
                        Swal.fire({
                            type: 'error',
                            title: 'Ya existe una sesión activa',
                            text: error.responseJSON.message,
                            showConfirmButton: false,
                            timer: 2000,
                        });
                    }
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
        <input type="text" id="username" name="username" class="form-control" /> <br/>
        <input type="password" id="password" name="password" class="form-control" /> <br />

        <button class="btn btn-primary " name="Submit" value="Login" onclick="login()" type="button"> Log in </button>
    </form>
</div>
</body>
</html>
