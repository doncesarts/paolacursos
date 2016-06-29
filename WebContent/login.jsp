<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<spring:url value="/resources/css/style.css" var="mainCss" />


<link href="${mainCss}" rel="stylesheet" />

	<!-- General meta information -->
	<title>Cursos</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta name="robots" content="index, follow" />
	<meta charset="utf-8" />
	<!-- // General meta information -->
	
	
	<!-- Load Javascript -->
	<script type="text/javascript" src="resources/js/jquery.js"></script>
	<script type="text/javascript" src="resources/js/jquery.query-2.1.7.js"></script>
	<script type="text/javascript" src="resources/js/rainbows.js"></script>
	<!-- // Load Javascipt -->


	
<script>
 $( document ).ready(function() {
	
	$("#incorrecto").hide();
 		
    if (window.location.href.indexOf("?") != -1)
    	{
    	
    	 $("#incorrecto").show();
    	$("#incorrecto").toggleClass("ROJO");
    
    	}
    
     $("#loginform").submit(function(){
    	 

    	if (($("#usuario").val() == "") 
        || ($("#password").val() == "")){
    		
    		alert("Introduzca ambos datos");
    		return false;
    	}  
    }
 )
 }
 );


</script>
	
</head>
<body>

<form id="loginform" action="/Paola/procesaFormulario.do" method="get">
	<div id="wrapper">
		<div id="wrappertop"></div>

		<div id="wrappermiddle">

			<h2>Login</h2>
 

			<div id="username_input">
 	<label id="incorrecto">Usuario y/o password incorrecto</label>
 	<br />
 
				<div id="username_inputleft"></div>

				<div id="username_inputmiddle">
			
					<input type="text" name="usuario" id="usuario" value="E-mail Address" onclick="this.value = ''">
					<img id="url_user" src="resources/images/mailicon.png" alt="">
		
				</div>

				<div id="username_inputright"></div>

			</div>

			<div id="password_input">

				<div id="password_inputleft"></div>

				<div id="password_inputmiddle">
			
					<input type="password" name="password" id="password" value="Password" onclick="this.value = ''">
					<img id="url_password" src="resources/images/passicon.png" alt="">
			
				</div>

				<div id="password_inputright"></div>

			</div>

			<div id="submit">
			
				<input type="image" src="resources/images/enviar.png" id="submit1" value="Sign In">
				
			
			</div>


		

		</div>

		<div id="wrapperbottom"></div>
		
		<div id="powered">
		<p>Cursos</a></p>
		</div>
	</div>
</form>
</body>
</html>
