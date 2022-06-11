<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title> Welcome to airport</title>
</head>
<body>
<form method="post" action="flight">
    Start date:
    <input type="text" name="start_date"/></br>
    End date:
    <input type="text" name="end_date"/></br>
    Departure time:
    <select name="operator">
        <c:if test="${not empty times}">
            <c:forEach items="${times}" var="time">
                <option>${time}</option>
            </c:forEach>
        </c:if>
    </select>
    <input type="submit" name="book" value="book"></br>
</form>
</body>
</html>