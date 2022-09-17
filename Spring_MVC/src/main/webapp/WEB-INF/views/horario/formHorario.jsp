<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Da formato a los archivos JSP (Fechas, N�meros, etc ...)-->
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

	<body>

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
								 	<form:select id="idPelicula" path="pelicula" class="form-control">
										<form:option value="NONE" label=" - Selecciona una Opci�n -"/>
              							<form:options id="clasificacion" items="${listarPelicluas}" />
								</form:select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<div class="form-group">
								<label for="fecha">Fecha</label> <input type="text"
									class="form-control" name="fecha" id="fecha"
									required="required" />
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="hora">Hora</label> <input type="text"
									class="form-control" name="hora" id="hora"
									placeholder="Formato: HH:mm Ejemplo 21:30" required="required" />
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="sala" class="control-label">Sala</label> <select
									id="sala" name="sala" class="form-control">
									<option value="Premium">Sala Premium</option>
									<option value="Sala 1">Sala 1</option>
									<option value="Sala 2">Sala 2</option>
									<option value="Sala 3">Sala 3</option>
								</select>
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
	</script>
	</body>
</html>
