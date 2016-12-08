<%--
  Created by IntelliJ IDEA.
  User: brian
  Date: 11/15/16
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>Industry Code</title>
    </head>
    <body>
        <h1>Industry Code</h1>
        <form>
            <label>Search by catCode:</label>
            <input name="catCode" type="text" value="<c:out value="${catCode}" />">
            <button type="submit">Go</button>
        </form>
        <div>
            <a href="/IndustryCodes/create">Create New Industry Code</a>
        </div>
        <div>
            <h3>Results:</h3>
            <table>
                <thead>
                    <tr>
                        <th>catCode</th>
                        <th>catName</th>
                        <th>catOrder</th>
                        <th>industry</th>
                        <th>sector</th>
                        <th>sectorLong</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><c:out value="${industryCode.getCatCode()}" /></td>
                        <td><c:out value="${industryCode.getCatName()}" /></td>
                        <td><c:out value="${industryCode.getCatOrder()}" /></td>
                        <td><c:out value="${industryCode.getIndustry()}" /></td>
                        <td><c:out value="${industryCode.getSector()}" /></td>
                        <td><c:out value="${industryCode.getSectorLong()}" /></td>
                        <td>
                            <a href="/IndustryCodes/update/catCode/<c:out
                                    value="${industryCode.getCatCode()}"/>">
                                Update
                            </a>
                        </td>
                        <td>
                            <a href="/IndustryCodes/delete/catCode/<c:out
                                    value="${industryCode.getCatCode()}"/>">
                                Delete
                            </a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </body>
</html>
