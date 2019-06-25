<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pel&iacute;cula</title>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
</head>
<body>
	<h1>Pel&iacute;cula</h1>
	<form:form action="${pageContext.request.contextPath}/${formAction}" method="POST" modelAttribute="pelicula">
		<label>Nombre</label>
		<form:input type="text" name="nombre" path="nombre"/><br>
		
		<label>Descripci&oacute;n</label>
		<form:input type="text" name="descripcion" path="descripcion"/><br>
		
		<label>Imagen</label>
		<form:input type="text" id="imageName" name="imagen" path="imagen"/><br>
		<img id="image" src="resources/${pelicula.imagen}" width="150px" height="225px"><br>
		
		<form:input type="hidden" name="id" path="id"/>
		<input type="submit" value="Guardar">
	</form:form>
	
	<h2>Upload image</h2>
	<form method="POST" onsubmit="return false;" enctype="multipart/form-data">
		<label>File: </label>
		<input type="file" id="file" multiple="multiple"><br> 
		<button onclick="uploadImage();">Upload</button>
	</form>
	
	<script>
    uploadImage = function(){
    	var data = new FormData();
    	jQuery.each(jQuery('#file')[0].files, function(i,file){
    		data.append('file-'+i,file);
    	});
        $.ajax({
            type : 'POST',
            url : 'uploadFile',
            data: data,
        	cache: false,
        	contentType: false,
        	processData: false,
            success : function(response) {
                $('#imageName').val(response);
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