<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<% String context = request.getContextPath(); %>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<fieldset>
    <legend>Registro persona</legend>
    <form action="<%=context%>/ServletPerson" method="post">
        <label for="">Nombre</label>
        <input type="text" name="name" >
        <label for="">Edad</label>
        <input type="number" name="age">
        <input type="submit" value="Registrar">
    </form>

    <c:import var = "data" url = "http://localhost:8080/CRUD_war_exploded/ServletPerson"/>
    <c:out value = "${data}"/>
</fieldset>
</body>
</html>