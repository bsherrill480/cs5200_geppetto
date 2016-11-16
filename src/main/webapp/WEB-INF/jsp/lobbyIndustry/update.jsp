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
    <title>Title</title>
</head>
<body>
    <h1>Update</h1>
    <form action="/LobbyIndustries/doUpdate" method="post">
        <label>client</label>
        <input name="client" type="text" value="<c:out value="${lobbyIndustry.getClient()}" />"
               disabled>
        <label>sub</label>
        <input name="sub" type="text" value="<c:out value="${lobbyIndustry.getSub()}" />" disabled>
        <label>total</label>
        <input name="total" type="text" value="<c:out value="${lobbyIndustry.getTotal()}" />">
        <label>year</label>
        <input name="year" type="text" value="<c:out value="${lobbyIndustry.getYear()}" />" disabled>
        <label>catcode</label>
        <input name="catcode" type="text" value="<c:out value="${lobbyIndustry.getCatcode()}" />">
    </form>
</body>
</html>
