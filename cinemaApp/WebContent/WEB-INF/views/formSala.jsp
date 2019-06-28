<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sala</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
 <!-- Material Design Bootstrap -->
    <link href="resources/css/mdb.css" rel="stylesheet">
    <link href="resources/js/mdb.js" rel="stylesheet">
</head>
<body>
	<h1>Sala</h1>
	<form:form action="${pageContext.request.contextPath}/${formAction}" method="POST" modelAttribute="sala">		
		<label>Numero</label>
		<form:input type="number" name="numero" path="numero"/><br>
		<form:errors path="numero" cssStyle="color:#E81505;"></form:errors><br>
		
		<label>Descripci&oacute;n</label>
		<form:input type="text" name="descripcion" path="descripcion"/><br>
		<form:errors path="descripcion" cssStyle="color:#E81505;"></form:errors><br>
		
		<label>Capacidad</label>
		<form:input type="number" name="capacidad" path="capacidad"/><br>
		<form:errors path="capacidad" cssStyle="color:#E81505;"></form:errors><br>
		
		<form:input type="hidden" name="id" path="id"/>
		<input class="btn btn-primary" type="submit" value="Guardar">
	</form:form>
</body>
</html>