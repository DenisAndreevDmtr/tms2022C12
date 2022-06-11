<%@ page import="Product" %>
<%@ page import="java.util.List" %>
<%@ page import="Cart" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="Cart" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <title>UserCard</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="stylesforusercard.css" rel="stylesheet" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h2 class="center">UserCart</h2>

<div class="container-buttons">
    <button class="btn-class">
        <img class="btn-img" onclick="location.href='${contextPath}/devices' " src="images/home.jpg" alt="home">
    </button>
    <button class="btn-class">
        <img class="btn-img" onclick="location.href='${contextPath}/accountpage' " src="images/usericon.png"
             alt="usericon">
    </button>
</div>
<div class="container-fluid center">
    <c:if test="${not empty cart}">
        <div class="row">
            <c:forEach items="${cart.getProductsInCart()}" var="cartitem">
                <form method="post" , action="/usercart">
                    <div class="card" type="cart">
                        <div class="card-body">
                            <img class="card-img"
                                 src="images/${cartitem.getImageName()}" alt="Product image">
                            <div>
                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item"><b>Name:</b> <a>${cartitem.getName()}</a></li>
                                    <li class="list-group-item"><b>Description:</b> <a>${cartitem.getDescription()}</a>
                                    </li>
                                    <li class="list-group-item"><b>Price:</b> <a>${cartitem.getPrice()}</a></li>
                                </ul>
                                <div class="container-buttons">
                                    <button class="btn-class" type="submit">
                                        <img class="add-img" src="images/delete.png" alt="delete">
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="info-product-price">
                        <input type="hidden" name="picture" value="${cartitem.getImageName()}"/>
                        <input type="hidden" name="name" value="${cartitem.getName()}"/>
                        <input type="hidden" name="description" value="${cartitem.getDescription()}"/>
                        <input type="hidden" name="price" value="${cartitem.getPrice()}"/>
                        <input type="hidden" name="idcategory" value="${cartitem.getId()}"/>
                    </div>
                </form>
            </c:forEach>
        </div>
    </c:if>
</div>
<div>

    <div class="total-sum center">
        <b>Total sum ${totalsum}</b>

    </div>
</div>
</div>
</body>
</html>
