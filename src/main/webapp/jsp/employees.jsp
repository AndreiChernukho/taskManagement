<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="css/style.css" rel="stylesheet" media="all">
    <title>Сотрудники</title>
</head>
<body>
<a href="employees">Обновить</a>
<a href="createEmployee">Добавить</a>

<table>
    <caption>Сотрудники</caption>
    <tr>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Должность</th>
        <th></th>
    </tr>

    <c:forEach var="employee" items="${employees}">
        <tr>
            <td><c:out value="${employee.getSurname()}"/></td>
            <td><c:out value="${employee.getName()}"/></td>
            <td><c:out value="${employee.getPatronymic()}"/></td>
            <td><c:out value="${employee.getPosition()}"/></td>
            <td>
                <a href="employee?id=${employee.getId()}&action=edit">Изменить</a>
                <a href="employee?id=${employee.getId()}&action=delete">Удалить</a>
            </td>
            </th>
        </tr>
    </c:forEach>
</table>
</body>
</html>
