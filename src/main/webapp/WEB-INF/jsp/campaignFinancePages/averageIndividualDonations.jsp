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
                	<h1>
                        Average Donation from Individuals
                    </h1>
                    <p>
                        These are the average donation amounts to candidates from individuals
                    </p>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Candidate</th>
                            <th>Amount</th>
                        </tr>
                        </thead>
                        <tbody>

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
