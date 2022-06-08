<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Category</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="mystyle.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/2a28c847cb.js" crossorigin="anonymous"></script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h2>${namecategory}</h2>

<div class="container-buttons">
    <a href="${contextPath}/eshop?command=search">
        <i class="fa-solid fa-magnifying-glass fa-3x" style="color: black"></i>
    </a>
    <a href="${contextPath}/eshop?command=start_page">
        <i class="fa-solid fa-house fa-3x" style="color: black"></i>
    </a>
    <a href="${contextPath}/eshop?command=redirect-to-profile">
        <i class="fa-solid fa-user fa-3x" style="color: black"></i>
    </a>
    <a href="${contextPath}/eshop?command=redirect-to-shopping-cart">
        <i class="fa-solid fa-cart-shopping fa-3x" style="color: black"></i>
    </a>
</div>

<div class="container-fluid mb-4">
    <c:forEach items="${category}" var="categoryitem">
        <div class="card w-25 m-1" type="categoryitem">
            <div>
                <p>
                    <a class="product-name"
                       href="${contextPath}/eshop?command=product-redirect&product_id=${categoryitem.getId()}">${categoryitem.getName()}</a>
                </p>
                <div class="card-body">
                    <img class="card-img" style="width:45%;height:100%"
                         src="images/${categoryitem.getImageName()}" alt="Product image">
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item"><b>Description:</b> <a>${categoryitem.getDescription()}</a>
                        </li>
                        <li class="list-group-item"><b>Price:</b> <a>${categoryitem.getPrice()}</a></li>
                    </ul>
                </div>

            </div>
        </div>
    </c:forEach>

</div>

</body>
</html>
