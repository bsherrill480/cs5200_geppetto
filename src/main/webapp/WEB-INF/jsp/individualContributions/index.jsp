<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
                    <!-- CONTENT GOES HERE -->
                    <h3>Contributions fors
                        <c:out value="${individualContributionsList[0].getContrib()}"></c:out></h3>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>To</th>
                            <th>Amount</th>
                            <th>Date</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${individualContributionsList}" var="indiv" >
                            <tr>
                                <td>
                                    <c:out value="${indiv.getRecipName()}" />
                                </td>
                                <td>
                                    <c:out value="${indiv.getAmount()}" />
                                </td>
                                <td>
                                    <c:out value="${indiv.getDate()}" />
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
