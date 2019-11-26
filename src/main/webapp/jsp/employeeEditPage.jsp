<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Сотрудники</title>
</head>
<body>
<form action="employee" method="post">
    <input name="id" type="hidden" value="${employee==null?"":employee.getId()}">
    <label>Фамилия</label>
    <input name="surname" type="text" value="${employee==null?"":employee.getSurname()}" required/>
    <label>Имя</label>
    <input name="name" type="text" value="${employee==null?"":employee.getName()}" required/>
    <label>Отчество</label>
    <input name="patronymic" type="text" value="${employee==null?"":employee.getPatronymic()}" required/>
    <label>Должность</label>
    <input name="position" type="text" value="${employee==null?"":employee.getPosition()}" required/>
    <input type="submit" value="Сохранить"/>
</form>
</body>
</html>
