<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Da formato a los archivos JSP (Fechas, Números, etc ...)-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Incluimos el tags lib propios de spring -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">    
		<meta name="author" content="">
		<title>Creacion de Horarios</title>


	<!-- URLS -->
	<!-- #### -->
	<spring:url value="/" var="volverAtras"/>
	<spring:url value="/horario/save" var="guardarHorario" />
	

	</head>

	<body onload="reloj()">

	<!-- Inculimos la cabecera -->
	<!-- ##################### -->
	<jsp:include page="../includes/cabecera.jsp"></jsp:include>

	
	<div class="container theme-showcase" role="main">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="blog-title">Datos del Horario</h3>
			</div>

			<div class="panel-body">
				<form:form action="${guardarHorario}" modelAttribute="horario" method="post">
					
					<div class="row">
						<div class="col-sm-3">
							<div class="form-group">
								<label for="idPelicula" class="control-label">Pelicula</label>
								 	<form:select id="idPelicula" path="pelicula.titulo" class="form-control">
										<form:option value="NONE" label=" - Selecciona una Opción -"/>
              							<form:options id="clasificacion" items="${listarPelicluas}" />
								</form:select>
							</div>
						</div>
					
						<div class="col-sm-3">
							<div class="form-group">
								<label for="relojHorario">Reloj Horario</label>
								 	<output class="form-control" name="reloj" id="relojHora"></output>
							</div>
						</div>
						
					</div>
					
					<div class="row">
						<div class="col-sm-3">
							<div class="form-group">
								<label for="fecha">Fecha</label> 
								<form:input type="text" class="form-control" path="fecha" id="fecha" required="required" />
							</div>
						</div>
						
						<div class="col-sm-3">
							<div class="form-group">
								<label for="hora">Hora</label> 
									<form:input type="text" class="form-control" path="hora" id="hora"
									placeholder="Formato: HH:mm Ejemplo 21:30" required="required" />
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="sala" class="control-label">Sala</label> 
									<form:select id="sala" path="sala" class="form-control">
										<form:option value="NONE" label=" - Selecciona una Opción -"/>
										<form:options items="${listarSalas}"  id="salas"/>
									</form:select>
							</div>
						</div>

						<div class="col-sm-3">
							<div class="form-group">
								<label for="precio">Precio</label> <input type="text"
									class="form-control" name="precio" id="precio"
									required="required" />
							</div>
						</div>

					</div>

					<button type="submit" class="btn btn-danger">Guardar</button>
					
					<a href="${volverAtras}" type="button" class="btn btn-info">Volver</a>
				</form:form>
				
			</div>
		</div>
		
		<hr class="featurette-divider">
		
		<!-- FOOTER -->
		<!-- ###### -->
		<jsp:include page="../includes/footer.jsp"></jsp:include>
	
	</div>
	<!-- /container -->

	<script>
		$(function() {
			$("#fecha").datepicker({
				dateFormat : 'dd-mm-yy'
			});
		});
		
	var horaActual = '${relojHorario}';	
		
	function reloj() {

		var hoy = new Date();
		var h = hoy.getHours();
		var m = hoy.getMinutes();
		var s = hoy.getSeconds();

		m = actualizarHora(m);
		s = actualizarHora(s);

		document.getElementById("relojHora").innerHTML = h + ":" + m + ":" + s;

		var t = setTimeout(function() {
			reloj()
		}, 500);

		}

		function actualizarHora(i) {
			if (i < 10) {
				i = "0" + i
			}; // Cuando es menor de 10, se añade un cero -> 01:00 hasta las 09:59
			return i;
		}
	</script>
	</body>
</html>
