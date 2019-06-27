<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transacciones</title>
</head>
<body>
	<h1>Transaccciones</h1>
	<form:form action="${pageContext.request.contextPath}/buscarTransacciones">
		<input type="date" name="startDate">
		<input type="date" name="endDate">
		<input type="submit" value="Buscar">
	</form:form>
	<table>
		<tr>
			<th>Acci&oacute;n</th>
			<th>N&uacute;mero de transacci&oacute;n</th>
			<th>Fecha transacci&oacute;n</th>
		</tr>
		<c:forEach items="${reservaciones}" var="reservacion">
			<tr>
				<td>
					<form:form action="${pageContext.request.contextPath}/verReservacion">
						<input type="hidden" name="id" value="${reservacion.id}">
						<input type="submit" value="Ver">
					</form:form>
				</td>
				<td>${reservacion.idDelegate}</td>
				<td>${reservacion.fechaDelegate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>