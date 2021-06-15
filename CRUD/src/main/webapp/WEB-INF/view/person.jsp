<%@ page import="mx.edu.utez.CRUD.model.Person" %><%--
  Created by IntelliJ IDEA.
  User: josenarvaez
  Date: 03/06/21
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%Person person = (Person)request.getAttribute("person");%>
<input type="text" value="${person.id}">
    <p>ID: ${person.id}</p>
<p>Nombre: ${person.nombre}</p>
<p>Edad: ${person.edad}</p>
<%=person.getEdad()%>
</body>
</html>
