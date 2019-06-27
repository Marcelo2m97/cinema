<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Salas</title>
<script src="resources/js/sweetalert2.min.js"></script>
<link rel="stylesheet" href="resources/css/sweetalert2.min.css">
<script src="resources/js/jquery-3.3.0.js"></script>
</head>
<body>
	<h1>Salas</h1>
	<form:form action="${pageContext.request.contextPath}/formAddSala">
		<input type="submit" value="Nueva Sala">
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
		<c:forEach items="${salas}" var="sala">
			<tr>
				<td>
					<form:form action="${pageContext.request.contextPath}/formEditSala">
						<input type="hidden" name="id" value="${sala.id}">
						<input type="submit" value="Editar">
					</form:form>
					<form:form id="form" action="${pageContext.request.contextPath}/activarSala">
						<input type="hidden" name="id" value="${sala.id}">
						<c:choose>
							<c:when test="${sala.activo == true}">
								<input type="submit" value="Inactivar">
							</c:when>
							<c:otherwise>
								<input type="submit" value="Activar">
							</c:otherwise>
						</c:choose>
					</form:form>
				</td>
				<td>${sala.id}</td>
				<td>${sala.numero}</td>
				<td>${sala.activoDelegate}</td>
				<td>${sala.fechaCreacionDelegate}</td>
				<td>${sala.usuarioCreacion.username}</td>
				<td>${sala.fechaModificacionDelegate}</td>
				<td>${sala.usuarioModificacion.username}</td>
			</tr>
		</c:forEach>
	</table>
	
	<script>
	$('#form').on('submit', function(e) {
	    var form = this;
	    e.preventDefault();

	    Swal.fire({
	        title: "Confirmar",
	        type: "warning",
	        showCancelButton: true,
	        confirmButtonText: 'Continuar',
	        cancelButtonText: "Cancelar",
	    }).then(function(result) {
	    	if (result.value){
	    		form.submit();
	    	}
	    }); 
	});
	</script>
</body>
</html>