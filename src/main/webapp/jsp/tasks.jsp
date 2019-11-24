<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%--подключили библиотеку тегов jstl core--%>

<html>
<head>
    <link href="css/style.css" rel="stylesheet" media="all">
    <title>Задачи</title>
</head>
<body>
<a href="tasks">Обновить</a>
<a href="task?action=add">Добавить</a>
<a href="index.jsp">Меню</a>
<c:if test='${"projects".equals(previewPage)}'>
    <a href="projects">Назад</a>
</c:if>

<table>
    <tr>
        <th>Статус</th>
        <th>Название</th>
        <th>Название проекта</th>
        <th>Сотрудник</th>
        <th></th>
    </tr>
    <c:forEach var="task" items="${tasks}">
        <tr>
            <td><div class="${task.getStatus()} status"/></td>
            <td>${task.getName()}</td>
            <td>${task.getProject().getName()}</td>
            <td>
                    ${String.format("%s %s %s", task.getEmployee().getSurname(),task.getEmployee().getName(),task.getEmployee().getPatronymic())}
            </td>
            <td>
                <a href="task?id=${task.getId()}&action=edit&previewPage=${previewPage}">Изменить</a>
                <a href="task?id=${task.getId()}&action=delete">Удалить</a>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
