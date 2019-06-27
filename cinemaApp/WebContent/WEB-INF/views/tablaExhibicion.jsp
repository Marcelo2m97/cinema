<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exhibici&oacute;n</title>
</head>
<body>
	<h1>Exhibici&oacute;n</h1>
	<form:form action="${pageContext.request.contextPath}/formAddExhibicion">
		<input type="submit" value="Nueva Exhibici&oacute;n">
	</form:form>
	
	<table>
		<tr>
			<th>Acci&oacute;n</th>
			<th>C&oacute;digo</th>
			<th>Descripci&oacute;n</th>
			<th>Estado</th>
			<th>Fecha Creaci&oacute;n</th>
			<th>Usuario Creaci&oacute;n</th>
			<th>Fecha Modificaci&oacute;n</th>
			<th>Usuario Modificaci&oacute;n	</th>
		</tr>
		<c:forEach items="${exhibiciones}" var="exhibicion">
			<tr>
				<td>
					<form:form action="${pageContext.request.contextPath}/formEditExhibicion">
						<input type="hidden" name="id" value="${exhibicion.id}">
						<input type="submit" value="Editar">
					</form:form>
					<form:form action="${pageContext.request.contextPath}/activarExhibicion" onsubmit="return confirm('Confirmar');">
						<input type="hidden" name="id" value="${exhibicion.id}">
						<c:choose>
							<c:when test="${exhibicion.activo == true}">
								<input type="submit" value="Inactivar">
							</c:when>
							<c:otherwise>
								<input type="submit" value="Activar">
							</c:otherwise>
						</c:choose>
					</form:form>
				</td>
				<td>${exhibicion.id}</td>
				<td>${exhibicion.pelicula.nombre} - ${exhibicion.formato.nombre} - ${exhibicion.horario}</td>
				<td>${exhibicion.activoDelegate}</td>
				<td>${exhibicion.fechaCreacionDelegate}</td>
				<td>${exhibicion.usuarioCreacion.username}</td>
				<td>${exhibicion.fechaModificacionDelegate}</td>
				<td>${exhibicion.usuarioModificacion.username}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>