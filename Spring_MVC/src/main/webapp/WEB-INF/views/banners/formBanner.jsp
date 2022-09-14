<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Da formato a los archivos JSP (Fechas, N�meros, etc ...)-->
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
				<form action="${urlForm}" method="post"
					enctype="multipart/form-data">
					<div class="row">
						<div class="col-sm-5">
							<div class="form-group">
								<label for="titulo">Titulo</label> <input type="text"
									class="form-control" name="titulo" id="titulo" required="required"/>
							</div>
						</div>

						<div class="col-sm-4">
							<div class="form-group">
								<label for="imagen">Imagen</label> <input type="file"
									id="archivoImagen" name="archivoImagen" required="required"/>
								<p class="help-block">Tama�o recomendado: 1140 x 250</p>
							</div>
						</div>

						<div class="col-sm-3">
							<div class="form-group">
								<label for="estatus">Estatus</label> <select id="estatus"
									name="estatus" class="form-control">
									<option value="NONE" label=" - Selecciona una opci�n - "/>
									<option value="Activo">Activo</option>
									<option value="Inactivo">Inactivo</option>
								</select>
							</div>
						</div>
					</div>

					<button type="submit" class="btn btn-danger">Guardar</button>
					
					 <a href="${volverAtras}" type="button" class="btn btn-info">Volver</a>
				</form>
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
