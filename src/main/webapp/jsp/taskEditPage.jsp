
<%@ page contentType="text/html;charset=UTF-8" language="java" import="task.TaskStatus" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Редактирование задачи </title>
</head>
<body>
<form action="task" method="post">

    <input type="hidden" name="id" value="${task.getId()}">

    <input type="hidden" name="previewPage" value="${previewPage}">

    <label>Название</label>
    <input type="text" name="name" value="${task==null ?"":task.getName()}" required>

    <label>Статус</label>
    <select  name="status" >
        <c:forEach var="statusName" items="${TaskStatus.values()}">
            <option ${task!=null  && task.getStatus()==statusName ?"selected":""}
                    value="${statusName}">${statusName}</option>
        </c:forEach>
    </select>

    <label>Проект</label>
    <select name="projectId" ${previewPage=="projects"?"disabled":""}>
        <c:forEach var="project" items="${projects}">

            <option ${task!=null && task.getProject().getId()==project.getId()?"selected":""} value="${project.getId()}">${project.getName()}</option>
        </c:forEach>
    </select>

    <label>Сотрудник</label>
    <select name="employeeId">
        <c:forEach var="employee" items="${employees}">
            <option ${task!=null && task.getEmployee().getId()==employee.getId()?"selected":""} value="${employee.getId()}">${employee.getSurname()}</option>
        </c:forEach>
    </select>

    <input type="submit" value="Сохранить"/>

</form>

</body>
</html>

