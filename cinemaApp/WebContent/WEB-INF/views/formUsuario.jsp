<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Usuario</title>
<link href="resources/css/bootstrap.css" rel="stylesheet">
 <!-- Material Design Bootstrap -->
    <link href="resources/css/mdb.css" rel="stylesheet">
    <link href="resources/js/mdb.js" rel="stylesheet">
</head>
<body>
	<h1>Usuario</h1>
	<form:form action="${pageContext.request.contextPath}/${formAction}" method="POST" modelAttribute="usuario">
		<label>Username</label>
		<form:input type="text" name="username" path="username"/><br>
		<form:errors path="username" cssStyle="color:#E81505;"></form:errors><br>
		
		<label>Password</label>
		<form:input type="password" name="password" path="password"/><br>
		<form:errors path="password" cssStyle="color:#E81505;"></form:errors><br>
		
		<label>Nombre</label>
		<form:input type="text" name="nombre" path="nombre"/><br>
		<form:errors path="nombre" cssStyle="color:#E81505;"></form:errors><br>
		
		<label>Apellido</label>
		<form:input type="text" name="apellido" path="apellido"/><br>
		<form:errors path="apellido" cssStyle="color:#E81505;"></form:errors><br>
		
		<label>Fecha de nacimiento</label>
		<form:input type="date" name="fechaNacimiento" path="fechaNacimiento"/><br>
		<form:errors path="fechaNacimiento" cssStyle="color:#E81505;"></form:errors><br>
		
		<label>Direccion</label>
		<form:input type="text" name="direccion" path="direccion"/><br>
		<form:errors path="direccion" cssStyle="color:#E81505;"></form:errors><br>
		
		<label>Saldo</label>
		<form:input type="number" name="saldo" path="saldo"/><br>
		<form:errors path="saldo" cssStyle="color:#E81505;"></form:errors><br>
		
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
		<input class="btn btn-primary" type="submit" value="Guardar">
	</form:form>
</body>
</html>