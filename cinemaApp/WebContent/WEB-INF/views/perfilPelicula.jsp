<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pel&iacute;cula</title>
</head>
<body>
	<h1>${pelicula.nombre}</h1>
	<p>${pelicula.descripcion}</p>
	<img src="resources/${pelicula.imagen}" width="150px" height="225px">
	
	<h1>Funciones</h1>
	<form:form action="${pageContext.request.contextPath}/formAddExhibicion">
		<input type="hidden" name="idPelicula" value="${pelicula.id}">
		<input type="submit" value="Nueva Funci&oacute;n">
	</form:form>
	
	<table>
		<tr>
			<th>Acci&oacute;n</th>
			<th>C&oacute;digo</th>
			<th>Descripci&oacute;n</th>
			<th>Fecha Creaci&oacute;n</th>
			<th>Usuario Creaci&oacute;n</th>
			<th>Fecha Modificaci&oacute;n</th>
			<th>Usuario Modificaci&oacute;n	</th>
		</tr>
		<c:forEach items="${exhibiciones}" var="exhibicion">
			<tr>
				<td>
					<form:form action="${pageContext.request.contextPath}/formEditExhibicion">
						<input type="hidden" name="idPelicula" value="${pelicula.id}">
						<input type="hidden" name="id" value="${exhibicion.id}">
						<input type="submit" value="Editar">
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