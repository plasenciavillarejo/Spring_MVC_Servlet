<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Da formato a los archivos JSP (Fechas, Números, etc ...)-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- Incluimos el tags lib propios de spring -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">    
		<meta name="description" content="">
		<meta name="author" content="">
		<title>Login</title>

		<!-- URLS -->
		<!-- #### -->
		
		<!-- Añadimos la url para acceder a la carpeta resources donde se ubican los archivos estáticos. -->
		<spring:url value="/resources" var="urlPublic" />
		<spring:url value="/login" var="login"/>


		<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
		<link href="${urlPublic}/css/style.css" rel="stylesheet">
		<link href="${urlPublic}/bootstrap/css/signin.css" rel="stylesheet">

	</head>

	<body>

	<!-- Inculimos la cabecera -->
	<!-- ##################### -->
	<jsp:include page="../includes/cabecera.jsp"></jsp:include>


	<div class="container theme-showcase" role="main">
			<hr class="featurette-divider">
			<img src="${urlPublic}/images/login.png" width="136" height="136" class="center">


		<!-- Por defecto cuando se introduce incorrectamente un usuasrio o contraseña spring-security realizar un REDIRECCIONAMIENTO de forma automática a la URL del formulario
		login pasandole como parámetro una llamada de error: 
			- http://localhost:8080/cineapp/login?error 
		Podemos capturar ese error para mostrar automáticamente una alerta que informe al usuario de lo sucedido-->

		<c:if test="${param.error != null}">
			<img alt="Imagen de Error" src="${urlPublic}/images/error.png"
				width="48" height="48" class="center">
			<h4 class="form-signin-heading" style="color: red; text-align:center;">Acceso
				denegado</h4>
		</c:if>

		<h3 class="form-signin-heading" style="text-align:center">CinePlasencia | Administración</h3> 
		
		<form class="form-signin" action="${login}" method="post">        
				<label for="username" class="sr-only">Usuario</label>
				<input type="text" id="username" name="username" class="form-control" placeholder="Usuario" required autofocus>
				
				<label for="password" class="sr-only">Contraseña</label>
				<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
				
				<!-- Input de tipo hidden para incluir el CSRF Token para prevenir los ataques de tipo Cross Site Request Forgery 
				(el valor del atributo name y value es generado por Spring Security). El CSRF Token es necesario en peticiones tipo POST, DELETE, PUT y PATCH. -->
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				
				<button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
			</form>
		
		<!-- FOOTER -->
		<!-- ###### -->
		<jsp:include page="../includes/footer.jsp"></jsp:include>

		</div> <!-- /container -->
		
	</body>
</html>
