<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Andreev Denis</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="stylestask1.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>


<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h2>
    <a>Denis Andreev web page</a>
</h2>
<div class="container-fluid">
    <b>Hello, my nave is Denis Andreev! I am glad to meet you here at my page.
        You can get brief information about me below.
    </b>
</div>
<div class="container-fluid">
    <c:if test="${not empty person}">
        <div class="card" type="person">
            <div class="card-body">
                <img class="card-img"
                     src="images/${person.getImageName()}" alt="Person image">
                <div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><b>Name:</b> <a>${person.getName()}</a></li>
                        <li class="list-group-item"><b>Surname:</b> <a>${person.getSurname()}</a></li>
                        <li class="list-group-item"><b>Age:</b> <a>${person.getAge()}</a></li>
                        <li class="list-group-item"><b>Experience in IT sphere:</b>
                            <a>${person.getExperienceInITsphere()}</a></li>
                        <li class="list-group-item"><b>Experience in other spheres:</b>
                            <a>${person.getExperienceInOthersphere()}</a></li>
                        <li class="list-group-item"><b>Languages:</b> <a>${person.getLanguages()}</a></li>
                        <li class="list-group-item"><b>Contact information:</b>
                            <a>${person.getContactInformation()}</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </c:if>
</div>
</div>
</body>
</html>
