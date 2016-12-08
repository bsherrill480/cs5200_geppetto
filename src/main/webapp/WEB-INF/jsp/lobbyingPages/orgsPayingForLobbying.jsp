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
                        Organizations Paying for Lobbying
                    </h1>
                    <p>
                        Often times, organizations will fund lobbying efforts for causes they are
                        aligned with. Use this query to explore varying organizations and their
                        donations.
                    </p>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Industry Code</th>
                            <th>Sum Donated</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${averageIndustryList}" var="IndustryList" >
                            <tr>
                                <td>
                                    <c:out value="${IndustryList.industryCode}"/>
                                </td>
                                <td>
                                    <fmt:formatNumber value="${IndustryList.sumDonated}" />
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
