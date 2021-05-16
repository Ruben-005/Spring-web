<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form  action="actuProductos" modelAttribute="productos">

	Nombre<form:input path="nombreProducto"/>
	Presio<form:input path="Precio"/>
	Seccion<form:input path="Seccion"/>
	
	<button type="submit">Enviar</button>

</form:form>

</body>
</html>