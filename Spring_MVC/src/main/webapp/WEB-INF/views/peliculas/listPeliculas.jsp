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
<spring:url value="/peliculas/save" var="guardarPelicula" />
<spring:url value="/peliculas/create" var="crearPeliculas" />
<spring:url value="/" var="volverAtras"/>

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
			
			<c:choose>
				<c:when test="${mensajeConfirmacion != null}">
					<div id="alerta" class="alert alert-success" role="alert">${mensajeConfirmacion}</div>
				</c:when>
				<c:when test="${mensajeError != null}">
					<div id="alertaError" class="alert alert-danger" role="alert">${mensajeError}</div>
				</c:when>
			</c:choose>
							
			<div class="panel-body">
				<a href="${crearPeliculas}" class="btn btn-success" role="button"
					title="Nueva Pelicula">Nueva</a>
				<a href="${volverAtras}" type="button" class="btn btn-info">Volver</a>
					<br> <br>


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

						<c:forEach items="${listarPeliculas}" var="listaPeliculas">
							<tr>
								<td>${listaPeliculas.titulo}</td>
								<td>${listaPeliculas.genero}</td>
								<td>${listaPeliculas.clasificacion}</td>
								<td>${listaPeliculas.duracion}</td>
								<td><fmt:formatDate value="${listaPeliculas.fechaEstreno}" pattern="dd-MM-yyyy hh:mm:ss"/></td>
								<c:choose>
									<c:when test="${listaPeliculas.estatus eq 'Activa'}">
										<td><span class="label label-success">${listaPeliculas.estatus}</span></td>
									</c:when>
									<c:otherwise>
										<td><span class="label label-danger">${listaPeliculas.estatus}</span></td>
									</c:otherwise>
								</c:choose>
								<td>
									<a href="#" class="btn btn-success btn-sm" role="button" title="Edit">
										<span class="glyphicon glyphicon-pencil"></span>
									</a> 
									<a href="#" class="btn btn-danger btn-sm" role="button" title="Eliminar">
										<span class="glyphicon glyphicon-trash"></span>
									</a>
								</td>
							</tr>
						</c:forEach>
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

</body>

</html>
