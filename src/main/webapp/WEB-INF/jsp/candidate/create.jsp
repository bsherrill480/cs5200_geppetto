<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Create Candidate</title>
    </head>
    <body>
    <h1>Create A Candidate</h1>
        <form method="post">
            <label>First Name</label>
            <input type="text" name="first" maxlength="20">
            <label>Last Name</label>
            <input type="text" name="last" maxlength="20">
            <label>Party</label>
            <input type="text" name="party" maxlength="1">
            <label>Cycle (Year)</label>
            <input type="text" name="cycle" maxlength="4">
            <label>District Run For</label>
            <input type="text" name="distIdRunFor" maxlength="4">
            <label>Current District</label>
            <input type="text" name="distIdCurr" maxlength="4">
            <button type="submit">Create</button>
        </form>
    </body>
</html>
