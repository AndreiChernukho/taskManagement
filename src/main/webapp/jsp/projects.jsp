<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="css/style.css" rel="stylesheet" media="all">
    <title>Проекты</title>
</head>
<body>
<a href="projects">Обновить</a>
<a href="createProject">Добавить</a>
<a href="index.jsp">Меню</a>
<table>
    <caption>Проекты</caption>
    <tr>
        <th>Наименование</th>
        <th>Описание</th>
        <th></th>
    </tr>

    <c:forEach var="project" items="${projects}">
        <tr>
            <td><c:out value="${project.getName()}"/></td>
            <td><c:out value="${project.getDescription()}"/></td>
            <td>
                <a href="tasks?projectId=${project.getId()}&previewPage=projects">Просмотреть задачи</a>
                <a href="project?id=${project.getId()}&action=edit">Изменить</a>
                <a href="project?id=${project.getId()}&action=delete">Удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
