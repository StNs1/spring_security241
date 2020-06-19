<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>Управление</h1>
    <h2>
        <a href="/admin">Список всех пользователей</a><br><br>
        <a href="/logout">Выйти</a>
    </h2>
</center>
<div align="center">
    <form:form action="/admin/edit" method="post" modelAttribute="user">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Изменить пользователя
                </h2>
            </caption>
            <tr>
                <th>ID:</th>
                <td>${user.id} <form:hidden path="id"/></td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <form:input path="email" type="email" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Password:</th>
                <td>
                    <form:input path="password" type="text" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Role</th>
                <td>
                    <c:forEach items="${user.roles}" var="role">${role.authority}
                    <form:checkbox path="roles" value="${role.authority}" id="${role.id}"/></c:forEach>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>