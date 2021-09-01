<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="../static/css/style.css">
    <link href="../static/css/bootstrap.min.css" rel="stylesheet">
    <script src="../static/js/bootstrap.bundle.min.js"></script>

    <title>Квест "Сумеречный замок"</title>

</head>
<body >
<br><br>
<div id="title" class="col-8 container">
    <h1>Сумеречный замок
        <smaller>/ автор игры - Вета (evetaell)/</smaller>
    </h1>
</div>


<div class="container">

    <div class="row">


        <div id="secret_info" class="col-12 col-sm-12 col-md-8"><p>
         ${message}
            </p>
            <div style="text-align: center" class="container">
                <form method="post" action="/load">
                    <input type="text" name="key" />
                    <button>Загрузить игру</button>
                </form>
            </div></div>
        <div id="apple" class="  col-12 col-sm-12 col-md-4"></div>

    </div>



</div>



<script>

</script>
<%--Фонтан, сложенный из серого мрамора, давно пересох и потемнел от времени, на его дне валяется мусор.
<c:if test="${!state.itemList.containsKey(1)}" ><br>Мне кажется, что среди мусора что-то блестит.</c:if>--%>
<div style="text-align: center" class="container">
    <form method="post" action="/new">
        <button>Начать заново</button>
    </form>
</div>

</body>
</html>
