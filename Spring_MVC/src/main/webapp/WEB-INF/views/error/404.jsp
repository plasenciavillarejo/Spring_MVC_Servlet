<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Da formato a los archivos JSP (Fechas, N�meros, etc ...)-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Incluimos el tags lib propios de spring -->
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
	<!-- A�adimos la url para acceder a la carpeta resources donde se ubican los archivos est�ticos. -->
	<spring:url value="/resources" var="urlPublic" />

</head>
<body>

	<!-- Inculimos la cabecera -->
	<!-- ##################### -->
	<jsp:include page="../includes/cabecera.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">
		<div class="panel panel-danger">
			<div class="panel-heading">
				<h3 class="panel-title">Error 404.</h3>
			</div>
			<div class="panel-body">
				<img src="${urlPublic}/images/error.png" width="48" height="48"
					class="center">
				<h4>La p�gina solicitada no existe!</h4>
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