<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%-- <spring:url value="/resources/css/EstilosAdmin.css" var="mainCss" />


<link href="${mainCss}" rel="stylesheet" /> --%>


</head>

<script type="text/javascript">

function funcion(){
	var x = document.getElementsByName('loginform');


	var frm = $("#loginform");
	 $.ajax({
         type: "POST",
         url: "/Paola/AltaUsuario",
         data:  frm.serialize(),
         success: function(response){
             // we have the response
             $('#wrapper').html(response);
         },
         });
	
	$.post("/Paola/AltaUsuario");
	
}

$( document ).ready(function() {

    $("#loginform").submit(function(){
   	 

   	if ($("#password1").val() !=  $("#password2").val()){
   		
   		alert("los passwords son diferentes");
   		return false;
   	}  
   	
   	
   	if (($("#usuario").val() == "") 
   	        || ($("#password").val() == "")){
   	    		
   	    		alert("Introduzca todos los campos");
   	    		return false;
   	    	}  
   }
)
}
);



</script>


<body>

<form:form id="loginform" action="/Paola/AltaUsuario" method="get" name="loginform" modelAttribute="usuario">
	<div id="wrapper">
		
		<div id="wrappermiddle">

			<h3>ALTA USUARIO</h3>
 

		
					<label>Ingresa nombre de usuario</label>
					<input type="text" name="usuario" id="usuario" value="usuario" onclick="this.value = ''">
					<br>
					<br>
					<label>Ingresa su contraseña</label>
					<input type="password" name="password" id="password1" value="Password" onclick="this.value = ''">
					<br>
					<br>
				<label>Ingresa nuevamente la  contraseña</label>
					<input type="password" name="password" id="password2" value="Password" onclick="this.value = ''">
					<br>
					<br>
				<label>Ingresa su rol</label>
					<input type="text" name="rol" id="password2" value="rol" onclick="this.value = ''">
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