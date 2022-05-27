<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ include file="common/footer.jspf"%>

<html>
<head>
    <title>View Books</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link href="<c:url value="/css/main.css"/>" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</head>
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