<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Update Lobbyist</title>
    </head>
    <body>
    <h1>Update Lobbyist</h1>
        <form method="post">
            <label>UniqId</label>
            <input type="text" value="<c:out value="${lobbyist.getUniqId()}" />"
                   disabled>
            <input type="hidden" name="uniqID" value="<c:out value="${lobbyist.getUniqId()}"/>">
            
            <label>lobbyist</label>
            <input type="text" value="<c:out value="${lobbyist.getLobbyist()}" />" disabled>
            <input type="hidden" name="lobbyist" value="<c:out value="${lobbyist.getLobbyist()}"/>">
            
            
            <label>lobbyist_raw</label>
            <input type="text" value="<c:out value="${lobbyist.getLobbyistRaw()}" />" disabled>
            <input type="hidden" name="lobbyist_raw" value="<c:out value="${lobbyist.getLobbyistRaw()}"/>">
            
            <label>lobbyistId</label>
            <input type="text" value="<c:out value="${lobbyist.getLobbyistId()}" />" disabled>
            <input type="hidden" name="lobbyist_id" value="<c:out value="${lobbyist.getLobbyistId()}"/>">
            
            <label>year</label>
            <input type="text" value="<c:out value="${lobbyist.getYear()}" />" disabled>
            <input type="hidden" name="year" value="<c:out value="${lobbyist.getYear()}"/>">
            
            <label>official position</label>
            <input name="Official Position" type="text" value="<c:out value="${lobbyist.getOfficialPosition()}" />">
            
            <label>cid</label>
            <input type="text" value="<c:out value="${lobbyist.getCid()}" />" disabled>
            <input type="hidden" name="cid" value="<c:out value="${lobbyist.getCid()}"/>">
            
            
            <label>formercongmem</label>
            <input name="formercongmem" type="text" value="<c:out value="${lobbyist.getFormercongmen()}" />">
 
            <button type="submit">Update</button>
        </form>
    </body>
</html>
