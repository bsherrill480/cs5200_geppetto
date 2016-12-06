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
                        Individuals Donating The Most
                    </h1>
                    <p>
                        We often hear that our politicians are owned by corporations, but what
                        individuals who donate large amounts of money to politicians.
                    </p>
                    <h4>Filter by:</h4>
                    <div class="row horizontal-inputs-choice">
                        <form class="col-sm-4 col-sm-offset-1">
                            <label>State</label>
                            <div class="input-group">
                                <input class="form-control" name="state" maxlength="2">
                                <span class="input-group-btn">
                                    <button type=submit class="btn btn-default" type="button">
                                        Go
                                    </button>
                                </span>
                            </div>
                            <input type="hidden" value="" name="city">
                        </form>
                        <div class="col-sm-2 horizontal-inputs-choice__or">OR</div>
                        <form class="col-sm-4">
                            <label>City</label>
                            <div class="input-group">
                                <input class="form-control" name="city">
                                <span class="input-group-btn">
                                    <button type=submit class="btn btn-default" type="button">
                                        Go
                                    </button>
                                </span>
                            </div>
                            <input type="hidden" value="" name="state">
                        </form>
                    </div>
                    <h3>Top donations <c:out value="${tableTitleBy}"></c:out></h3>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Person</th>
                            <th>Amount</th>
                            <th>Num. Donation</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:choose>
                            <c:when test="${individualTotalDonationsList.size() == null}">
                                <%@include file="indivsDonatingTheMostTop100Table.jsp"%>
                            </c:when>
                            <c:when test="${individualTotalDonationsList.size() != null}">
                                <c:forEach items="${individualTotalDonationsList}" var="indiv" >
                                    <tr>
                                        <td>
                                            <a href="/IndividualContributions/contribID/<c:out
                                        value="${indiv.getContribID()}" />">
                                                <c:out value="${indiv.getContributor()}" />
                                            </a>
                                        </td>
                                            <%--<td><c:out value="${indiv.getTotalGiven()}" /></td>--%>
                                        <td><fmt:formatNumber value="${indiv.getTotalGiven()}"/></td>
                                        <td><c:out value="${indiv.getNumDonations()}" /></td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                        </c:choose>
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
