<%--
  Created by IntelliJ IDEA.
  User: josenarvaez
  Date: 03/06/21
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Respuesta</title>
</head>
<body>
    ${mensaje}
    <table>
        <tr>
            <th>No. </th>
            <th>Nombre</th>
            <th>Edad</th>
            <th>Acción</th>
        </tr>
        <c:forEach items="${listPersons}" var="person" varStatus="status">
            <tr>
                <td>${status.count }</td>
                <td>${person.nombre}</td>
                <td>${person.edad}</td>
                <td>
                    <form action="${pageContext.servletContext.contextPath}/ServletPerson" method="PUT">
                        <input type="hidden" name="id" value="${person.id}">
                        <input type="submit" value="Actualizar">
                    </form>
                </td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
