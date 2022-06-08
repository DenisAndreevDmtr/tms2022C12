<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
    <title> Date</title>
</head>
<body>
<h1>
    Your return ticket is booked!</h1>
<p>Departure time is: <fmt:formatDate type="both" value="${start_date}"/>
</p>

<p>Arrival time is: <fmt:formatDate type="both" value="${end_date}"/>
</p>

</body>
</html>