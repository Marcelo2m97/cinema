<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exhibici&oacute;n</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
 <!-- Material Design Bootstrap -->
    <link href="resources/css/mdb.css" rel="stylesheet">
    <link href="resources/js/mdb.js" rel="stylesheet">
</head>
<body>
	<h1>Exhibici&oacute;n</h1>
	<form:form action="${pageContext.request.contextPath}/${formAction}" method="POST" modelAttribute="exhibicion">
		<label>Fecha</label>
		<form:input type="date" name="fecha" path="fecha"/><br>
		<form:errors path="fecha" cssStyle="color:#E81505;"></form:errors><br>
		
		<label>Horario</label>
		<form:input type="time" name="horario" path="horario"/><br>
		<form:errors path="horario" cssStyle="color:#E81505;"></form:errors><br>
		
		<label>Formato</label>
		<form:select path="idFormato"> 
			<form:options items="${formatos}" itemValue="id" itemLabel="nombre"  />
		</form:select><br>
		
		<label>Sala</label>
		<form:select path="idSala"> 
			<form:options items="${salas}" itemValue="id" itemLabel="numero"  />
		</form:select><br>
		
		<form:input type="hidden" name="idPelicula" path="idPelicula" value="${pelicula}"/>
		<form:input type="hidden" name="id" path="id"/>
		<input class="btn btn-primary" type="submit" value="Guardar">
	</form:form>
</body>
</html>