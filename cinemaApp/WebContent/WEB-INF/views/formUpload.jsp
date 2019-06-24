<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Images</title>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
</head>
<body>
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
                alert(response);
            },
            error : function() {
                alert("Error");
            }
        });
    }
	</script>
</body>
</html>