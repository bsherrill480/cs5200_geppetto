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
                    <h4>Filter by:</h4>
                    <div class="row horizontal-inputs-choice">
                        <form class="col-sm-4 col-sm-offset-1">
                            <label>Industry</label>
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
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->
    </div>
    <!-- /#wrapper -->

</body>

</html>
