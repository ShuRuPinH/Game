<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="../static/css/style.css">
    <link href="../static/css/bootstrap.min.css" rel="stylesheet">
    <script src="../static/js/bootstrap.bundle.min.js"></script>

    <title>Квест "Сумеречный замок"</title>

</head>
<body onload="${state.location.stateDesc}; <c:if test="${state.info != null}">info(`${state.info}`)</c:if>">
<br><br>
<div id="title" class="col-8 container">
    <h1>Сумеречный замок
        <smaller>/ автор игры - Вета (evetaell)/</smaller>
    </h1>
</div>


<div class="container">

    <div class="row">


        <div id="secret_info" class="col-12 col-sm-12 col-md-8"><p>
            <c:if test="${state.location.secret !=null && !state.history.contains(state.location.id)}">
            <p>${state.location.secret}</p>
            <script>
                document.getElementById("secret_info").style.color = "red";
                document.getElementById("secret_info").style.backgroundImage = "url(../static/pics/b6u.gif)";
            </script>
            </c:if>
            </p></div>
        <div id="apple" class="  col-12 col-sm-12 col-md-4"></div>

    </div>
    <div class="row">


        <%--       TEXT         TEXT            TEXT     --%>
        <div id="text" class="col-12 col-sm-12 col-md-8"><p>${state.location.description}<p>
            <div class="">
                <form method="post" action="/start">
                    <c:forEach items="${state.location.actionList}" var="act">
                        <c:if test="${!act.hidden || state.itemList.containsKey(act.removeItem) ||
             (act.newItem!=null && !state.itemList.containsKey(act.newItem))||
             (act.noHaveItem!=null &&  !state.itemList.containsKey(act.noHaveItem))||
              (state.getLocationStatus(state.location.id)!=null  && state.getLocationStatus(state.location.id).equals(act.status))
                            }">
                            <button name="action_id" value="${act.id}">${act.description}</button>
                        </c:if>
                    </c:forEach>
                    <span id="item_action"></span>

                </form>



            </div>
        </div>
        <%--        INVENTAR      INVENTAR      INVENTAR      --%>
        <div id="inv" class="col-12 col-sm-12 col-md-4">

            <c:forEach items="${state.itemList}" var="item">

                <button class="items"
                        onclick="info('${item.value.description}');
                        <c:if test="${state.getItAct(item.key,state.location.id) != null &&( state.getItAct(item.key,state.location.id).removeItem ==null || state.itemList.containsKey(state.getItAct(item.key,state.location.id).removeItem))}">
                                itemAction(${state.getItAct(item.key,state.location.id).id},'${state.getItAct(item.key,state.location.id).description}', ${state.getItAct(item.key,state.location.id).status})
                                </c:if>" ;
                        name="action_id" value="${item.value.action}">
                        ${item.value.name} [${item.key}]
                </button>
                <br>
            </c:forEach>

        </div>

    </div>

</div>



<script>
    var timeoutID;

    function info(t) {
        document.getElementById("secret_info").style.color = "black";
        document.getElementById("secret_info").style.backgroundImage = "none";
        document.getElementById("secret_info").innerHTML = t;
        // timeoutID = window.setTimeout(clearInfo, 5000);
    }

    function clearInfo() {
        document.getElementById("secret_info").innerHTML = '';
    }

    function act(n) {
        // The rest of this code assumes you are not using a library.
        // It can be made less verbose if you use one.
        const form = document.createElement('form');
        form.method = 'post';
        form.action = "/start";
        const Field = document.createElement('input');
        Field.name = "action_id";
        Field.value = n;
        form.appendChild(Field);
        document.body.appendChild(form);
        form.submit();
    }


    function checkItem(id, text, is) {
        <c:set var="have" value="${state.itemList.containsKey(state.location.info)}"/>
        switch (is) {
            case "have": {
                if (${have}) {
                    document.getElementById(id).innerHTML = text;
                }
                break;
            }
            case "nohave": {
                if (${!have}) {
                    document.getElementById(id).innerHTML = text;
                }
                break;
            }
            default:
                break;
        }
    }

    <c:set var="loc_status" value="${state.getLocationStatus(state.location.id)}"/>
    function checkLocStatus(idSpan, text, locstatus) {
        let status =${loc_status}+0;


        if (locstatus == status) {
            document.getElementById(idSpan).innerHTML = text;
        }
    }



    function itemAction(id, descr, st) {
        let sta =${loc_status}+0;
        let st1 = st == null ? 0 : st;

        if (sta == st1 || st1 == 888){
        let teg= '<button name="action_id" value="' + id + '">' + descr + '</button>';

        document.getElementById("item_action").outerHTML = teg;}
    }

</script>
<%--Фонтан, сложенный из серого мрамора, давно пересох и потемнел от времени, на его дне валяется мусор.
<c:if test="${!state.itemList.containsKey(1)}" ><br>Мне кажется, что среди мусора что-то блестит.</c:if>--%>
<div id="footer" style="text-align: center" class="container"><div class="row">
  <div class="col"> <form method="post" action="/save">
        <button>Сохранить</button>
  </form></div>
    <div class="col"> <form method="post" action="/load">
        <button>Загрузить</button>
    </form></div>
   <div class="col"> <form method="post" action="/new">
        <button>Начать заново</button>
   </form></div></div>
</div>

</body>
</html>
