<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pel&iacute;cula</title>
</head>
<body>
	<h1>Pel&iacute;cula</h1>
	<form:form action="${pageContext.request.contextPath}/${formAction}" method="POST" modelAttribute="pelicula">
		<label>ID</label>
		<form:input type="text" name="id" path="id"/><br>
		
		<label>Nombre</label>
		<form:input type="text" name="nombre" path="nombre"/><br>
		
		<label>Descripci&oacute;n</label>
		<form:input type="text" name="descripcion" path="descripcion"/><br>
		
		<label>Imagen</label>
		<form:input type="text" name="imagen" path="imagen"/><br>
		
		<input type="submit" value="Guardar">
	</form:form>
</body>
</html>