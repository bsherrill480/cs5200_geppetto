<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">

<head>
    <%@include file="../header_content.jsp"%>
</head>

<body>
<div id="wrapper">

    <%@include file="../sidebar.jsp"%>

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1>
                        Top Paid Lobbying Bills
                    </h1>
                    <p>
                        Lobbying Bill can be huge!  Let us explore the top paid Lobbying bills in the US.
                    </p>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Bill_ID</th>
                            <th>Bill_Name</th>
                            <th>Issue_ID</th>
                            <th>Issue</th>
                            <th>Amount</th>
                        </tr>
                        </thead>
                        <tbody>
                       <c:choose>
                       <c:when test="${toplobbybills.size() != null}">
                       <c:forEach items="${toplobbybills}"
							var="lobbyissue">
							<tr>
								<td><c:out value="${toplobbybills.getB_ID()}" /></td>
								<td><c:out value="${toplobbybills.getBill_Name()}" /></td>
								<td><c:out value="${toplobbybills.getIssueID()}" /></td>
								<td><c:out value="${toplobbybills.getIssue()}" /></td>
								<td><c:out value="${toplobbybills.getAmount()}" /></td>
							</tr>
							</c:forEach>
							</c:when>
						</c:choose>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>
    <!-- /#wrapper -->

</body>

</html>
