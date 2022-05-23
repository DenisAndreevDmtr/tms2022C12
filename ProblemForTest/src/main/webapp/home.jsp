<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Categories</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/2a28c847cb.js" crossorigin="anonymous"></script>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<h2>Popular categories</h2>

<div class="container-fluid mb-4">
    <c:if test="${not empty categories}">
        <div class="row">
            <c:forEach items="${categories}" var="category">
                <div class="card w-25 m-1" type="category">
                    <div class="card-body">
                        <a href="${contextPath}/eshop?command=category-redirect&category_id=${category.getId()}">${category.getName()}</a>
                        <img class="card-img" style="width:150px;height:120px"
                             src="${contextPath}/images/${category.getImageName()}" alt="Card image">

                    </div>
                </div>
                <div class="info-category">
                    <input type="hidden" name="category_id" value="${category.getId()}"/>
                </div>

            </c:forEach>
        </div>
    </c:if>
    <a href="${contextPath}/eshop?command=redirect-to-shopping-cart">
        <i class="fa-solid fa-cart-shopping fa-3x" style="color: black"></i>
    </a>
    <a href="${contextPath}/eshop?command=redirect-to-profile">
        <i class="fa-solid fa-user fa-3x" style="color: black"></i>
    </a>
</div>
</div>
</body>
</html>

