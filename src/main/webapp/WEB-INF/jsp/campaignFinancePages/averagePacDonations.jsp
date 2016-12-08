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
                        Average Donation from PACs
                    </h1>
                    <p>
                        These are the average donation amounts to candidates from Political Action Committees
                    </p>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Candidate</th>
                            <th>Amount</th>
                        </tr>
                        </thead>
                        <tbody>
	                        <c:forEach items="${candidatesToAverageDonation}" var="candidateToAverageDonation" >
	                            <tr>
	                                <td>
	                                    <c:out value="${candidateToAverageDonation.key}" />
	                                </td>
	                                <td>
	                                	<fmt:formatNumber value="${candidateToAverageDonation.value}"/>
	                                </td>
	                            </tr>
	                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- /#page-content-wrapper -->
</div>
<!-- /#wrapper -->

</body>

</html>
