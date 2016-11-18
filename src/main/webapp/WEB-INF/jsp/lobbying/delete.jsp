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
                <li>uniqId: <c:out value="${lobbying.getUniqId()}"/></li>
                <li>regisrant: <c:out value="${lobbying.getRegistrant()}" />"</li>
                <li>client: <c:out value="${lobbying.getClient()}" /></li>
                <li>amount: <c:out value="${lobbying.getAmount()}" /></li>
                <li>catcode: <c:out value="${lobbying.getCatcode()}"/></li>
                <li>year: <c:out value="${lobbying.getYear()}"/></li>
            </ul>
            <button type="submit">Delete</button>
        </form>
    </body>
</html>
