<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/estilos/estilosObtenerProductos.css">
</head>
<body>

<table>
	
	<tr>
		<td class="titulo">ID</td>
		<td class="titulo">Nombre</td>
		<td class="titulo">Precio</td>
		<td class="titulo">Seccion</td>
		<td class="titulo">Accion</td>
	</tr>
	
	<c:forEach var="pr" items="${productos}">
	
	<c:url  var="p" value="cargarProductos">
		<c:param name="id" value="${pr.idProductos }"/>
		<c:param name="nombre" value="${pr.nombreProducto }"/>
		<c:param name="precio" value="${pr.precio }"/>
		<c:param name="seccion" value="${pr.seccion}"/>
	</c:url>
	
	<c:url  var="d" value="eliminarProductos">
		<c:param name="id" value="${pr.idProductos }"/>
	</c:url>

	<tr>
		<td class="items">${pr.idProductos}</td>
		<td class="items">${pr.nombreProducto}</td>
		<td class="items">${pr.precio}</td>
		<td class="items">${pr.seccion}</td>
		<td >
		<a class="link" href="${p}">Actulizar</a>
		<a class="link" href="${d}">Eliminar</a>
		</td>
	</tr>	
	
	</c:forEach>
</table>

<button class="boton" onclick="window.location.href='muestraFormularioInsertar'">Insertar Productos</button>

</body>
</html>