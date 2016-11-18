<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Delete Lobbybill</title>
    </head>
    <body>
    <h1>Delete Lobbybill</h1>
        <form method="post">
            <ul>
                <li>B_ID: <c:out value="${lobbybill.getB_ID()}"/></li>
                <li>si_id: <c:out value="${lobbybill.getSi_ID()}" />"</li>
                <li>CongNo: <c:out value="${lobbybill.getCongNo}" /></li>
                <li>Bill_Name: <c:out value="${lobbybill.getBillName()}" /></li>
              
            </ul>
            <button type="submit">Delete</button>
        </form>
    </body>
</html>
