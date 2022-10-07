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
<meta name="author" content="">
<title>Creacion de Usuarios</title>

<!-- URLS -->
<!-- #### -->
<spring:url value="/usuarios/guardarUsuario" var="guardarUsuario" />
<spring:url value="/login" var="volverAtras"/>

</head>

<body>

	<!-- Inculimos la cabecera -->
	<!-- ##################### -->
	<jsp:include page="../includes/cabecera.jsp"></jsp:include>

	<div class="container theme-showcase" role="main">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="blog-title">Datos del Usuario</h3>
			</div>

			<div class="panel-body">
				<form:form action="${guardarUsuario}" modelAttribute="usuario"
					method="post">
					<div class="row">
						<div class="col-sm-3">
							<div class="form-group">
								<label for="perfil" class="control-label">Perfil</label> <select
									id="perfil" name="perfil" class="form-control">
									<option value="EDITOR">EDITOR</option>
									<option value="GERENTE">GERENTE</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<div class="form-group">
								<label for="cuenta">Cuenta</label>
								<form:input type="text" class="form-control" path="cuenta"
									id="cuenta" required="required" htmlEscape="true" />
							</div>
						</div>

						<div class="col-sm-3">
							<div class="form-group">
								<label for="pwd">Password</label>
								<form:input type="password" class="form-control" path="pwd"
									id="pwd" required="required" htmlEscape="true" />
							</div>
						</div>

						<div class="col-sm-3">
							<div class="form-group">
								<label for="email">Email</label>
								<form:input type="text" class="form-control" path="email"
									id="email" placeholder="Correo electrónico" required="required"
									htmlEscape="true" />
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="telefono">Teléfono</label>
								<form:input type="text" class="form-control" path="telefono"
									id="telefono" required="required" htmlEscape="true" />
							</div>
						</div>

						<div class="col-sm-3">
							<div class="form-group">
								<label for="telefono">Activo 
									<input type="checkbox" value="Activo" name="check" id="check" />
								</label>
							</div>
						</div>
					</div>

					<!-- Botonera -->

					<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
					<button type="submit" class="btn btn-danger">Guardar</button>
					<a href="${volverAtras}" type="button" class="btn btn-info">Volver</a>


				</form:form>
			</div>

		</div>

		<!-- /container -->
		<hr class="featurette-divider">

		<!-- FOOTER -->
		<!-- ###### -->
		<jsp:include page="../includes/footer.jsp"></jsp:include>
	</div>
	
</body>
</html>
