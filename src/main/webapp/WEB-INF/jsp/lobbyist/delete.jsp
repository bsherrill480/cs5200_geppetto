<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Delete Lobbyist</title>
    </head>
    <body>
    <h1>Delete Lobbyist</h1>
        <form method="post">
            <ul>
                <li>uniqID: <c:out value="${lobbyist.getUniqId()}"/></li>
                <li>lobbyist_raw: <c:out value="${lobbyist.getLobbyistRaw()}" />"</li>
                <li>lobbyist_id: <c:out value="${lobbyist.getLobbyistId()}" /></li>
                <li>lobbyist: <c:out value="${lobbyist.getLobbyist()}" /></li>
                <li>year: <c:out value="${lobbyist.getYear()}" /></li>
                <li>official position: <c:out value="${lobbyist.getOfficialPosition()}"/></li>
            	<li>cid: <c:out value="${lobbyist.getCid()}" /></li>
            	<li>formercongmem: <c:out value="${lobbyist.getFormercongmen()}" /></li>
             
            </ul>
            <button type="submit">Delete</button>
        </form>
    </body>
</html>
