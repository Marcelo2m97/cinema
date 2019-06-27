<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pel&iacute;culas</title>
<script src="resources/js/sweetalert2.min.js"></script>
<link rel="stylesheet" href="resources/css/sweetalert2.min.css">
<script src="resources/js/jquery-3.3.0.js"></script>
</head>
<body>
	<h1>Pel&iacute;culas</h1>
	<form:form action="${pageContext.request.contextPath}/formAddPelicula">
		<input type="submit" value="Nueva Pel&iacute;cula">
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
		<c:forEach items="${peliculas}" var="pelicula">
			<tr>
				<td>
					<form:form action="${pageContext.request.contextPath}/perfilPelicula">
						<input type="hidden" name="id" value="${pelicula.id}">
						<input type="submit" value="Ver">
					</form:form>
					<form:form action="${pageContext.request.contextPath}/formEditPelicula">
						<input type="hidden" name="id" value="${pelicula.id}">
						<input type="submit" value="Editar">
					</form:form>
					<form:form id="form" action="${pageContext.request.contextPath}/activarPelicula">
						<input type="hidden" name="id" value="${pelicula.id}">
						<c:choose>
							<c:when test="${pelicula.activo == true}">
								<input type="submit" value="Inactivar">
							</c:when>
							<c:otherwise>
								<input type="submit" value="Activar">
							</c:otherwise>
						</c:choose>
					</form:form>
				</td>
				<td>${pelicula.id}</td>
				<td>${pelicula.nombre}</td>
				<td>${pelicula.activoDelegate}</td>
				<td>${pelicula.fechaCreacionDelegate}</td>
				<td>${pelicula.usuarioCreacion.username}</td>
				<td>${pelicula.fechaModificacionDelegate}</td>
				<td>${pelicula.usuarioModificacion.username}</td>
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