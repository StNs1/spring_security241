<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br><br>
<a href="/logout">Выйти</a><br><br>
ID: ${user.id} <br><br>
Email: ${user.email} <br><br>
Password: ${user.password} <br><br>
Roles:
<select>
    <option selected disabled hidden></option>
    <c:forEach var="roles" items="${user.roles}">
        <option>${roles.name}</option>
    </c:forEach>
</select>
</body>
</html>