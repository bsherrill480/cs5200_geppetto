<%--
  Created by IntelliJ IDEA.
  User: brian
  Date: 11/15/16
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Lobby Industries</title>
    </head>
    <body>
        <h1>Lobby Industries</h1>
        <form>
            <label>Search by client:</label>
            <input name="client" type="text" value="<c:out value="${client}" />">
            <button type="submit">Go</button>
        </form>
        <div>
            <a href="/LobbyIndustries/create">Create New Lobby Industry</a>
        </div>
        <div>
            <h3>Results:</h3>
            <table>
                <thead>
                <tr>
                    <th>client</th>
                    <th>sub</th>
                    <th>year</th>
                    <th>total</th>
                    <th>catcode</th>
                    <th>update</th>
                    <th>delete</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lobbyIndustries}" var="lobbyIndustry" >
                        <tr>
                            <td><c:out value="${lobbyIndustry.getClient()}" /></td>
                            <td><c:out value="${lobbyIndustry.getSub()}" /></td>
                            <td><c:out value="${lobbyIndustry.getYear()}" /></td>
                            <td><c:out value="${lobbyIndustry.getTotal()}" /></td>
                            <td><c:out value="${lobbyIndustry.getCatcode()}" /></td>
                            <td>
                                <a href="/LobbyIndustries/update/client/<c:out
                                value="${lobbyIndustry.getClient()}"/>/sub/<c:out
                                value="${lobbyIndustry.getSub()}"/>/year/<c:out
                                value="${lobbyIndustry.getYear()}"/>/">
                                    Update
                                </a>
                            </td>
                            <td>
                                <a href="/LobbyIndustries/delete/client/<c:out
                                value="${lobbyIndustry.getClient()}"/>/sub/<c:out
                                value="${lobbyIndustry.getSub()}"/>/year/<c:out
                                value="${lobbyIndustry.getYear()}"/>/">
                                   Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
