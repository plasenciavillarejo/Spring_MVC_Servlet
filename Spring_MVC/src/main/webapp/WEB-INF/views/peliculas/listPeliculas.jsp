<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Da formato a los archivos JSP (Fechas, Números, etc ...)-->
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
<title>Listado de Peliculas</title>

<!-- URLS -->
<!-- #### -->
<!-- Añadimos la url para acceder a la carpeta resources donde se ubican los archivos estáticos. -->
<spring:url value="/resources" var="urlPublic" />
<spring:url value="/peliculas/save" var="guardarPelicula" />


<link href="${urlPublic}/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"
	rel="stylesheet">


</head>

<body>


	<!-- Inculimos la cabecera -->
	<!-- ##################### -->
	<jsp:include page="../includes/cabecera.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>Listado de Peliculas</h3>
			</div>
			<div class="panel-body">
				<a href="#" class="btn btn-success" role="button"
					title="Nueva Pelicula">Nueva</a><br> <br>


				<div class="table-responsive">
					<table class="table table-hover table-striped table-bordered">
						<tr>
							<th>Titulo</th>
							<th>Genero</th>
							<th>Clasificacion</th>
							<th>Duracion</th>
							<th>Fecha Estreno</th>
							<th>Estatus</th>
							<th>Opciones</th>
						</tr>
						<tr>
							<td>titulo</td>
							<td>genero</td>
							<td>clasificacion</td>
							<td>duracion</td>
							<!-- <td>fmt:formatDate value="${pelicula.fechaEstreno}" pattern="dd-MM-yyyy"/></td> -->
							<td>2017-05-05</td>
							<td><span class="label label-success">estatus</span></td>
							<td><a href="#" class="btn btn-success btn-sm" role="button"
								title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
								<a href="#" class="btn btn-danger btn-sm" role="button"
								title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
							</td>
						</tr>
						<tr>
							<td>titulo</td>
							<td>genero</td>
							<td>clasificacion</td>
							<td>duracion</td>
							<td>2017-05-05</td>
							<td><span class="label label-success">estatus</span></td>
							<td><a href="#" class="btn btn-success btn-sm" role="button"
								title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
								<a href="#" class="btn btn-danger btn-sm" role="button"
								title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
							</td>
						</tr>
						<tr>
							<td>titulo</td>
							<td>genero</td>
							<td>clasificacion</td>
							<td>duracion</td>
							<td>2017-05-05</td>
							<td><span class="label label-danger">estatus</span></td>
							<td><a href="#" class="btn btn-success btn-sm" role="button"
								title="Edit"><span class="glyphicon glyphicon-pencil"></span></a>
								<a href="#" class="btn btn-danger btn-sm" role="button"
								title="Eliminar"><span class="glyphicon glyphicon-trash"></span></a>
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<hr class="featurette-divider">

		<!-- FOOTER -->
		<!-- ###### -->
		<jsp:include page="../includes/footer.jsp"></jsp:include>

	</div>
	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</body>
</html>
