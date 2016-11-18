<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Update Candidate</title>
    </head>
    <body>
    <h1>Update Candidate Cycle</h1>
        <form method="post">
            <label>FEC Candidate ID</label>            
            <input type="text" value="<c:out value="${candidate.getFecCandId()}" />"
                   disabled>
            <input type="hidden" name="fecCandId" value="<c:out value="${candidate.getFecCandId()}"/>">
            <label>cycle</label>
            <input type="text" name="cycle" value="<c:out value="${candidate.getCycle()}" />" maxlength="4">
            <button type="submit">Update</button>
        </form>
    </body>
</html>
