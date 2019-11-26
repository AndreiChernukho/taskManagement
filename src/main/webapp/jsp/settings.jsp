<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="css/style.css" rel="stylesheet" media="all">
    <title>Настройки</title>
</head>
<body>
<form action="settings" method="post">
    <label>URL сервера</label>
    <input name="urlServer" type="text" value="${settings.getUrlServer()}"/>
    <label>Максимальное количество записей в списках</label>
    <input name="maxLine" type="text" value="${settings.getMaxLine()}"/>
    <label>Количество дней по умолчанию между начальной и конечной датами в задаче</label>
    <input name="numberOfDays" type="text" value="${settings.getNumberOfDays()}"/>
    <input type="submit" value="Сохранить" />
</form>
</body>
</html>
