<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<spring:theme code="css.url"/>" type="text/css" />
<title>Alta Persona</title>
</head>
<body>

<form:form action="altaPersona" modelAttribute="persona" method="POST">
	<form:errors path="*"/>
	<spring:message code="persona.nombre.label"/> <form:input path="nombre"/> <form:errors path="nombre"/>
	<form:input path="apellido"/> <form:errors path="apellido"/>
	<form:input path="edad"/> <form:errors path="edad"/>
	<form:input path="altura"/> <form:errors path="altura"/>
	<form:radiobuttons path="sexo" items="${listadoSexos}"/>
	<form:button value="Enviar"/>	
</form:form>

<a href="altaPersona?locale=en">En</a>
<a href="altaPersona?locale=es">Es</a>
<a href="altaPersona?theme=aqua">Aqua</a>
<a href="altaPersona?theme=default">Default</a>

</body>
</html>