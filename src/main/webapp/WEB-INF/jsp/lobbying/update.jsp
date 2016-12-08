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
            <label>uniqId</label>
            <input type="text" value="<c:out value="${lobbying.getUniqId()}" />"
                   disabled>
            <input type="hidden" name="uniqId" value="<c:out
            value="${lobbying.getUniqId()}"/>">
            <label>registrant</label>
            <input type="text" value="<c:out value="${lobbying.getRegistrant()}" />"
                   name="registrant">
            <label>client</label>
            <input type="text" value="<c:out value="${lobbying.getClient()}" />"
                   name="client">
            <label>amount</label>
            <input type="text" value="<c:out value="${lobbying.getAmount()}" />"
                   name="amount">
            <label>catcode</label>
            <input type="text" value="<c:out value="${lobbying.getCatcode()}" />" name="catcode">
            <label>year</label>
            <input type="text" value="<c:out value="${lobbying.getYear()}" />"
                   name="year">
            <button type="submit">Update</button>
        </form>
    </body>
</html>
