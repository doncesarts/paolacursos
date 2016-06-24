<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
  
  alert(nombre);
  return false;
    }
 )

}
);



</script>


<body>

<form id="loginform" action="#" method="get">
	<div id="wrapper">
		
		<div id="wrappermiddle">

			<h2>BAJA USUARIO</h2>
 

		
					<label>Seleccione el nombre de usuario</label>
					
			
  <select name="nombres" id="nombre">
    <option value="jonatan">Jonatan</option>
    <option value="Paola">Paola</option>
    <option value="Perla">Perla</option>
    <option value="Carlos">Carlos</option>
  </select>
  <br><br>


			<div id="submit">
			
				<input type="image" src="resources/images/enviar.png" id="submit1" value="Sign In">
				
			
			</div>


		

		</div>

		
	</div>
</form>
</body>
</html>