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
	<h1>${pelicula.nombre}</h1>
	<p>${pelicula.descripcion}</p>
	<img src="resources/${pelicula.imagen}" width="150px" height="225px">
	
	<h3>Reservaci&oacute;n</h3>
	<form:form action="${pageContext.request.contextPath}/confirmarReservacion" method="POST" modelAttribute="reservacion">
		<c:forEach items="${exhibiciones}" var="exhibicion">
			<form:radiobutton name="exhibicion" path="idExhibicion" value="${exhibicion.id}" onclick="setExhibicion('${exhibicion.asientos}','${exhibicion.formato.precio}');"/><c:out value="${exhibicion.formato.nombre}-${exhibicion.horario}"/><br>
		</c:forEach>

		<label>Asientos</label>
		<form:input type="number" name="asientos" path="asientos"/><br>
		<label>Disponibles</label>
		<label id="disponibles"></label><br>
		
		<label>Precio</label>
		<label id="precio"></label><br>
		
		<input type="checkbox" onclick="disable();"><label>Usar saldo</label>
		<form:input id="saldo" type="text" disabled="true" name="saldo" path="saldo" value="0"/><br>
		
		<input type="submit" value="Reservar">
	</form:form>
	
	<script>
	setExhibicion = function(asientos,precio){
		document.getElementById("disponibles").innerHTML = asientos;
		document.getElementById("precio").innerHTML = "$"+precio;
	}
	
	disable = function(){
		var isDisabled = document.getElementById("saldo").disabled;
		document.getElementById("saldo").disabled = !isDisabled;
	}
	</script>
</body>
</html>