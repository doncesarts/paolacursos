<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources/css/EstilosAdministrador.css"
	var="mainCss" />


<link href="${mainCss}" rel="stylesheet" />



</head>

<script type="text/javascript">
	function seleccionar() {
	 	$("#unidades").show();
		$("#Operacion").hide();
		


	}
	
	function upload(){
		
		//Verificarmos que elemento de la lista es el que esta seleccionado
		var x = document.getElementById('unidad').value;
	
		//Asignamos el valor al elemento escondido dentro del formulario en donde haremos el submit
		 $('input[name="unidad"]').val(x);
		 
		 //Necesitamos serializar el formulario en la posicion 1 ya que el primer formulario
		 //es en el que pasamos los datos.
			var form = $('form')[1]; // You need to use standart javascript object here
			var formData = new FormData(form);
		
			$.ajax({
				type : "POST",
				url : "/Paola/save.do",
				data: formData,
				success : function(response) {
					// we have the response
					$('#wrapper').html(response);
				},
				cache: false,
		        contentType: false,
		        processData: false
			});
		
	}
	</script>

<body>
<div>
	 <form method="post" action="/Paola/CursoUploadFile" enctype="multipart/form-data">
	<p> Curso :</p> <form:label path="nomcurso" id="nombre">${nomcurso}</form:label>  <br><br>
	Seleciona la unidad
	
	<form:select path="unidades" id="unidad">
	
												<form:options items="${unidades}" itemValue="id"
													itemLabel="unidad" id="uni"></form:options>
											</form:select> 
	
</form>
	

	<div id="wrapper">

		<form:form method="post" action="/Paola/save.do"
			modelAttribute="fileUploadForm" enctype="multipart/form-data"
			id="crearPresentacion">

			<table id="fileTable">

				<tr>
					<td><input name="files[0]" type="file" /></td>
				</tr>
			<tr>
			<td><input type="checkbox" name="habilitado" value="Habilitado"/>Habilitado<br></td>
			</tr>
			</table>
			
			<br />
			<input type="hidden" value="" name="unidad" />
			<input type="hidden" value="${nomcurso}" name="curso" />
				<input type="button"
							id="btPresentaciones" value="CrearPresentacion" class="bt"
							onclick="upload()" />
							
		</form:form>
	</div>
</div>
</body>
</html>