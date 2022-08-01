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

	<ul>
		<c:forEach items="${peliculas}" var="pelicula">
			<li>${pelicula}</li>
		</c:forEach>
	</ul>

</body>
</html>