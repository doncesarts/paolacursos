
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%-- <spring:url value="/resources/css/EstilosAdmin.css" var="mainCss" />


<link href="${mainCss}" rel="stylesheet" /> --%>




</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script type="text/javascript">

function funcion(){

	var x = document.getElementsByName('altaCursoForm');
	if (($("#nombre").val() == "") 
   	        || ($("#descripcion").val() == "")){
   	    		
   	    		alert("Introduzca todos los campos");
   	    		return false;
   	    	}  

	var frm = $("#altaCursoForm");
	 $.ajax({
         type: "POST",
         url: "/Paola/AltaCurso",
         data:  frm.serialize(),
         success: function(response){
             // we have the response
             $('#wrapper').html(response);
         },
         });
	
	$.post("/Paola/AltaCurso");
	
}

$( document ).ready(function() {


    $("#altaCursoForm").submit(function(){
   	 
  

   	
   
   }
)
}
);



</script>

<body>

<form:form id="altaCursoForm" action="/Paola/AltaCurso" method="get" name="altaCursoForm" modelAttribute="curso">
	<div id="wrapper">
		
		<div id="wrappermiddle">

			<h3>ALTA CURSO</h3>
 

		
					<label>Ingresa nombre del curso</label>
					<input type="text" name="nombre" id="nombre" value="nombre" onclick="this.value = ''">
					<br>
					<br>
					<label>Ingresa la descripcion</label>
					<input type="text" name="descripcion" id="descripcion" value="descripcion" onclick="this.value = ''">
					<br>
					<br>
			
			<div id="submit">
			<a href="#" onclick="funcion()">submit</a>
			
<!-- 				<input type="image" src="resources/images/enviar.png" id="submit1" value="Sign In"> -->
				
			
			</div>


		

		</div>

		
	</div>
</form:form>
</body>
</html>