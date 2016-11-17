<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Candidates</title>
    </head>
    <body>
        <h1>Candidates</h1>
        <form>
            <label>Search by cycle year:</label>
            <input name="year" type="text" value="<c:out value="${year}" />">
            <button type="submit">Go</button>
        </form>
        <div>
            <a href="/Candidates/create/">Add a Candidate</a>
        </div>
        <div>
            <h3>Results:</h3>
            <table>
                <thead>
                <tr>
                    <th>FirstLastP</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${candidates}" var="candidate" >
                        <tr>
                            <td><c:out value="${candidate.getFirstLastP()}" /></td>
                            <td>
                                <a href="/Candidates/updateCycle/fecCandId/<c:out
                                value="${candidate.getFecCandId()}"/>/">
                                    Update
                                </a>
                            </td>
                            <td>
                                <a href="/Candidates/delete/fecCandId/<c:out value="${candidate.getFecCandId()}"/>/">
                                   Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
