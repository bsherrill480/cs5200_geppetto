<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Update Lobbyissue</title>
    </head>
    <body>
    <h1>Update Lobbyissue</h1>
        <form method="post">
            <label>SI_ID</label>
            <input type="text" value="<c:out value="${lobbyissue.getSi_ID()}" />"
                   disabled>
            <input type="hidden" name="SI_ID" value="<c:out value="${lobbyissue.getSi_ID()}"/>">
            
            <label>uniqID</label>
            <input type="text" value="<c:out value="${lobbyissue.getUniqId()}" />" disabled>
            <input type="hidden" name="uniqID" value="<c:out value="${lobbyissue.getUniqId()}"/>">
            
            
            <label>issueID</label>
            <input type="text" value="<c:out value="${lobbyissue.getIssueId()}" />" disabled>
            <input type="hidden" name="issueID" value="<c:out value="${lobbyissue.getIssueId()}"/>">
            
            <label>issue</label>
            <input type="text" value="<c:out value="${lobbyissue.getIssue()}" />" disabled>
            <input type="hidden" name="issue" value="<c:out value="${lobbyissue.getIssue()}"/>">
            
            <label>specific issue</label>
            <input type="text" value="<c:out value="${lobbyissue.getSpecificIssue()}" />" disabled>
            <input type="hidden" name="SpecificIssue" value="<c:out value="${lobbyissue.getSpecificIssue()}"/>">
            
            <label>year</label>
            <input type="text" value="<c:out value="${lobbyissue.getYear()}" />" disabled>
            <input type="hidden" name="year" value="<c:out value="${lobbyissue.getYear()}"/>">
          
            <button type="submit">Update</button>
        </form>
    </body>
</html>
