<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Laptops</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="styles.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h2>Laptops</h2>

<div class="container-fluid">
    <c:if test="${not empty laptops}">
        <div class="row">
            <c:forEach items="${laptops}" var="laptops">

                <div class="card w-25 m-1" type="laptops">
                    <div class="card-body">
                        <img class="card-img" style="width:45%;height:100%"
                             src="images/${laptops.getImageName()}" alt="Laptop image">
                        <div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item"><b>Name:</b> <a>${laptops.getName()}</a></li>
                                <li class="list-group-item"><b>Description:</b> <a>${laptops.getDescription()}</a></li>
                                <li class="list-group-item"><b>Price:</b> <a>${laptops.getPrice()}</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</div>
</div>
</body>
</html>
