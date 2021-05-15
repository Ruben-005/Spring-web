<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>
	
	<tr>
		<td>ID</td>
		<td>Nombre</td>
		<td>Precio</td>
		<td>Seccion</td>
	</tr>
	
	<c:forEach var="pr" items="${productos}">
	
	<tr>
		<td>${pr.idProductos}</td>
		<td>${pr.nombreProducto}</td>
		<td>${pr.precio}</td>
		<td>${pr.seccion}</td>
	</tr>	
	
	</c:forEach>
</table>

<button onclick="window.location.href='muestraFormularioInsertar'">Insertar Productos</button>

</body>
</html>