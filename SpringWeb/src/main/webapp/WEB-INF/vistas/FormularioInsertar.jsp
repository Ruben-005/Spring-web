<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Recursos/estilos/estilosProductos.css">
</head>

<form:form class="box" action="insertarProductos" modelAttribute="producto">

	<form:input path="idProductos" placeholder="ID"/>
	<form:input path="nombreProducto" placeholder="nombre"/>
	<form:input path="Precio" placeholder="Precio"/>
	<form:input path="Seccion" placeholder="Seccion"/>
	
	<button type="submit">Enviar</button>

</form:form>


<body>
</body>
</html>