<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exhibici&oacute;n</title>
</head>
<body>
	<h1>Exhibici&oacute;n</h1>
	<form:form action="${pageContext.request.contextPath}/${formAction}" method="POST" modelAttribute="exhibicion">
		<label>ID</label>
		<form:input type="text" name="id" path="id"/><br>
		
		<label>Horario</label>
		<form:input type="time" name="horario" path="horario"/><br>
		
		<label>Formato</label>
		<form:select path="formato"> 
			<form:option value="2DSUB"/>
			<form:option value="2DDOB"/>
			<form:option value="3DSUB"/>
			<form:option value="3DDOB"/>
		</form:select><br>
		
		<label>Sala</label>
		<form:select path="idSala"> 
			<form:options items="${salas}" itemValue="id" itemLabel="numero"  />
		</form:select><br>
		
		<label>Pelicula</label>
		<form:select path="idPelicula"> 
			<form:options items="${peliculas}" itemValue="id" itemLabel="nombre"  />
		</form:select><br>
		
		<input type="submit" value="Guardar">
	</form:form>
</body>
</html>