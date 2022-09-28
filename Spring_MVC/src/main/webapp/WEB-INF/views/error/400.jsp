<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">	
	<meta name="description" content="">
	<meta name="author" content="">
	<title>CinePlasencia | Bienvenido</title>
	
	
	<!-- URLS -->
	<!-- #### -->
	<!-- Añadimos la url para acceder a la carpeta resources donde se ubican los archivos estáticos. -->
	<spring:url value="/resources" var="urlPublic" />	

	</head>

<body>

	<!-- Inculimos la cabecera -->
	<!-- ##################### -->
	<jsp:include page="../includes/cabecera.jsp"></jsp:include>	
	
	<div class="container theme-showcase" role="main">

		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3 class="panel-title">Error 400</h3>
			</div>
			<div class="panel-body">
				<img src="${urlPublic}/images/error.png" width="48" height="48" class="center">
				<h4> El requerimiento enviado por el cliente es sintácticamente incorrecto!</h4>				
				<br>
				<button class="btn btn-success" onclick="goBack()">REGRESAR</button>
			</div>
		</div>

		<!-- FOOTER -->
		<!-- ###### -->
		<jsp:include page="../includes/footer.jsp"></jsp:include>
	</div> <!-- /container -->

	<script>
		function goBack() {
		    window.history.back();
		}
	</script>
	
</body>
</html>