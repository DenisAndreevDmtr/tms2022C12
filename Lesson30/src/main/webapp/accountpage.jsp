<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Cars</title>
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
<h2>User info</h2>

<div class="container-buttons">
    <button class="btn-class">
        <img class="btn-img" onclick="location.href='${contextPath}/usercart' " src="images/pack.png" alt="pack">
    </button>
    <button class="btn-class">
        <img class="btn-img" onclick="location.href='${contextPath}/devices' " src="images/home.jpg" alt="home">
    </button>
</div>

<div class="container-fluid">
    <div class="row">
        <div class="card w-25 m-1" type="product">
            <div class="card-body">
                <img class="card-img" style="width:20%;height:20%"
                     src="images/usericon.png" alt="Userimage">
                <div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><b>User login:</b> <a>${userlogin}</a></li>
                        <li class="list-group-item"><b>User password:</b> <a>${userpassword}</a></li>
                        <li class="list-group-item"><b>User name:</b> <a>${username}</a></li>
                        <li class="list-group-item"><b>User surname:</b> <a>${usersurname}</a></li>
                        <li class="list-group-item"><b>User dateborn:</b> <a>${userdateborn}</a></li>
                        <li class="list-group-item"><b>user E-mail:</b> <a>${useremail}</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
