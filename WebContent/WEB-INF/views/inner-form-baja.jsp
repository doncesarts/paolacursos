<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources/css/EstilosAdmin.css" var="mainCss" />


<link href="${mainCss}" rel="stylesheet" />


</head>

<script type="text/javascript">

$( document ).ready(function() {


     $("#loginform").submit(function(){
    	 
var nombre;
  nombre = $("#nombre").val();

  confirm("Estas seguro de eliminar a:" + nombre);
  //return false;
    }
 )

}
);



</script>


<body>

<form:form id="loginform" action="/Paola/BajaUsuarioConfirmacion" method="get" modelAttribute="usuario">
	<div id="wrapper">
		
		<div id="wrappermiddle">

			<h2>BAJA USUARIO</h2>
 

		
					<label>Seleccione el nombre de usuario</label>
		
	<form:select path="usuarios" id="nombre"> 
	<form:options items="${usuarios}" itemValue="usuario" itemLabel="usuario"></form:options>
	</form:select>



  <br><br>


			<div id="submit">
			
				<input type="image" src="resources/images/enviar.png" id="submit1" value="Sign In">
				
			
			</div>


		

		</div>

		
	</div>
</form:form>
</body>
</html>