<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CHEPITOS CINEMA</title>
</head>
<body>
	<h1>CHEPITOS CINEMA</h1>
	<h2>Pel&iacute;culas</h2>
	<table>
		<c:forEach items="${peliculas}" var="pelicula">
			<tr>
				<td><img src="resources/${pelicula.imagen}" width="150px" height="225px"></td>
				<td>${pelicula.nombre}</td>
				<td>
				<form action="${pageContext.request.contextPath}/reservacion">
						<input type="hidden" name="id" value="${pelicula.id}">
						<input type="submit" value="Ver">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<form:form action="${pageContext.request.contextPath}/transacciones">
		<input type="submit" value="Ver Transacciones">
	</form:form>
	<form:form action="${pageContext.request.contextPath}/logout/logout">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>