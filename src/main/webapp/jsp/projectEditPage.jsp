<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="css/style.css" rel="stylesheet" media="all">
    <title>Проект</title>
</head>
<body>
<form action="project" method="post">
    <input name="id" type="hidden" value="${project==null?"":project.getId()}">

    <div>
        <label>Название</label>
        <input name="name" type="text" value="${project==null?"":project.getName()}"/>
        <label class="error">${nameError}</label>
    </div>
    <div>
        <label>Описание</label>
        <input name="description" type="text" value="${project==null?"":project.getDescription()}" required/>
    </div>
    <div>
        <input class="button" type="submit" value="Сохранить"/>
    </div>
    <div class="button">
        <a href="projects">Отменить</a>
    </div>
</form>
</body>
</html>
