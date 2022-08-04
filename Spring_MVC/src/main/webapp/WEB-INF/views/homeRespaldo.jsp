<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Da formato a los archivos JSP (Fechas, Números, etc ...)-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- Incluimos el tags lib propios de spring -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido a CinePlasencia.</title>

<!-- Añadimos la url para acceder a la carpeta resources donde se ubican los archivos estáticos. -->
<spring:url value="/resources" var="urlPublic" />

<link rel="stylesheet" href="${urlPublic}/bootstrap/css/bootstrap.min.css">

</head>
<body>



<%-- <link href="${urlPublic}/css/myStyle.css" rel="stylesheet"> --%>
<%-- <img src="${urlPublic}/images/cinema.png"> --%>

	<h1>Listado de peliculas.</h1>

	<div class="card">
		<div class="card-header">
			<h6 class="panel-title">Tabla de Películas</h6>
		</div>
		<div class="card-body">
			<!-- Lista ordenada de nuestras películas-->
			<table border="1"
				class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th>Id</th>
						<th>Título</th>
						<th>Duración</th>
						<th>Clasifiación</th>
						<th>Genero</th>
						<th>Imágen</th>
						<th>Fecha de Estreno</th>
						<th>Estatus</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${peliculas}" var="pelicula">
						<tr>
							<td>${pelicula.id}</td>
							<td>${pelicula.titulo}</td>
							<td>${pelicula.duracion}min</td>
							<td>${pelicula.clasificacion}</td>
							<td>${pelicula.genero}</td>
							
							<!-- Accedemos a la imágenes que están ubicada dentro de la carpeta resources -->
							<td><img src="${urlPublic}/images/${pelicula.imagen}" width="100" height="100"></td>
							
							<!--  Damos formato apoyandonos en tag "fmt" que nos proporciona spirng -->
							<td><fmt:formatDate value="${pelicula.fechaEstreno}" pattern="dd-MM-yyyy"/></td>
							
							<!-- Aplicamos el c:choosse para dar estilos a una pelicula si está activa o no -->
							<td>
								<c:choose>
									<c:when test="${pelicula.estatus=='Activa'}">
										<span class="badge bg-success">ACTIVA</span>
									</c:when>
									<c:otherwise>
										<span class="badge bg-danger">INACTIVA</span>
									</c:otherwise>
								
								
								</c:choose>
							
							
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>