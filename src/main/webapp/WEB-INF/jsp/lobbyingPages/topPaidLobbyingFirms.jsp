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
                        Top Paid Lobbying Firms
                    </h1>
                    <p>
                        Lobbying can be big money!  Use this query to explore the top paid Lobbying Firms in America.
                    </p>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Sum Donated</th>
                            <th>Industry Code</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${averageIndustryList}" var="IndustryList" >
                            <tr>
                                <td>
                                    <c:out value="${IndustryList.getSumDonated}" />
                                </td>
                                <td>
                                    <fmt:formatNumber value="${IndustryList.getIndustryCode}"/>
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
