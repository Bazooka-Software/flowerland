<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ include file="common/footer.jspf"%>

<html>
<body>
<br>
<div class="container">
<h2 align="center"> Our flowers, all packed with love!</h2>
<p><i> The flower journey starts by planting the seed, then we carefully put them to greenhouses, and wait for the magic - flowers to start bloom! Once that happens we are happy to present them to you - beautiful, healthy, long-lasting!</i></p>
</div>
<br>
<div class="container">
    <div class="row justify-content-md-center">
        <c:forEach items="${flowers}" var="flower">
            <div class="card" style="width: 18rem;">
                <img class="card-img-top" src="<c:url value="/images/${flower.imageUrl}"/>" alt="Card image cap">
                <div class="card-body">
                    <h3 class="card-title">${flower.name}</h3>
                    <p class="card-text">Price: ${flower.price}€</p>
                    <a href="singleProduct?productId=${flower.id}" class="btn btn-primary stretched-link">Likutis: ${flower.quantity}</a>
                </div>
            </div>
        </c:forEach>
        </div>
    </div>

</div>
<br>
<br>
<footer class="footer-in">

    <div class="footer-right">

        <a href="https://www.facebook.com/"><i class="fa fa-facebook"></i></a>
        <a href="https://twitter.com/?lang=en"><i class="fa fa-twitter"></i></a>
        <a href="https://lt.linkedin.com/"><i class="fa fa-linkedin"></i></a>
        <a href="https://github.com/Bazooka-Software/flowerland"><i class="fa fa-github"></i></a>

    </div>

    <div class="footer-left">

        <p class="footer-links">
            <a class="link-1" href="/index">Home</a>
        </p>

        <p>Bazooka software &copy; 2022</p>
    </div>

</footer>
</body>
</html>