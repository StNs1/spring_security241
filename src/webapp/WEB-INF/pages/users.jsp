<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 align="center">
    <a href="/admin/add">Добавить пользователя</a><br><br>
    <a href="/logout">Выйти</a>
</h2>
<table border="1" align="center">
    <thead>
    <tr>
        <th colspan="5" align="center">Пользователи</th>
    </tr>
    </thead>
    <tr align="center">
        <td>ID</td>
        <td>Email</td>
        <td>Password</td>
        <td>Role</td>
        <td>Action</td>
    </tr>
    <c:forEach var="users" items="${list}">
        <tr>
            <td>${users.id}</td>
            <td>${users.email}</td>
            <td>${users.password}</td>
            <td>
                <c:forEach items="${users.roles}" var="role">${role.name}<br></c:forEach>
            </td>
            <td>
                <a href="/admin/edit?id=${users.id}">Изменить</a>
                <a href="/admin/delete?id=${users.id}">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>