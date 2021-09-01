<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="../static/css/style.css">
    <link href="../static/css/bootstrap.min.css" rel="stylesheet"  >
    <script src="../static/js/bootstrap.bundle.min.js" ></script>

    <title>Квест "Сумречный замок"</title>

</head>
<body><div style="text-align: center"  class="container">
    <br>
    <br>

<h1>login & password</h1>
    <form method="post" action="/load">
        <input type="text" name="key" />
        <button>Загрузить игру</button>
    </form>
    <br>
<form method="post" action="/start">
    <input name="action_id" hidden="hidden" type="number"/>
    <button>Н А Ч А Т Ь&nbsp&nbsp&nbsp&nbspН О В У Ю</button><</form>
</div>
</body>
</html>
