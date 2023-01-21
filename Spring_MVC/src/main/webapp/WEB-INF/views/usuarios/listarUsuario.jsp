<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Usuarios</title>
</head>
<body>


	<c:forEach items="${listadoUsuario}" var="usuario">
		<c:out value="${usuario.id}" />
		<c:out value="${usuario.titulo}" />
		<c:out value="${usuario.duracion}" />
		<c:out value="${usuario.clasificacion}" />
		<c:out value="${usuario.genero}" />
		<c:out value="${usuario.imagen}" />
		<c:out value="${usuario.fechaEstreno}" />
		<c:out value="${usuario.estatus}" />
	</c:forEach>


</body>
</html>