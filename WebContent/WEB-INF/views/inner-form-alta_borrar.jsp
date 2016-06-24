<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form id="loginform" action="/Paola/procesaFormulario" method="get">
	<div id="wrapper">
		<div id="wrappertop"></div>

		<div id="wrappermiddle">

			<h2>Login</h2>
 

			<div id="username_input">
 	<label id="incorrecto">Usuario y/o password incorrecto</label>
 	<br />
 
				<div id="username_inputleft"></div>

				<div id="username_inputmiddle">
			
					<input type="text" name="usuario" id="url" value="E-mail Address" onclick="this.value = ''">
					<img id="url_user" src="resources/images/mailicon.png" alt="">
		
				</div>

				<div id="username_inputright"></div>

			</div>

			<div id="password_input">

				<div id="password_inputleft"></div>

				<div id="password_inputmiddle">
			
					<input type="password" name="password" id="url" value="Password" onclick="this.value = ''">
					<img id="url_password" src="resources/images/passicon.png" alt="">
			
				</div>

				<div id="password_inputright"></div>

			</div>

			<div id="submit">
			
				<input type="image" src="resources/images/enviar.png" id="submit1" value="Sign In">
				<input type="image" src="resources/images/enviar.png" id="submit2" value="Sign In">
			
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