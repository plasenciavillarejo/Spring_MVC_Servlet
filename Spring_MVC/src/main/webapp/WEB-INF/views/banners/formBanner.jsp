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
      <meta name="description" content="">
      <meta name="author" content="">
      <title>Creacion de imagenes del Banner</title>    

	   <spring:url value="/banners/save" var="urlForm" />
	   <spring:url value="/banners/index" var="volverAtras"/>

   </head>

	<!-- Inculimos la cabecera -->
	<!-- ##################### -->
	<jsp:include page="../includes/cabecera.jsp"></jsp:include>

   <body id="a">
  
	<div class="container theme-showcase" role="main">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="blog-title">
					<span class="label label-success">Datos de la imagen</span>
				</h3>
			</div>
			
			<div class="panel-body">
				<form:form action="${urlForm}" method="post" enctype="multipart/form-data" modelAttribute="banner">
					<div class="row">
						<div class="col-sm-5">
							<div class="form-group">
								<label for="titulo">Titulo</label> 
								<form:input type="text" class="form-control" path="titulo" id="titulo"/>
								<form:errors id="validacionMensaje" path="titulo" class="alert alert-danger"></form:errors>
							</div>
						</div>

						<div class="col-sm-4">
							<div class="form-group">
								<label for="imagen">Imagen</label> <input type="file"
									id="archivoImagen" name="archivoImagen" />
								<p class="help-block">Tamaño recomendado: 1140 x 250</p>
							</div>
						</div>

						<div class="col-sm-3">
							<div class="form-group">
								<label for="estatus">Estatus</label> 
								<form:select id="estatus" path="estatus" class="form-control">
									<form:option value="1" label=" - Selecciona una opción - "/>
									<form:options items="${listaEstatus}" path="estatus"  />
								</form:select>
								<form:errors id="validacionMensaje" path="estatus" class="alert alert-danger"></form:errors>
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

   </body>
</html>
