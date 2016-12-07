<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
<%@include file="../header_content.jsp"%>
</head>
<body>
	<div id="wrapper">
		<%@include file="../sidebar.jsp"%>
		<!--Begin Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1>Lobbyists that are Former Congress Members</h1>
						<p>How many lobbyists are former Congress members?</p>
						<h4>Filter by:</h4>
						<div class="row horizontal-inputs-choice">
							<form class="col-sm-4 col-sm-offset-1">
								<label>State</label>
								<div class="input-group">
									<input class="form-control" name="state" maxlength="2"><span
										class="input-group-btn">
										<button type=submit class="btn btn-default" type="button">
											Go</button>
									</span>
								</div>
								<input type="hidden" value="" name="city">
							</form>
							<div class="col-sm-2 horizontal-inputs-choice__or">OR</div>
							<form class="col-sm-4">
								<label>City</label>
								<div class="input-group">
									<input class="form-control" name="city"><span
										class="input-group-btn">
										<button type=submit class="btn btn-default" type="button">
											Go</button>
									</span>
								</div>
								<input type="hidden" value="" name="state">
							</form>
						</div>

						<!-- Begin Data Display -->
						<h3>
							Former Congress Members
							<c:out value="${tableTitleBy}"></c:out>
						</h3>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Person</th>

								</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${formerCongressMemberLobbyist.size() != null}">
										<c:forEach items="${formerCongressMemberLobbyist}"
											var="lobbyist">
											<tr>
												<td><c:out value="${lobbyist.getLobbyist()}" /></td>
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
