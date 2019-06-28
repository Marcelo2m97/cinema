<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transacciones</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
 <!-- Material Design Bootstrap -->
    <link href="resources/css/mdb.css" rel="stylesheet">
    <link href="resources/js/mdb.js" rel="stylesheet">
<script src="resources/js/sweetalert2.min.js"></script>
<link rel="stylesheet" href="resources/css/sweetalert2.min.css">
<script src="resources/js/jquery-3.3.0.js"></script>
</head>
<body>
	<h1>Transaccciones</h1>
	<form:form action="${pageContext.request.contextPath}/buscarTransacciones">
		<label>Desde: </label><input type="date" name="startDate" required>
		<label>Hasta: </label><input type="date" name="endDate" required>
		<input class="btn btn-primary" type="submit" value="Buscar">
	</form:form>
	<table class="table">
		<thead class="thead">
		<tr>
			<th>Acci&oacute;n</th>
			<th>N&uacute;mero de transacci&oacute;n</th>
			<th>Fecha transacci&oacute;n</th>
		</tr>
		</thead>
		<c:forEach items="${reservaciones}" var="reservacion">
			<tr>
				<td>
					<button class="btn btn-outline-primary" onclick="verReservacion(${reservacion.id});">Ver</button>
				</td>
				<td>${reservacion.idDelegate}</td>
				<td>${reservacion.fechaDelegate}</td>
			</tr>
		</c:forEach>
	</table>
	
	<script>
		verReservacion = function(id){
			$.ajax({
	            type : 'POST',
	            url : '${pageContext.request.contextPath}/verReservacion',
	            data: {id:id},
	            dataType: 'json',
	            success : function(response) {
	            	console.log(response);
	            	
	            	Swal.fire({
           				type: 'info',
	            		title: 'Transacci&oacute;n',
	            		html:
	            		    'Pelicula: ' + response.pelicula + "<br>" +
	            		    'Fecha: ' + response.fecha + "<br>" +
	            		    'Horario: ' + response.horario + "<br>" +
	            		    'Asientos: ' + response.asientos + "<br>" +
	            		    'Saldo usado: $' + response.saldo + "<br>" +
	            		    'Total: $' + response.total + "<br>",
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