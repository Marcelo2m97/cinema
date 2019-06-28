<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservaci&oacute;n</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
 <!-- Material Design Bootstrap -->
    <link href="resources/css/mdb.css" rel="stylesheet">
    <link href="resources/js/mdb.js" rel="stylesheet">
    <script src="resources/js/sweetalert2.min.js"></script>
<link rel="stylesheet" href="resources/css/sweetalert2.min.css">
<script src="resources/js/jquery-3.3.0.js"></script>
</head>
<body>
	<h1>${pelicula.nombre}</h1>
	<p>${pelicula.descripcion}</p>
	<img src="resources/${pelicula.imagen}" width="150px" height="225px">
	
	<h3>Reservaci&oacute;n</h3>
	<form:form id="form" action="${pageContext.request.contextPath}/confirmarReservacion" method="POST" modelAttribute="reservacion">
		<c:forEach items="${exhibiciones}" var="exhibicion">
			<form:radiobutton name="exhibicion" path="idExhibicion" value="${exhibicion.id}" onclick="setExhibicion('${exhibicion.asientos}','${exhibicion.formato.precio}','${exhibicion.id}');"/><c:out value="${exhibicion.formato.nombre}-${exhibicion.fechaDelegate}-${exhibicion.horario}"/><br>
		</c:forEach>

		<label>Asientos</label>
		<form:input id="asientos" type="number" name="asientos" path="asientos"/><br>
		<form:errors path="asientos" cssStyle="color:#E81505;"></form:errors><br>
		<label>Disponibles</label>
		<label id="disponibles"></label><br>
		
		<label>Precio</label>
		<label id="precio"></label><br>
		
		<input type="checkbox" onclick="disable();"><label>Usar saldo</label>
		<form:input id="saldo" type="text" disabled="true" name="saldo" path="saldo" value="0"/><br>
		<form:errors path="saldo" cssStyle="color:#E81505;"></form:errors><br>
		
		<input id="idExhibicion" type="hidden">
	</form:form>
	<button onclick="validar();" class="btn btn-primary">Reservar</button>
	
	<script>
	setExhibicion = function(asientos,precio,id){
		document.getElementById("disponibles").innerHTML = asientos;
		document.getElementById("precio").innerHTML = "$"+precio;
		document.getElementById("idExhibicion").value = id; 
	}
	
	disable = function(){
		var isDisabled = document.getElementById("saldo").disabled;
		document.getElementById("saldo").disabled = !isDisabled;
		document.getElementById("saldo").value = 0;
	}
	
	validar = function(){
		var asientos = document.getElementById("asientos").value;
		var saldo = document.getElementById("saldo").value;
		var idExhibicion = document.getElementById("idExhibicion").value;
		$.ajax({
            type : 'POST',
            url : '${pageContext.request.contextPath}/validarTransaccion',
            data: {saldo:saldo,asientos:asientos,idExhibicion:idExhibicion},
            success : function(response) {
            	console.log(response);
            	if (response == "OK"){
            		$('#form').submit();
            	}else{
            	Swal.fire({
       				type: 'info',
            		title: 'Error',
            		text: response,
            		 });
            	}
            },
            error : function() {
                alert("Error");
            }
        });
	}
	</script>
</body>
</html>