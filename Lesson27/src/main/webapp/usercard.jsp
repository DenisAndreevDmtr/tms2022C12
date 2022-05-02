<%@ page import="eshop.model.Product" %>
<%@ page import="java.util.List" %>
<%@ page import="eshop.model.CardStorage" %>
<%@ page import="java.math.BigDecimal" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<%
    int sum = 0;
%>
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
<h2 class="center">UserCard</h2>

<div class="container-buttons">
    <button class="btn-class">
        <img class="btn-img" onclick="location.href='${contextPath}/devices' " src="images/home.jpg" alt="home">
    </button>
</div>
<div class="container-fluid center">
    <c:if test="${not empty products}">
        <div class="row">
            <c:forEach items="${products}" var="products">
                <div class="card" type="products">
                    <div class="card-body">
                        <img class="card-img"
                             src="images/${products.getImageName()}" alt="Product image">
                        <div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item"><b>Name:</b> <a>${products.getName()}</a></li>
                                <li class="list-group-item"><b>Description:</b> <a>${products.getDescription()}</a></li>
                                <li class="list-group-item"><b>Price:</b> <a>${products.getPrice()}</a></li>

                            </ul>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</div>
<div>
    <%
        List<Product> products = CardStorage.getProductsInCard();
        BigDecimal result = products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    %>
    <div class="total-sum center">
        <b>Total sum <%out.println(result);%></b>
    </div>
</div>
</div>
</body>
</html>
