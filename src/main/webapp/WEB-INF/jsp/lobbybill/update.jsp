<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: brian
  Date: 11/15/16
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Update Lobby Bill</title>
    </head>
    <body>
    <h1>Update Lobby Bill</h1>
        <form method="post">
            <label>B_ID</label>
            <input type="text" value="<c:out value="${lobbybill.getB_ID()}" />"
                   disabled>
            <input type="hidden" name="B_ID" value="<c:out value="${lobbybill.getB_ID()}"/>">
            <label>si_id</label>
            <input type="text" value="<c:out value="${lobbybill.getSi_ID()}" />" disabled>
            <input type="hidden" name="si_id" value="<c:out value="${lobbybill.getSi_ID())}"/>">
            <label>CongNo</label>
            <input name="total" type="text" value="<c:out value="${lobbybill.getCongNo()}" />">
            <label>Bill_Name</label>
            <input type="text" value="<c:out value="${lobbybill.getBillName()}" />" disabled>
            <input type="hidden" name="Bill_Name" value="<c:out value="${lobbybill.getBillName()}"/>">
            <button type="submit">Update</button>
        </form>
    </body>
</html>
