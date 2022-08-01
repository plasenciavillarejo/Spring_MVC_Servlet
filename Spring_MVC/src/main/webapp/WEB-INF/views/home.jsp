<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido a CinePlasencia.</title>
</head>
<body>
	<h1>Listado de peliculas.</h1>

	<!-- Lista ordenada de nuestras películas-->
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Título</th>
				<th>Duración</th>
				<th>Clasifiación</th>
				<th>Genero</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${peliculas}" var="pelicula">
			<tr>
				<td>${pelicula.id}</td>
				<td>${pelicula.titulo}</td>
				<td>${pelicula.duracion} min</td>
				<td>${pelicula.clasificacion}</td>
				<td>${pelicula.genero}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>