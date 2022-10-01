<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Da formato a los archivos JSP (Fechas, Números, etc ...)-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- Incluimos el tags lib propios de spring -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- Tag de Spring Security para permitir o no renderizar una página según el rol que contenga el usuario -->
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Error</title>    

	<!-- URLS -->
	<!-- #### -->
	<spring:url value="/" var="urlPrincipal"/>

  </head>

  <body>

    <!-- Inculimos la cabecera -->
	<!-- ##################### -->
	<jsp:include page="../includes/cabecera.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <div class="jumbotron" style="text-align:center;">        
        <h3>Administración del Sistema</h3>
        
        <!-- Utilizamos la propiedad "property" que nos facilita sprinc security ya que con ella recuperara el usuario que ha accedido a la aplicación. 
        	Para recuperar el usuario debemos indicar: principal.username, por debajo es una instancia de UserDetailService de spring para obtener el usuario. -->
        <p>Bienvenido(a) usuario: <span style="color:red;"><sec:authentication property="principal.username"/> </span></p>

			<div style="text-align: center">
				<a href="${urlPrincipal}" type="button" class="btn btn-primary">Acceder</a>
			</div>

		</div>

		<!-- FOOTER -->
		<!-- ###### -->
		<jsp:include page="../includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->


    <script>
      function goBack() {
         window.history.back();
      }
    </script>
  </body>
</html>