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
        <title>Update Lobby Industry</title>
    </head>
    <body>
    <h1>Update Lobby Industry</h1>
        <form method="post">
            <label>client</label>
            <input type="text" value="<c:out value="${lobbyIndustry.getClient()}" />"
                   disabled>
            <input type="hidden" name="client" value="<c:out value="${lobbyIndustry.getClient()}"/>">
            <label>sub</label>
            <input type="text" value="<c:out value="${lobbyIndustry.getSub()}" />" disabled>
            <input type="hidden" name="sub" value="<c:out value="${lobbyIndustry.getSub()}"/>">
            <label>total</label>
            <input name="total" type="text" value="<c:out value="${lobbyIndustry.getTotal()}" />">
            <label>year</label>
            <input type="text" value="<c:out value="${lobbyIndustry.getYear()}" />" disabled>
            <input type="hidden" name="year" value="<c:out value="${lobbyIndustry.getYear()}"/>">
            <label>catcode</label>
            <input name="catcode" type="text" value="<c:out value="${lobbyIndustry.getCatcode()}" />">
            <button type="submit">Update</button>
        </form>
    </body>
</html>
