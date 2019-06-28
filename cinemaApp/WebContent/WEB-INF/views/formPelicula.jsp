<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pel&iacute;cula</title>
<script src="resources/js/jquery-3.3.0.js"></script>
<link href="resources/css/bootstrap.css" rel="stylesheet">
 <!-- Material Design Bootstrap -->
    <link href="resources/css/mdb.css" rel="stylesheet">
    <link href="resources/js/mdb.js" rel="stylesheet">
</head>
<body>
	<h1>Pel&iacute;cula</h1>
	<form:form action="${pageContext.request.contextPath}/${formAction}" method="POST" modelAttribute="pelicula">
		<label>Nombre</label>
		<form:input type="text" name="nombre" path="nombre"/><br>
		
		<label>Descripci&oacute;n</label>
		<form:input type="text" name="descripcion" path="descripcion"/><br>
		
		<label>Imagen</label>
		<form:input type="hidden" id="imageName" name="imagen" path="imagen"/><br>
		<img id="image" src="resources/${pelicula.imagen}" width="150px" height="225px"><br>
		
		<form:input type="hidden" name="id" path="id"/>
		<input class="btn btn-primary" 	type="submit" value="Guardar">
	</form:form>
	
	<h2>Subir imagen</h2>
	<form method="POST" onsubmit="return false;" enctype="multipart/form-data">
		<label>File: </label>
		<input type="file" id="file"><br> 
		<button class="btn btn-primary" onclick="uploadImage();">Upload</button>
	</form>
	
	<script>
    uploadImage = function(){
    	var data = new FormData();
    	data.append('file',jQuery('#file')[0].files[0]);
        $.ajax({
            type : 'POST',
            url : '${pageContext.request.contextPath}/uploadFile',
            data: data,
        	cache: false,
        	contentType: false,
        	processData: false,
            success : function(response) {
            	$("#imageName").val(response);
                $("#image").attr("src","resources/"+response);
            },
            error : function() {
                alert("Error");
            }
        });
    }
	</script>
</body>
</html>