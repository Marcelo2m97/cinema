<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
</head>
<body>
	<h1>Usuario</h1>
	<form:form action="${pageContext.request.contextPath}/formAddUsuario">
		<input type="submit" value="Nuevo Usuario">
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
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>
					<form:form action="${pageContext.request.contextPath}/formEditUsuario">
						<input type="hidden" name="id" value="${usuario.id}">
						<input type="submit" value="Editar">
					</form:form>
					<form:form action="${pageContext.request.contextPath}/activarUsuario" onsubmit="return confirm('Confirmar');">
						<input type="hidden" name="id" value="${usuario.id}">
						<c:choose>
							<c:when test="${usuario.activo == true}">
								<input type="submit" value="Inactivar">
							</c:when>
							<c:otherwise>
								<input type="submit" value="Activar">
							</c:otherwise>
						</c:choose>
					</form:form>
				</td>
				<td>${usuario.id}</td>
				<td>${usuario.username}</td>
				<td>${usuario.activoDelegate}</td>
				<td>${usuario.fechaCreacionDelegate}</td>
				<td>${usuario.usuarioCreacion.username}</td>
				<td>${usuario.fechaModificacionDelegate}</td>
				<td>${usuario.usuarioModificacion.username}</td>
				<td></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>