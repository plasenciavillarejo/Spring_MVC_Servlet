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
		
		
		<div class="panel-body">
		<!-- Agregamos validacíon en los campos de los formularios -->
		<!-- pelicula sería nuestro objeto de modelo Pelicula -> "pelicula"  -->
		<spring:hasBindErrors name="pelicula">
			<div class="alert alert-danger" role='alert'>
				Debe corregir los siguientes errores:
				<ul>
					<c:forEach items="${errors.allErrors}" var="error">
						<li><spring:message message="${error}"></spring:message>
						</li>
					</c:forEach>
				</ul>
			</div>


		</spring:hasBindErrors>


		<form action="${guardarPelicula}" method="post" enctype="multipart/form-data">
        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="titulo">Título</label>
              <input type="text" class="form-control" name="titulo" id="titulo" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="duracion">Duracion</label>
              <input type="text" class="form-control" name="duracion" id="duracion" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="clasificacion" class="control-label">Clasificacion</label>              
              <select id="clasificacion" name="clasificacion" class="form-control">
                <option value="A">Clasificacion A</option>
                <option value="B">Clasificacion B</option>
                <option value="C">Clasificacion C</option>                  
              </select>             
            </div> 
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="genero" class="control-label">Genero</label>              
              <select id="genero" name="genero" class="form-control">
                <option value="Accion">Accion</option>
                <option value="Aventura">Aventura </option>
                <option value="Clasicas">Clasicas</option>                  
                <option value="Comedia Romantica">Comedia Romantica</option>                  
                <option value="Drama">Drama</option>                  
                <option value="Terror">Terror</option>                  
                <option value="Infantil">Infantil</option>                  
                <option value="Accion y Aventura">Accion y Aventura</option>                  
                <option value="Romantica">Romantica</option>                  
              </select>             
            </div> 
          </div>         
        </div>

        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="estatus" class="control-label">Estatus</label>              
              <select id="estatus" name="estatus" class="form-control">
                <option value="Activa">Activa</option>
                <option value="Inactiva">Inactiva</option>               
              </select>             
            </div> 
          </div>   
            
          <div class="col-sm-3">
            <div class="form-group">
              <label for="fechaEstreno">Fecha Estreno</label>             
              <input type="text" class="form-control" name="fechaEstreno" id="fechaEstreno" required="required" />
            </div>  
          </div>

          <div class="col-sm-3">
            <div class="form-group">
              <label for="imagen">Imagen</label>
              <input type="file" id="archivoImagen" name="archivoImagen" />
              <p class="help-block">Imagen de la pelicula</p>
            </div> 
          </div>
        </div>

        <!--  
        <div class="page-header">
            <h3 class="blog-title"><span class="label label-success">Detalles</span></h3>
        </div>
 
        <div class="row">
          <div class="col-sm-3">
            <div class="form-group">
              <label for="director">Director</label>
              <input type="text" class="form-control" name="director" id="director" required="required" />
            </div>  
          </div>
          <div class="col-sm-3">
            <div class="form-group">
              <label for="actores">Actores</label>
              <input type="text" class="form-control" name="actores" id="actores" required="required" />
            </div>  
          </div>

          <div class="col-sm-6">
            <div class="form-group">
              <label for="trailer">URL del Trailer (Youtube)</label>
              <input type="text" class="form-control" name="trailer" id="trailer" placeholder="URL completa del video de YOUTUBE" required="required" />
            </div>  
          </div> 
        </div> 

        <div class="row">
          <div class="col-sm-6">
            <div class="form-group">
              <label for="sinopsis">Sinopsis</label>
              <textarea class="form-control" rows="5" name="sinopsis" id="sinopsis"></textarea>
            </div> 
          </div> 
        </div>
        -->
        
        <button type="submit" class="btn btn-danger" >Guardar</button>
        
		 <a href="${volverAtras}" type="button" class="btn btn-info">Volver</a>
        
      </form> 
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
