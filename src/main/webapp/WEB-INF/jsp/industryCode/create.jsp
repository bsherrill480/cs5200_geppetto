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
        <title>Create Industry Code</title>
    </head>
    <body>
    <h1>Create Industry Code</h1>
        <form method="post">
            <label>catCode</label>
            <input type="text" name="catCode">
            <label>catName</label>
            <input type="text" name="catName">
            <label>catOrder</label>
            <input type="text" name="catOrder">
            <label>industry</label>
            <input type="text" name="industry">
            <label>sector</label>
            <input type="text" name="sector">
            <label>sectorLong</label>
            <input type="text" name="sectorLong">
            <button type="submit">Create</button>
        </form>
    </body>
</html>
