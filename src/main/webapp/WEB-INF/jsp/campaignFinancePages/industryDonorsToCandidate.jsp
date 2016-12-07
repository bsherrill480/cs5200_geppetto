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
                        Top Industry Donors
                    </h1>
                    <p>
                        The top industry donations for   <c:out
                            value="${pacDonationToCandidateList[0].getPacName()}" />.
                    </p>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Candidate</th>
                            <th>Amount</th>
                            <th>Num. Donations</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pacDonationToCandidateList}" var="pac">
                            <tr>
                                <td>
                                    <c:out value="${pac.getCandName()}" />
                                </td>
                                    <%--<td><c:out value="${indiv.getTotalGiven()}" /></td>--%>
                                <td><fmt:formatNumber value="${pac.getAmount()}" /></td>
                                <td>
                                    <c:out value="${pac.getNumDonations()}" />
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
