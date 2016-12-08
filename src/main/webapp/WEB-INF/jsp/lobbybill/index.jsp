
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Lobbying Bills</title>
    </head>
    <body>
        <h1>Lobbying Bills</h1>
        <form>
            <label>Search by SI_ID:</label>
            <input name="SI_ID" type="text" value="<c:out value="${si_id}" />">
            <button type="submit">Go</button>
        </form>
        <div>
            <a href="/LobbyingBills/create">Create New Lobby Bills</a>
        </div>
        <div>
            <h3>Results:</h3>
            <table>
                <thead>
                <tr>
                    <th>B_ID</th>
                    <th>si_id</th>
                    <th>CongNo</th>
                    <th>Bill_Name</th>
                    <th>update</th>
                    <th>delete</th>
                </tr>
                </thead>
                <tbody>
                   <c:forEach items="${lobbybills}" var="lobbybill" > 
                        <tr>
                            <td><c:out value="${lobbybill.getB_ID()}" /></td>
                            <td><c:out value="${lobbybill.getSi_ID()}" /></td>
                            <td><c:out value="${lobbybill.getCongNo()}" /></td>
                            <td><c:out value="${lobbybill.getBillName()}" /></td>
                           
                            <td>
                                <a href="/LobbyingBills/update/B_ID/<c:out
                                value="${lobbybill.getB_ID()}"/>/si_id/<c:out
                                value="${lobbybill.getSi_ID()}"/>/CongNo/<c:out
                                value="${lobbybill.getCongNo()}"/>/">
                                    Update
                                </a>
                            </td>
                            <td>
                                <a href="/LobbyingBills/delete/B_ID/<c:out
                                value="${lobbybill.getB_ID()}"/>/si_id/<c:out
                                value="${lobbybill.getSi_ID()}"/>/CongNo/<c:out
                                value="${lobbybill.getCongNo()}"/>/">
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
