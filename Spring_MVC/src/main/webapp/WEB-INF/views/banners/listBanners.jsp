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
<title>Listado de imagenes del banner</title>


<!-- URLS -->
<!-- #### -->
<spring:url value="/banners/create" var="crearBanner" />
<spring:url value="/" var="volverAtras"/>

</head>

<body>

	<!-- Inculimos la cabecera -->
	<!-- ##################### -->
	<jsp:include page="../includes/cabecera.jsp"></jsp:include>


	<div class="container theme-showcase" role="main">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>Listado de imagenes del Banner</h3>
			</div>

			<c:if test="${mensajeConfirmacion != null}">
				<div id="alerta" class="alert alert-success" role="alert">${mensajeConfirmacion}</div>
			</c:if>

			<div class="panel-body">
				<a href="${crearBanner}" class="btn btn-success" role="button"
					title="Nueva Pelicula">Nuevo Banner</a>

				<a href="${volverAtras}" type="button" class="btn btn-info">Volver</a>

				<br> <br>
				<div class="table-responsive">
					<table class="table table-hover table-striped table-bordered">
						<tr>
							<th>Id</th>
							<th>Titulo</th>
							<th>Fecha Publicacion</th>
							<th>Nombre Archivo</th>
							<th>Estatus</th>
							<th>Opciones</th>
						</tr>
						<c:forEach items="${listaBanners}" var="listaBanners">
						<tr>
							<td>${listaBanners.id}</td>
							<td>${listaBanners.titulo }</td>
							<td><fmt:formatDate value="${listaBanners.fecha}" pattern="dd-MM-yyyy"/></td>
							<td>${listaBanners.archivo}</td>
							<td><c:choose>
										<c:when test="${listaBanners.estatus eq 'Activa'}">
											<span class="label label-success">${listaBanners.estatus}</span>
										</c:when>
										<c:otherwise>
											<span class="label label-danger">${listaBanners.estatus}</span>
										</c:otherwise>
									</c:choose></td>
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
