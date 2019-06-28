<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pel&iacute;cula</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
 <!-- Material Design Bootstrap -->
    <link href="resources/css/mdb.css" rel="stylesheet">
    <link href="resources/js/mdb.js" rel="stylesheet">
</head>
<body>
	<h1>${pelicula.nombre}</h1>
	<p>${pelicula.descripcion}</p>
	<img src="resources/${pelicula.imagen}" width="150px" height="225px">
	
	<h3>Funciones</h3>
	<form:form action="${pageContext.request.contextPath}/formAddExhibicion">
		<input type="hidden" name="idPelicula" value="${pelicula.id}">
		<input class="btn btn-primary" type="submit" value="Nueva Funci&oacute;n">
	</form:form>
	
	<table class="table">
		<thead class="thead">
		<tr>
			<th>Acci&oacute;n</th>
			<th>C&oacute;digo</th>
			<th>Descripci&oacute;n</th>
			<th>Fecha Creaci&oacute;n</th>
			<th>Usuario Creaci&oacute;n</th>
			<th>Fecha Modificaci&oacute;n</th>
			<th>Usuario Modificaci&oacute;n	</th>
		</tr>
		</thead>
		<c:forEach items="${exhibiciones}" var="exhibicion">
			<tr>
				<td>
					<form:form action="${pageContext.request.contextPath}/formEditExhibicion">
						<input type="hidden" name="idPelicula" value="${pelicula.id}">
						<input type="hidden" name="id" value="${exhibicion.id}">
						<input class="btn btn-outline-primary" type="submit" value="Editar">
					</form:form>
				</td>
				<td>${exhibicion.id}</td>
				<td>${exhibicion.pelicula.nombre} - ${exhibicion.formato.nombre} - ${exhibicion.fechaDelegate} - ${exhibicion.horario}</td>
				<td>${exhibicion.fechaCreacionDelegate}</td>
				<td>${exhibicion.usuarioCreacion.username}</td>
				<td>${exhibicion.fechaModificacionDelegate}</td>
				<td>${exhibicion.usuarioModificacion.username}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>