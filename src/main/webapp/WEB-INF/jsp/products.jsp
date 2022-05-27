<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ include file="common/footer.jspf"%>

<html>
<body>
<div class="container">
    <c:forEach items="${flowers}" var="flower">
        <div class="card" style="width: 18rem;">
            <img class="card-img-top" src="<c:url value="/images/${flower.imageUrl}"/>" alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title">Pavadinimas: ${flower.name}</h5>
                <p class="card-text">Kaina: $${flower.price}</p>
                <a href="#" class="btn btn-primary">Likutis: ${flower.quantity}</a>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>