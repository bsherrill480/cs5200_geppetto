<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
    <%@include file="header_content.jsp" %>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet"/>
</head>

<body>
<div id="wrapper">

    <%@include file="sidebar.jsp" %>

    <!-- Page Content -->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <h1>Welcome to Geppetto</h1>
                    <p>
                        For those not familiar, Geppetto is a fictional character most famous for
                        creating Pinocchio. We thought this name fitting for our Web App, as similar
                        to Geppetto, our genuine curiosity drove us to create something amazing.
                        <br>
                        We started this project with a genuine interest in the US election process,
                        which, given the time of year and political climate of this past
                        Presidential election, made for interesting research and discourse. Although
                        this domain is extremely dynamic, we focused on the two areas that peeked
                        our interestthe most: Campaign Finance and Lobbying. The data you'll find in
                        the tool is representative of the information we thought most useful to the
                        average user.
                        <br>
                        Thank you for browsing and enjoy!

                    </p>
                </div>
            </div>
        </div>
    </div>
    <!-- /#page-content-wrapper -->
</div>
<!-- /#wrapper -->

</body>

</html>
