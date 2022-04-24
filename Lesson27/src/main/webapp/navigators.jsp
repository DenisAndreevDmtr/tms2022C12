<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Navigators</title>
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
<h2>Navigators</h2>

<div class="container-buttons">
    <button class="btn-class">
        <img class="btn-img" onclick="location.href='usercard.jsp' " src="images/pack.png" alt="pack">
    </button>
    <button class="btn-class">
        <img class="btn-img" onclick="location.href='home.jsp' " src="images/home.jpg" alt="home">
    </button>
</div>

<div class="container-fluid">
    <c:if test="${not empty navigators}">
        <div class="row">
            <c:forEach items="${navigators}" var="navigators">
                <form method="post" , action="/navigators">
                    <div class="card w-25 m-1" type="navigators">
                        <div class="card-body">
                            <img class="card-img" style="width:45%;height:100%"
                                 src="images/${navigators.getImageName()}" alt="Navigator image">
                            <div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><b>Name:</b> <a>${navigators.getName()}</a></li>
                                    <li class="list-group-item"><b>Description:</b>
                                        <a>${navigators.getDescription()}</a>
                                    </li>
                                    <li class="list-group-item"><b>Price:</b> <a>${navigators.getPrice()}</a></li>
                                </ul>
                                <div class="container-buttons">
                                    <button class="btn-class" type="submit">
                                        <img class="add-img" src="images/add.png" alt="add">
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="info-product-price">
                        <input type="hidden" name="picture" value="${navigators.getImageName()}"/>
                        <input type="hidden" name="name" value="${navigators.getName()}"/>
                        <input type="hidden" name="description" value="${navigators.getDescription()}"/>
                        <input type="hidden" name="price" value="${navigators.getPrice()}"/>
                    </div>
                </form>
            </c:forEach>
        </div>
    </c:if>
</div>
</div>
</body>
</html>
