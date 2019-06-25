<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservaci&oacute;n</title>
</head>
<body>
	<form>
		<h1>${pelicula.nombre}</h1>
		<p>${pelicula.descripcion}</p>
		<img src="resources/${pelicula.imagen}" width="150px" height="225px">
		
		<h2>Exhibiciones</h2>
		<c:forEach items="${exhibiciones}" var="exhibicion">
			<input type="radio"><c:out value="${exhibicion.formato}-${exhibicion.horario}"/><br>
		</c:forEach>
	</form>
</body>
</html>