<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adminsitraci&oacute;n</title>
</head>
<body>
 	<h1>Adminsitraci&oacute;n</h1>
 	<form:form action="${pageContext.request.contextPath}/tablaPelicula">
		<input type="submit" value="Peliculas">
	</form:form>
	<form:form action="${pageContext.request.contextPath}/tablaSala">
		<input type="submit" value="Salas">
	</form:form>
	<form:form action="${pageContext.request.contextPath}/tablaUsuario">
		<input type="submit" value="Usuarios">
	</form:form>
	<form:form action="${pageContext.request.contextPath}/logout/logout">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>