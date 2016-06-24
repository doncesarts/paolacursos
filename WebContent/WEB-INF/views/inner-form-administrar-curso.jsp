<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<spring:url value="/resources/css/EstilosAdminastrador.css"
	var="mainCss" />


<link href="${mainCss}" rel="stylesheet" />


</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script type="text/javascript">
	function seleccionar() {
	 	$("#unidades").show();
		$("#Operacion").hide();
		


	}

	function upload() {
		
		var frm = $("#loginform");
		$.ajax({
			type : "POST",
			url : "/Paola/CursoAltaContenido.do",
			data : frm.serialize(),
			success : function(response) {
				// we have the response
				$('#wrapper').html(response);
			},
		});
		
		$("#archivos").show();
		$("Operacion").hide();
	}

	function funcion() {
		var x = document.getElementsByName('loginform');

		$("#temario").val(xml);

		var frm = $("#loginform");
		$.ajax({
			type : "POST",
			url : "/Paola/CursoAltaTemario.do",
			data : frm.serialize(),
			success : function(response) {
				// we have the response
				$('#wrapper').html(response);
			},
		});

		$.post("/Paola/CursoAltaTemario.do");

	}

	$(document).ready(function() {

		$("#Operacion").hide();
		$("#unidades").hide();
		$("#archivos").hide();

		$("#btSel").click(function() {

			$("#submit1").data('valor', 1);
			$("#Operacion").show();
			//	$("#unidades").show();
			$("#headerAdm").hide();
		})

	});

	$(document)
			.ready(
					function() {
						var iCnt = 0;
						var iCntSub = 0;

						// Crear un elemento div añadiendo estilos CSS
						var container = $(document.createElement('div')).css({
							padding : '5px',
							margin : '20px',
							width : '170px',
							borderTopColor : '#999',
							borderBottomColor : '#999',
							borderLeftColor : '#999',
							borderRightColor : '#999'
						});

						//agregado jon
						$("#temas").append(container);

						$('#btAdd')
								.click(
										function() {

											iCnt = iCnt + 1;
											iCntSub = 0;

											// Añadir caja de texto.
											$(container)
													.append(
															'<input type=text class="input" id=tb' + iCnt + ' ' +
	'value= "Unidad  " />');

											$("#tb" + iCnt).data("valor", iCnt);
											var valor = $("#tb" + iCnt).data(
													"valor");

											if (iCnt == 1) {

												var divSubmit = $(document
														.createElement('div'));

												$("#temas").append(divSubmit);
												$(divSubmit)
														.append(
																'<input type=button class="bt" onclick="GetTextValue()"'
																		+ 'id=btSubmit value=Enviar />');

											}

											$('#main').after(container,
													divSubmit);

										});

						$('#btAddSubTema')
								.click(
										function() {

											$("#headerAdm").hide();

											iCntSub = iCntSub + 1;

											// Añadir caja de texto.
											var tem = iCnt + "." + iCntSub;
											var id = iCnt * 100 + iCntSub;
											$(container)
													.append(
															'<input type=text class="input" id=tb' + id + ' ' +
'value="Tema " />');

											$("#tb" + id).data("valor", tem);
											var valor = $("#tb" + id).data(
													"valor");

											if (iCnt == 1) {

												var divSubmit = $(document
														.createElement('div'));

												$("#temas").append(divSubmit);

											}

											$('#main').after(container,
													divSubmit);

										});

						$('#btRemove').click(function() { // Elimina un elemento por click
							if (iCnt != 0) {
								$('#tb' + iCnt).remove();
								iCnt = iCnt - 1;
							}

							if (iCnt == 0) {
								$(container).empty();

								$(container).remove();
								$('#btSubmit').remove();
								$('#btAdd').removeAttr('disabled');
								$('#btAdd').attr('class', 'bt')

							}
						});

					});

	// Obtiene los valores de los textbox al dar click en el boton "Enviar"
	var divValue, values = '';
	var xml = '<TEMARIO>';
	var indice = 0;

	function GetTextValue() {

		$(divValue).empty();
		$(divValue).remove();
		values = '';

		$('.input').each(
				function() {
					divValue = $(document.createElement('div')).css({
						padding : '5px',
						width : '200px'
					});
					var tmp = $(this).data("valor") + '';

					if (tmp.indexOf(".") > -1) {
						values += '<H5>' + tmp + ' ' + this.value + '</H5>';
						xml += '<TEMA>' + this.value + '</TEMA>';
					} else {

						if (indice == 0) {
							xml = xml + '<UNIDAD><NOMBRE>' + this.value
									+ '</NOMBRE>';

							indice += 1;
						} else {
							xml = xml + '</UNIDAD><UNIDAD><NOMBRE>'
									+ this.value + '</NOMBRE>';
						}

						values += '<H4>' + tmp + ' ' + this.value + '</H4>'
					}
				});
		xml = xml + '</UNIDAD></TEMARIO>';

		$(divValue).append('<p><b>El Temario es :</b></p>' + values + '<br />');
		$('#right').append(divValue);

	}
</script>


<body>
	<div id="wrapper" class="flex-container">
		<div id="left">
			<form:form id="loginform" action="/Paola/CursoAltaTemario.do"
				method="post" modelAttribute="curso">


				<div id="wrappermiddle">

					<div id="headerAdm">
						<h2>ADMINISTRAR CURSO</h2>



						<label>Seleccione el nombre de curso</label>

						<form:select path="cursos" id="nombre">
							<form:options items="${cursos}" itemValue="nombre"
								itemLabel="nombre"></form:options>
						</form:select>



						<br> <br>


						<div id="submit">

							<input type="button" id="btSel" value="Seleccionar" class="bt" />
							<!-- 			<input type="image" src="resources/images/enviar.png"
								id="submit1" value="Sign In"> -->


						</div>

					</div>

					<div id="Operacion">
						<input type="button" id="btTemario" value="CrearTemario"
							class="bt" onclick="seleccionar()" /> 
							<input type="button"
							id="btPresentaciones" value="CrearPresentaciones" class="bt"
							onclick="upload()" />

					</div>

			

					<div id="unidades">

						<div id="temas">
							<input type="button" id="btAdd" value="Añadir Unidad" class="bt" />
							<input type="button" id="btAddSubTema" value="Añadir Subtema"
								class="bt" /> <input type="button" id="btRemove"
								value="Eliminar Elemento" class="bt" /> <input type="hidden"
								id="temario" name="temario" value="prueba" />
						</div>
						<br /> <a href="#" onclick="funcion()">submit</a>

				
					</div>



				</div>



			</form:form>
		</div>
		<div id="right"></div>
	</div>
</body>
</html>