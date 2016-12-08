<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Delete Lobbyissue</title>
    </head>
    <body>
    <h1>Delete Lobbyissue</h1>
        <form method="post">
            <ul>
            	<li>SI_ID: <c:out value="${lobbyissue.getSi_ID()}"/></li>
                <li>uniqID: <c:out value="${lobbyissue.getUniqId()}"/></li>
                <li>issueID: <c:out value="${lobbyissue.getIssueId()}" />"</li>
                <li>issue: <c:out value="${lobbyissue.getIssue()}" /></li>
                <li>SpecificIssue: <c:out value="${lobbyissue.getSpecificIssue()}" /></li>
                <li>year: <c:out value="${lobbyissue.getYear()}" /></li>
               
            </ul>
            <button type="submit">Delete</button>
        </form>
    </body>
</html>
