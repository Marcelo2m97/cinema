<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrarse</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
 <!-- Material Design Bootstrap -->
    <link href="resources/css/mdb.css" rel="stylesheet">
    <link href="resources/js/mdb.js" rel="stylesheet">
</head>
<body>
	<h1>Registrarse</h1>
	<form:form action="${pageContext.request.contextPath}/addUsuarioRegister" method="POST" modelAttribute="usuario">
		<label>Username</label>
		<form:input type="text" name="username" path="username"/><br>
		
		<label>Password</label>
		<form:input type="password" name="password" path="password"/><br>
		
		<label>Nombre</label>
		<form:input type="text" name="nombre" path="nombre"/><br>
		
		<label>Apellido</label>
		<form:input type="text" name="apellido" path="apellido"/><br>
		
		<label>Fecha de nacimiento</label>
		<form:input type="date" name="fechaNacimiento" path="fechaNacimiento"/><br>
		
		<label>Direccion</label>
		<form:input type="text" name="direccion" path="direccion"/><br>
		
		<label>Pais</label>
		<form:select path="idPais"> 
			<form:options items="${paises}" itemValue="id" itemLabel="nombre"  />
		</form:select><br>
		
		<label>Estado</label>
		<form:select path="idEstado"> 
			<form:options items="${estados}" itemValue="id" itemLabel="nombre"  />
		</form:select><br>
		
		<label>Ciudad</label>
		<form:select path="idCiudad"> 
			<form:options items="${ciudades}" itemValue="id" itemLabel="nombre"  />
		</form:select><br>
		
		<form:input type="hidden" name="id" path="id"/>
		<input class="btn btn-primary" type="submit" value="Guardar">
	</form:form>
</body>
</html>