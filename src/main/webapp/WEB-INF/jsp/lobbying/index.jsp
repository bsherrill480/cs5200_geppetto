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
        <title>Lobbying</title>
    </head>
    <body>
        <h1>Lobbying</h1>
        <form>
            <label>Search by uniqId:</label>
            <input name="uniqId" type="text" value="<c:out value="${uniqId}" />">
            <button type="submit">Go</button>
        </form>
        <div>
            <h3>Results:</h3>
            <table>
                <thead>
                    <tr>
                        <th>uniqId</th>
                        <th>registrant</th>
                        <th>client</th>
                        <th>amount</th>
                        <th>catCode</th>
                        <th>year</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><c:out value="${lobbying.getUniqId()}" /></td>
                        <td><c:out value="${lobbying.getRegistrant()}" /></td>
                        <td><c:out value="${lobbying.getClient()}" /></td>
                        <td><c:out value="${lobbying.getAmount()}" /></td>
                        <td><c:out value="${lobbying.getCatcode()}" /></td>
                        <td><c:out value="${lobbying.getYear()}" /></td>
                        <td>
                            <a href="/Lobbying/update/uniqId/<c:out
                                    value="${lobbying.getUniqId()}"/>">
                                Update
                            </a>
                        </td>
                        <td>
                            <a href="/Lobbying/delete/uniqId/<c:out
                                    value="${lobbying.getUniqId()}"/>">
                                Delete
                            </a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
