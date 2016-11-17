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
            <label>catCode</label>
            <input type="text" value="<c:out value="${industryCode.getCatCode()}" />"
                   disabled>
            <input type="hidden" name="catCode" value="<c:out
            value="${industryCode.getCatCode()}"/>">
            <label>catName</label>
            <input type="text" value="<c:out value="${industryCode.getCatName()}" />"
                   name="catName">
            <label>catOrder</label>
            <input type="text" value="<c:out value="${industryCode.getCatOrder()}" />"
                   name="catOrder">
            <label>industry</label>
            <input type="text" value="<c:out value="${industryCode.getIndustry()}" />"
                   name="industry">
            <label>sector</label>
            <input type="text" value="<c:out value="${industryCode.getSector()}" />" name="sector">
            <label>sectorLong</label>
            <input type="text" value="<c:out value="${industryCode.getSectorLong()}" />"
                   name="sectorLong">
            <button type="submit">Update</button>
        </form>
    </body>
</html>
