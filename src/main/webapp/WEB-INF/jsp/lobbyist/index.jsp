<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Lobbyists</title>
    </head>
    <body>
        <h1>Lobbyists</h1>
        <form>
            <label>Search by uniqID:</label>
            <input name="uniqID" type="text" value="<c:out value="${uniqID}" />">
            <button type="submit">Go</button>
        </form>
        <div>
            <a href="/Lobbyists/create">Create New Lobbyist</a>
        </div>
        <div>
            <h3>Results:</h3>
            <table>
                <thead>
                <tr>
                    <th>uniqID</th>
                    <th>lobbyist</th>
                    <th>lobbyist_raw</th>
                    <th>lobbyist_id</th>
                    <th>year</th>
                    <th>OfficialPostion</th>
                    <th>cid</th>
                    <th>formercongmem</th>
                    <th>update</th>
                    <th>delete</th>
                </tr>
                </thead>
                <tbody>
                        <tr>
                            <td><c:out value="${lobbyist.getUniqId()}" /></td>
                            <td><c:out value="${lobbyist.getLobbyistRaw()}" /></td>
                            <td><c:out value="${lobbyist.getLobbyist()}" /></td>
                            <td><c:out value="${lobbyist.getLobbyistId()}" /></td>
                            <td><c:out value="${lobbyist.getYear()}" /></td>
                            <td><c:out value="${lobbyist.getOfficialPosition()}" /></td>
                            <td><c:out value="${lobbyist.getCid()}" /></td>
                            <td><c:out value="${lobbyist.getFormercongmen()}" /></td>
                            <td>
                                <a href="/Lobbyists/update/uniqID/<c:out
                                value="${lobbyist.getUniqId()}"/>">
                                    Update
                                
                                </a>
                            </td>
                            <td>
                                <a href="/Lobbyists/delete/uniqID/<c:out
                                value="${lobbyist.getUniqId()}"/>">
                                   Delete
                                </a>
                            </td>
                        </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
