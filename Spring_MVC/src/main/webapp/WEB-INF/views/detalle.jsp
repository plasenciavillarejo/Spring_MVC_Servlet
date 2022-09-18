<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
		<title>Detalles de la pelicula</title>

	<!-- URLS -->
	<!-- #### -->
	<!-- Añadimos la url para acceder a la carpeta resources donde se ubican los archivos estáticos. -->
	<spring:url value="/resources" var="urlPublic" />
	
	<spring:url value="/search" var="urlSearch" />


	</head>

	<body>

	<!-- Inculimos la cabecera -->
	<!-- ##################### -->
	<jsp:include page="includes/cabecera.jsp"></jsp:include>


		<div class="container theme-showcase" role="main">

			<!-- Marketing messaging -->
			<div class="container marketing">

				<div class="page-header">
					<h2>${pelicula.titulo}</h2>
				</div>
				<div class="row">
					<div class="col-sm-3">
						<p class="text-center">
							<img class="img-rounded" src="${urlPublic}/images/${pelicula.imagen}" alt="Generic placeholder image" width="155" height="220">            
						</p>
					</div>
					<div class="col-sm-9">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">DETALLES</h3>
							</div>
							<div class="panel-body">                           
								<p>
									Título Original : ${pelicula.titulo} <br>
									Actores : ${pelicula.detalle.actores} <br>
									Director: ${pelicula.detalle.director} <br>                  
									Clasificación: ${pelicula.clasificacion} <br>
									Duración: ${pelicula.duracion} minutos <br>
									Género: ${pelicula.genero} <br>                  
									Fecha Estreno: <fmt:formatDate value="${pelicula.fechaEstreno}" pattern="dd-MM-yyyy"/>
								</p> 

							</div>
						</div>                          
					</div>
				</div>

			<c:forEach items="${listarHorarios}" var="listHorarios">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<span class="label label-success">
								<fmt:formatDate value="${listHorarios.fecha}" pattern="dd-MM-yyyy"/>
							</span>
						</h3>
					</div>
					<div class="panel-body">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Hora</th>
									<th>Sala</th>
									<th>Precio</th>
								</tr>
							</thead>
							<tbody>
						
								<tr>
									<td>${listHorarios.hora}</td>
									<td>${listHorarios.sala}</td>
									<td>${listHorarios.precio} $</td>
								</tr>
						
							</tbody>
						</table>
					</div>
				</div>
			</c:forEach>

			<div class="row">
					<div class="col-sm-7">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">Trailer</h3>
							</div>
							<div class="panel-body">
								<iframe width="100%" height="315" src="${pelicula.detalle.trailer}" >                          
								</iframe>
							</div>
						</div>           
					</div> 
					<div class="col-sm-5">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">SINOPSIS</h3>
							</div>
							<div class="panel-body">
								<p>${pelicula.detalle.sinopsis}</p>
							</div>
						</div>                          
					</div>
				</div>

			</div><!-- /.container -->

			<hr class="featurette-divider">

	  <!-- FOOTER -->
      <!-- ###### -->
	<jsp:include page="includes/footer.jsp"></jsp:include>

		</div> <!-- /container -->

	</body>
</html>
