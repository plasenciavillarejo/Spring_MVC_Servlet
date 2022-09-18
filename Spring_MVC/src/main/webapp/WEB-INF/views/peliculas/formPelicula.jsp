<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

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
    <title>Creacion de Peliculas</title>

   
	<!-- URLS -->
	<!-- #### -->
	<spring:url value="/peliculas/save" var="guardarPelicula" />
	<spring:url value="/peliculas/listarPeliculas" var="volverAtras"></spring:url>
	
  </head>

  <body>

	<!-- Inculimos la cabecera -->
	<!-- ##################### -->
	<jsp:include page="../includes/cabecera.jsp"></jsp:include>
	

    <div class="container theme-showcase" role="main">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="blog-title">
					<span class="label label-success">Datos de la Pelicula</span>
				</h3>
			</div>
		
		
		<!-- Agregamos validacíon en los campos de los formularios -->
		<!-- pelicula sería nuestro objeto de modelo Pelicula -> "pelicula" 
		<spring:hasBindErrors name="pelicula"> 
			<div class="alert alert-danger" role='alert'>
					<form:errors path="pelicula.titulo" cssClass="form-error"></form:errors>
			</div>
		</spring:hasBindErrors>	
		 -->
		<div class="panel-body">

		<form:form action="${guardarPelicula}" method="post" enctype="multipart/form-data" modelAttribute="pelicula" 
			htmlEscape="true">
		
		<!-- ### Ocultamos el Id cuando se envíe el formulario para proteger nuestra seguridad ### -->
		<form:hidden id="id" path="id"/>
		
        <div class="row">
          	<div class="col-sm-3">
            	<div class="form-group">
             	  <label for="titulo">Título</label>
              		<form:input type="text" class="form-control" path="horario.titulo" id="titulo" required="required"
              			htmlEscape="true" />
              		<form:errors id="validacionMensaje" path="titulo" class="alert alert-danger"></form:errors>
            	</div>  
          	</div>
          
          <div class="col-sm-3">
            <div class="form-group">
              <label for="duracion">Duracion</label>
              <form:input type="text" class="form-control" path="duracion" id="duracion" required="required" />
              <form:errors id="validacionMensaje" path="duracion" class="alert alert-danger"></form:errors>
            </div>  
          </div>
          
          <div class="col-sm-3">
            <div class="form-group">
              <label for="clasificacion" class="control-label">Clasificacion</label>              
              <form:select id="clasificacion" path="clasificacion" class="form-control">
              	<form:option value="NONE" label=" - Selecciona una Opción -"/>
              	<form:options id="clasificacion" path="clasificacion" items="${listaClasificacion}" />
              </form:select>
              <form:errors id="validacionMensaje" path="clasificacion" class="alert alert-danger"></form:errors>          
            </div> 
          </div>
          
          <div class="col-sm-3">
            <div class="form-group">
              <label for="genero" class="control-label">Genero</label>              
              <form:select id="genero" path="genero" class="form-control">
				<form:option value="NONE" label=" - Selecciona una Opción -"/>
                <form:options id="genero" path="genero" items="${listarGeneros}" />               
              </form:select>   
              <form:errors id="validacionMensaje" path="genero" class="alert alert-danger"></form:errors>          
            </div> 
          </div>         
        </div>

        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="estatus" class="control-label">Estatus</label>              
              <form:select id="estatus" path="estatus" class="form-control">
                <form:option value="1" label=" - Selecciona una Opción -" />
     			<form:options items="${listarEstados}"/>
              </form:select>             
			  <form:errors id="validacionMensaje" path="estatus" class="alert alert-danger"></form:errors>          
            </div> 
          </div>   
            
          <div class="col-sm-3">
            <div class="form-group">
              <label for="fechaEstreno">Fecha Estreno</label>             
              <form:input type="text" class="form-control" path="fechaEstreno" id="fechaEstreno" required="required" />
            </div>  
          </div>

          <div class="col-sm-3">
            <div class="form-group">
              <label for="imagen">Imagen</label>
              <form:hidden path="imagen"/>
              <input type="file" id="archivoImagen" name="archivoImagen" />
              <p class="help-block">Imagen de la pelicula</p>
               
            </div> 
          </div>
        </div>

         
        <div class="page-header">
            <h3 class="blog-title"><span class="label label-success">Detalles</span></h3>
        </div>
 
        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="director">Director</label>
              <form:input type="text" class="form-control" path="detalle.director" id="director" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="actores">Actores</label>
              <form:input type="text" class="form-control" path="detalle.actores" id="actores" required="required" />
            </div>  
          </div>

          <div class="col-sm-6">
            <div class="form-group">
              <label for="trailer">URL del Trailer (Youtube)</label>
              <form:input type="text" class="form-control" path="detalle.trailer" id="trailer" 
              	placeholder="URL completa del video de YOUTUBE" required="required" />
            </div>  
          </div> 
        </div> 

        <div class="row">
          <div class="col-sm-6">
            <div class="form-group">
              <label for="sinopsis">Sinopsis</label>
              <form:textarea class="form-control" rows="5" path="detalle.sinopsis" id="sinopsis"></form:textarea>
            </div> 
          </div> 
        </div>
        
        
        <button type="submit" class="btn btn-danger" >Guardar</button>
        
		 <a href="${volverAtras}" type="button" class="btn btn-info">Volver</a>
        
      </form:form> 
      </div>
		</div>
      <hr class="featurette-divider">

      <!-- FOOTER -->
      <!-- ###### -->
	<jsp:include page="../includes/footer.jsp"></jsp:include>



    </div> <!-- /container -->
    <script>
      $(function () {
          $("#fechaEstreno").datepicker({dateFormat: 'dd-mm-yy'});
        }
      );
    </script>
    
  </body>
</html>
