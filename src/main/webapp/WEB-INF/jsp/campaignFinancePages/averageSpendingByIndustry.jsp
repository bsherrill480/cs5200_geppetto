<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">

<head>
    <%@include file="../header_content.jsp" %>
</head>

<body>
<div id="wrapper">

    <%@include file="../sidebar.jsp" %>

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1>
                        Average Spending By Industry
                    </h1>
                    <p>
                        Industries will donate differently, based on a variety of factors. Use this
                        query to explore the potential donation trends between varying industries
                    </p>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Org</th>
                            <th>Amount</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${averageIndustryList}" var="averageDonations" >
                            <tr>
                                <td>
                                    <c:out value="${averageDonations.org}" />
                                </td>
                                <td>
                                    <fmt:formatNumber value="${averageDonations.amount}"/>
                                </td>
                            </tr>
                        </c:forEach>
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
