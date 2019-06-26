<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuario</title>
</head>
<body>
	<h1>Usuario</h1>
	<form:form action="${pageContext.request.contextPath}/${formAction}" method="POST" modelAttribute="usuario">
		<label>Nombre</label>
		<form:input type="text" name="nombre" path="nombre"/><br>
		
		<label>Apellido</label>
		<form:input type="text" name="apellido" path="apellido"/><br>
		
		<label>Username</label>
		<form:input type="text" name="username" path="username"/><br>
		
		<label>Password</label>
		<form:input type="text" name="password" path="password"/><br>
		
		<label>Fecha de nacimiento</label>
		<form:input type="date" name="fechaNacimiento" path="fechaNacimiento"/><br>
		
		<label>Direccion</label>
		<form:input type="text" name="direccion" path="direccion"/><br>
		
		<label>Saldo</label>
		<form:input type="number" name="saldo" path="saldo"/><br>
		
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
		
		<label>Rol</label>
		<form:select path="idRol"> 
			<form:options items="${roles}" itemValue="id" itemLabel="nombre"  />
		</form:select><br>
		
		<form:input type="hidden" name="id" path="id"/>
		<input type="submit" value="Guardar">
	</form:form>
</body>
</html>