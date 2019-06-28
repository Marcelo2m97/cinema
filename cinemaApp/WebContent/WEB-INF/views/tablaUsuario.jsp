<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuarios</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
 <!-- Material Design Bootstrap -->
    <link href="resources/css/mdb.css" rel="stylesheet">
    <link href="resources/js/mdb.js" rel="stylesheet">
<script src="resources/js/sweetalert2.min.js"></script>
<link rel="stylesheet" href="resources/css/sweetalert2.min.css">
<script src="resources/js/jquery-3.3.0.js"></script>
</head>
<body>
	<h1>Usuario</h1>
	<form:form action="${pageContext.request.contextPath}/administracion">
		<input class="btn btn-primary" type="submit" value="Menu">
	</form:form>
	<form:form action="${pageContext.request.contextPath}/formAddUsuario">
		<input class="btn btn-primary" type="submit" value="Nuevo Usuario">
	</form:form>
	
	<table class="table">
		<thead class="thead">
		<tr>
			<th colspan="3">Acci&oacute;n</th>
			<th>C&oacute;digo</th>
			<th>Descripci&oacute;n</th>
			<th>Estado</th>
			<th>Fecha Creaci&oacute;n</th>
			<th>Usuario Creaci&oacute;n</th>
			<th>Fecha Modificaci&oacute;n</th>
			<th>Usuario Modificaci&oacute;n	</th>
		</tr>
		</thead>
		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td>
					<button class="btn btn-outline-primary" onclick="ver(${usuario.id});">Ver</button>
				</td>
				<td>
					<form:form action="${pageContext.request.contextPath}/formEditUsuario">
						<input type="hidden" name="id" value="${usuario.id}">
						<input class="btn btn-outline-primary" type="submit" value="Editar">
					</form:form>
				</td>
				<td>
					<form:form id="form" action="${pageContext.request.contextPath}/activarUsuario" onsubmit="return prompt();">
						<input type="hidden" name="id" value="${usuario.id}">
						<input type="hidden" id="motivo" name="motivo">
						<c:choose>
							<c:when test="${usuario.activo == true}">
								<input class="btn btn-outline-primary" type="submit" value="Inactivar">
							</c:when>
							<c:otherwise>
								<input class="btn btn-outline-primary" type="submit" value="Activar">
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
	
	<script>
	ver = function(id){
		$.ajax({
            type : 'POST',
            url : '${pageContext.request.contextPath}/verUsuario',
            data: {id:id},
            dataType: 'json',
            success : function(response) {
            	console.log(response);
            	
            	Swal.fire({
       				type: 'info',
            		title: 'Usuario',
            		html:
            		    'Username: ' + response.username + "<br>" +
            		    'Nombre: ' + response.nombre + "<br>" +
            		    'Apellido: ' + response.apellido + "<br>" +
            		    'Fecha nacimiento: ' + response.fechaNacimiento + "<br>" +
            		    'Saldo: $' + response.saldo + "<br>",
            		 });
            },
            error : function() {
                alert("Error");
            }
        });
	}
	</script>
</body>
</html>