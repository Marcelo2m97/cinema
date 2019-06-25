<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sala</title>
</head>
<body>
	<h1>Sala</h1>
	<form:form action="${pageContext.request.contextPath}/${formAction}" method="POST" modelAttribute="sala">		
		<label>Numero</label>
		<form:input type="number" name="numero" path="numero"/><br>
		
		<label>Descripci&oacute;n</label>
		<form:input type="text" name="descripcion" path="descripcion"/><br>
		
		<label>Capacidad</label>
		<form:input type="number" name="capacidad" path="capacidad"/><br>
		
		<form:input type="hidden" name="id" path="id"/>
		<input type="submit" value="Guardar">
	</form:form>
</body>
</html>