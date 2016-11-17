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
                <li>catCode: <c:out value="${lobbyIndustry.getCatCode()}"/></li>
                <li>catName: <c:out value="${lobbyIndustry.getCatName()}" />"</li>
                <li>catOrder: <c:out value="${lobbyIndustry.getCatOrder()}" /></li>
                <li>industry: <c:out value="${lobbyIndustry.getIndustry()}" /></li>
                <li>sector: <c:out value="${lobbyIndustry.getSector()}"/></li>
                <li>sectorLong: <c:out value="${lobbyIndustry.getSectorLong()}"/></li>
            </ul>
            <button type="submit">Delete</button>
        </form>
    </body>
</html>
