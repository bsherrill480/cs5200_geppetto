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
                        Top Lobbyied Issues
                    </h1>
                    <p>
                        What kind of issues would be most lobbyied? Let us find out.
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
                    </div> -->
                    <h3>Top Lobbyied Issues <c:out value="${tableTitleBy}"></c:out></h3>
                    <table class="table table-striped">
                        <thead>
                        <tr>
                            <th>Issues</th>
                            <th>Count</th>
                        </tr>
                        </thead>
                        <tbody>
                        <!-- Begin display data -->
                        
                        
                      <c:choose>
									<c:when test="${topLobbyIssuesList.size() != null}">
										<c:forEach items="${topLobbyIssuesList}"
											var="lobbyissue">
											<tr>
												<td><c:out value="${lobbyissue.getIssue()}" /></td>
											</tr>
											<tr>
												<td><c:out value="${lobbyissue.getCount()}" /></td>
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
