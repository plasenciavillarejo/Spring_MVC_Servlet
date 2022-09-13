<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Da formato a los archivos JSP (Fechas, Números, etc ...)-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Incluimos el tags lib propios de spring -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- Añadimos la url para acceder a la carpeta resources donde se ubican los archivos estáticos. -->
<spring:url value="/resources" var="urlPublic" />

<footer>
	<p class="pull-right">
		<a href="#">Back to top</a>
	</p>
	<p>
		&copy; 2022 My CinePlasencia, Inc. &middot; <a href="#">Privacy</a>
		&middot; <a href="#">Terms</a>
	</p>
</footer>

<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script type="text/javascript">

var mensajeConfirmacion = '${mensajeConfirmacion}';
	
		if(mensajeConfirmacion !== ""){
			console.log("dfdgfdf");
			setTimeout(function() {
				$("#alerta").fadeOut(1500);
			}, 3000);
		};

		//<div class="content">Hola, voy a desaparecer en 3 segundos!</div>
		//<div class="content2" style="display:none;">Hola, soy un nuevo div!</div>
//		 	$(document).ready(function() {
//		 	    setTimeout(function() {
//		 	        $(".content").fadeOut(1500);
//		 	    },3000);
			 
//		 	    setTimeout(function() {
//		 	        $(".content2").fadeIn(1500);
//		 	    },6000);
//		 	});
	
</script>