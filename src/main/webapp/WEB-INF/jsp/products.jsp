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
                    <h5 class="card-title">${flower.name}</h5>
                    <p class="card-text">Kaina: $${flower.price}</p>
                    <a href="singleProduct.jsp?productId=${flower.id}" class="btn btn-primary stretched-link">Likutis: ${flower.quantity}</a>
                </div>
            </div>
        </c:forEach>
        </div>
    </div>

</div>
</body>
</html>