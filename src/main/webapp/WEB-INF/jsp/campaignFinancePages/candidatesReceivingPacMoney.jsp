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
                        Candidates Receiving Pac Money
                    </h1>
                    <p>
                        These are the candidates who have recieved the most money from Pacs.
                    </p>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Candidate</th>
                            <th>Amount</th>
                            <th>Num. Donation</th>
                        </tr>
                        </thead>
                        <tbody>

                                <c:forEach items="${candReceivingFromPacsList}" var="candRec" >
                                    <tr>
                                        <td>
                                            <a
                                                    href="/CampaignFinance/CandidatesReceivingPacMoney/FECCandID/<c:out
                                                        value="${candRec.getCandidate().getFecCandId()}"/>">
                                                <c:out
                                                        value="${candRec.getCandidate().getFirstLastP()}"/>
                                            </a>
                                        </td>
                                            <%--<td><c:out value="${indiv.getTotalGiven()}" /></td>--%>
                                        <td><fmt:formatNumber value="${candRec.getAmount()}"/></td>
                                        <td><c:out value="${candRec.getNumDonations()}" /></td>
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
