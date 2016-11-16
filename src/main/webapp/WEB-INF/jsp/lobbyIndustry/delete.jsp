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
        <form method="post">
            <label>client: </label> <c:out value="${lobbyIndustry.getClient()}"/>
            <label>sub</label> <c:out value="${lobbyIndustry.getSub()}" />"
            <label>total</label> <c:out value="${lobbyIndustry.getTotal()}" />
            <label>year</label> <c:out value="${lobbyIndustry.getYear()}" />
            <label>catcode</label> <c:out value="${lobbyIndustry.getCatcode()}"/>
            <button type="submit">Update</button>
        </form>
    </body>
</html>
