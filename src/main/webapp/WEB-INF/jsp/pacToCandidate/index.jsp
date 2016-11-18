<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>PAC Donations to Candidates</title>
    </head>
    <body>
        <h1>PAC Donations to Candidates</h1>
        <form>
            <label>From: </label>
            <!--
            <select>
                <option value="All">All</option>
            	<c:forEach items="${committees}" var="committee">
            		<option value="<c:out value="${committee.getPACShort()}"/>"><c:out value="${committee.getPACShort()}"/></option>
                </c:forEach>
            </select>
              -->
            <input name="pacShort" list="pacs" value="<c:out value="${selCmte}"/>">
            <datalist id="pacs">
            	<option value="All">
            	<c:forEach items="${committees}" var="committee">
            		<option value="<c:out value="${committee.getPACShort()}"/>">
                </c:forEach>
            </datalist>
            <span>To: </span>
            <!-- 
            <select>
            	<option value="All">All</option>
            	<c:forEach items="${candidates}" var="candidate">
            		<option value="<c:out value="${candidate.getFirstLastP()}"/>"><c:out value="${candidate.getFirstLastP()}"/></option>
                </c:forEach>            
            </select>
            -->
            <input name="candFirstLastP" list="candidates" value="<c:out value="${selCand}"/>">
            <datalist id="candidates">
            	<option value="All">
            	<c:forEach items="${candidates}" var="candidate">
            		<option value="<c:out value="${candidate.getFirstLastP()}"/>">
                </c:forEach>
            </datalist>
            <button type="submit">Go</button>
        </form>
        <div>
            <h3>Results:</h3>
            <table>
                <thead>
                <tr>
                    <th>Date</th>
                    <th>Committee</th>
                    <th>Amount</th>
                    <th>Candidate</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${donations}" var="donation" >
                        <tr>
                            <td><c:out value="${donation.getDate()}" /></td>
                            <td><c:out value="${donation.getCommittee().getPACShort()}" /></td>
                            <td><c:out value="${donation.getAmount()}" /></td>
                            <td><c:out value="${donation.getCandidate().getFirstLastP()}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
