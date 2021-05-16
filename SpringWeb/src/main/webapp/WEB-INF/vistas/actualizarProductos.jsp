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
<body>

<form:form class="box"  action="actuProductos" modelAttribute="productos">

	<form:hidden path="idProductos"/>
	<h1>Actualiza</h1>
	<form:input path="nombreProducto" placeholder="Nombre"/>
	<form:input path="Precio" placeholder="Precio"/>
	<form:input path="Seccion" placeholder="Seccion"/>
	
	<button type="submit">Enviar</button>

</form:form>

</body>
</html>