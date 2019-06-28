<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administraci&oacute;n</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
 <!-- Material Design Bootstrap -->
    <link href="resources/css/mdb.css" rel="stylesheet">
    <link href="resources/js/mdb.js" rel="stylesheet">
</head>
<body>
	<center>
 	<h1>Administraci&oacute;n</h1>
	 	<form:form action="${pageContext.request.contextPath}/tablaPelicula">
			<input class="btn btn-primary" type="submit" value="Peliculas">
		</form:form><br>
		<form:form action="${pageContext.request.contextPath}/tablaSala">
			<input class="btn btn-primary" type="submit" value="Salas">
		</form:form><br>
		<form:form action="${pageContext.request.contextPath}/tablaUsuario">
			<input class="btn btn-primary" type="submit" value="Usuarios">
		</form:form><br>
		<form:form action="${pageContext.request.contextPath}/logout/logout">
			<input class="btn btn-primary" type="submit" value="Logout">
		</form:form><br>
	</center>
</body>
</html>