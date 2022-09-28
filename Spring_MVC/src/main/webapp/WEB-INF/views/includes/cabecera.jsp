<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Da formato a los archivos JSP (Fechas, Números, etc ...)-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Incluimos el tags lib propios de spring -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- URLS -->
<!-- #### -->
<spring:url value="/" var="volverAtras" />
<spring:url value="/peliculas/listarPeliculas" var="listarPeliculas" />
<spring:url value="/banners/index" var="listarBanners" />
<spring:url value="/contacto/index" var="contacto"/>
<spring:url value="/horario/crear" var="horario"/>


<!-- Añadimos la url para acceder a la carpeta resources donde se ubican los archivos estáticos. -->
<spring:url value="/resources" var="urlPublic" />

<link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
<link href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" rel="stylesheet">
<link href="${urlPublic}/css/style.css" rel="stylesheet">

<!-- Incluimos la cabecera. -->

	<!-- Fixed navbar -->
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${volverAtras}">My Cine-Plasencia</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="${listarPeliculas}?page=0">Peliculas</a></li>
					<li><a href="${listarBanners}">Banners</a></li>
					<li><a href="${contacto}">Contacto</a></li>
					<li><a href="${horario}">Horarios</a></li>
					<li><a href="#">Acerca</a></li>
					<li><a href="#">Login</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>