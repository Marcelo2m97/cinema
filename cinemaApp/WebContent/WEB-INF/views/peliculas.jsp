<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CHEPITOS CINEMA</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
 <!-- Material Design Bootstrap -->
    <link href="resources/css/mdb.css" rel="stylesheet">
    <link href="resources/js/mdb.js" rel="stylesheet">
</head>
<body>
	<h1>CHEPITOS CINEMA</h1>
	<form:form action="${pageContext.request.contextPath}/transacciones">
		<input class="btn btn-primary" type="submit" value="Ver Transacciones">
	</form:form>
	<form:form action="${pageContext.request.contextPath}/logout/logout">
		<input class="btn btn-primary" type="submit" value="Logout">
	</form:form>
	<h2>Pel&iacute;culas</h2>
	<table class="table">
		<c:forEach items="${peliculas}" var="pelicula">
			<tr>
				<td>
					<img src="resources/${pelicula.imagen}" width="150px" height="225px">
					<h3>${pelicula.nombre}</h3>
					<form action="${pageContext.request.contextPath}/reservacion">
						<input type="hidden" name="id" value="${pelicula.id}">
						<input class="btn btn-primary" type="submit" value="Ver">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>