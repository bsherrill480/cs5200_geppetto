<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Lobby Issues</title>
    </head>
    <body>
        <h1>Lobby Issues</h1>
        <form>
            <label>Search by SI_ID:</label>
            <input name="SI_ID" type="text" value="<c:out value="${SI_ID}" />">
            <button type="submit">Go</button>
        </form>
        <div>
            <a href="/Lobbyissues/create">Create New Lobbyissue</a>
        </div>
        <div>
            <h3>Results:</h3>
            <table>
                <thead>
                <tr>
                    <th>SI_ID</th>
                    <th>uniqID</th>
                    <th>issueID</th>
                    <th>issue</th>
                    <th>SpecificIssue</th>
                    <th>year</th>
                    <th>update</th>
                    <th>delete</th>
                </tr>
                </thead>
                <tbody>
                  
                        <tr>
                            <td><c:out value="${lobbyissue.getSi_ID()}" /></td>
                            <td><c:out value="${lobbyissue.getUniqId()}" /></td>
                            <td><c:out value="${lobbyissue.getIssueId()}" /></td>
                            <td><c:out value="${lobbyissue.getIssue()}" /></td>
                            <td><c:out value="${lobbyissue.getSpecificIssue()}" /></td>
                            <td><c:out value="${lobbyissue.getYear()}" /></td>
                            <td>
                                <a href="/Lobbyissues/update/SI_ID/<c:out
                                value="${lobbyissue.getSi_ID()}"/>">
                                    Update
                                </a>
                            </td>
                            <td>
                                <a href="/Lobbyissues/delete/SI_ID/<c:out
                                value="${lobbyissue.getSi_ID()}"/>">
                                   Delete
                                </a>
                            </td>
                        </tr>
                </tbody>
            </table>
        </div> 
    </body>
</html>
