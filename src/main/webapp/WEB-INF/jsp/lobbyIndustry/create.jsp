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
        <title>Create Lobby Industry</title>
    </head>
    <body>
    <h1>Create Lobby Industry</h1>
        <form method="post">
            <label>client</label>
            <input type="text" name="client">
            <label>sub</label>
            <input type="text" name="sub">
            <label>total</label>
            <input name="total" type="text">
            <label>year</label>
            <input type="text" name="year">
            <label>catcode</label>
            <input name="catcode" type="text">
            <button type="submit">Create</button>
        </form>
    </body>
</html>
