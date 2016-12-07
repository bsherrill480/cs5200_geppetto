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
                        The top industries donating to candidates.
                    </p>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Industry</th>
                            <th>Amount</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pacIndustryTotalDonationList}" var="pac">
                            <tr>
                                <td>
                                    <a href="/CampaignFinance/TopIndustryDonors/PrimCode/<c:out
                                    value="${pac.getPrimCode()}" />">
                                        <c:out value="${pac.getName()}" />
                                    </a>
                                </td>
                                    <%--<td><c:out value="${indiv.getTotalGiven()}" /></td>--%>
                                <td><fmt:formatNumber value="${pac.getAmount()}" /></td>
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
