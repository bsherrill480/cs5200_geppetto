<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
	Pages:
    <ol>
        <c:forEach items="${pages}" var="page" >
            <li>
                <a href="<c:out value="${page}"/>"><c:out value="${page}"/></a>
            </li>
        </c:forEach>
    </ol>
</body>

</html>
