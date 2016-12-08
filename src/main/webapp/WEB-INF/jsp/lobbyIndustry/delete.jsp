<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: brian
  Date: 11/15/16
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Delete Lobby Industry</title>
    </head>
    <body>
    <h1>Delete Lobby Industry</h1>
        <form method="post">
            <ul>
                <li>client: <c:out value="${lobbyIndustry.getClient()}"/></li>
                <li>sub: <c:out value="${lobbyIndustry.getSub()}" />"</li>
                <li>total: <c:out value="${lobbyIndustry.getTotal()}" /></li>
                <li>year: <c:out value="${lobbyIndustry.getYear()}" /></li>
                <li>catcode: <c:out value="${lobbyIndustry.getCatcode()}"/></li>
            </ul>
            <button type="submit">Delete</button>
        </form>
    </body>
</html>
