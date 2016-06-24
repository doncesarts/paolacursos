<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alumnos</title>

<spring:url value="/resources/css/EstilosAlumno.css" var="mainCss" />


<link href="${mainCss}" rel="stylesheet" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script>

$( document ).ready(function() {


	$("a").click(function(){
		
		var url = $(this).attr("href");
		
		$("#center").load("http://localhost:8181/Paola/MostrarPresentacion.do?fileName=" +url );

		return false;
	

	});
 });

$( document ).ready(function() {
    
  	$("#toogle").click(function()
		{

		$("#menu").slideToggle();

		}	
	);



   
  });


    $(document).ready(function() {
    
    /*Si estoy situado dentro de un menu principal */
    
        $( '.menu li' ).hover(
           function(){
       			/* me posicion con el this dentro del elemento actual
       			y busco a sushermanos para levantar sus submenus */
            	$(this).siblings().find("ul").slideUp(200);
                $(this).find("ul").slideDown(200);
                
                /* obtenemos el tamaño actual del menu padre */
               var a = $(this).width();
               a = a * 1;
               
               /*colocamos el tamaño del menu hijo al 90 % del padre */
               	$(this).find("ul").css("width",a);
               
                
                 }
            
           
        );
    }); // end ready



/* Evento que se dispara en un resizing de windows */
$(window).bind('resize orientationchange', function() {
	
	/* obtenemos el pixelaje de la pantalla */
	ww = document.body.clientWidth;

});



</script>

</head>
<div id="Header">
<h1>CURSOS</h1>
</div>
	<div id="toogle" class="toogle-menu">Menu</div>




<div id="form2" class="flex-container">

	
<div id="left">
<ul  class="menu">

 
<c:forEach items="${unidades}" var="data">
  <li><a href="${data.ruta}">  ${data.unidad}</a></li>
   
</c:forEach>


		
	</ul></div>
<div id="center"></div>
<div id="right"></div>
</div>

<footer>
asdsad
</footer>
<!-- <div id="footer" class="flex-container">
<div id="leftFooter">a</div>
<div id="rightFooter">b</div>
</div> -->


</body>
</html>