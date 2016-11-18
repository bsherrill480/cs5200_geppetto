<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Delete Candidate</title>
    </head>
    <body>
    <h1>Delete Candidate</h1>
        <form method="post">
            <ul>
                <li>name: <c:out value="${candidate.getFirstLastP()}"/></li>
                <li>cycle: <c:out value="${candidate.getCycle()}"/></li>
                <li>running for: <c:out value="${candidate.getDistIdRunFor()}"/></li>
                <li>current district: <c:out value="${candidate.getDistIdCurr()}"/></li>
            </ul>
            <button type="submit">Delete</button>
        </form>
    </body>
</html>
