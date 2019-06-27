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
	<h1>Confirmar Reservaci&oacute;n</h1>
	<p>Pel&iacute;cula: ${exhibicion.pelicula.nombre}</p>
	<p>Horario: ${exhibicion.horario}</p>
	<p>Formato: ${exhibicion.formato.nombre}</p>
	<p>Asientos: ${reservacion.asientos}</p>
	<p>Subtotal: $${reservacion.subtotal}</p>
	<p>Saldo usado: $${reservacion.saldo}</p>
	<p>Saldo restante: $${reservacion.saldoRestante}</p>
	<p>Total: $${reservacion.total}</p>
	
	<form:form action="${pageContext.request.contextPath}/procesarReservacion" method="POST" modelAttribute="reservacion">
		<form:input type="hidden" path="id"/>
		<form:input type="hidden" path="asientos"/>
		<form:input type="hidden" path="saldo"/>
		<form:input type="hidden" path="subtotal"/>
		<form:input type="hidden" path="saldoRestante"/>
		<form:input type="hidden" path="total"/>
		<form:input type="hidden" path="idExhibicion"/>
		<input type="submit" value="Finalizar transacci&oacute;n">
	</form:form>
</body>
</html>