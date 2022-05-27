<%@ include file="/WEB-INF/jsp/common/includes.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container">
    <h3>My Cart</h3>
    <ul class="list-group">
        <c:forEach items="${cartItems}" var="flower">
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <img class="card-img-top cart-item img-thumbnail" src="<c:url value="/images/${flower.imageUrl}"/>" alt="Card image cap">
                ${flower.name} - ${flower.price} - ${flower.quantity}
                <span class="badge badge-primary badge-pill">14</span>
                <form:form method="POST" action="/cart/delete" modelAttribute="deleteItemRequest">
                    <form:input type="hidden" path="id" value="${flower.getId()}" />
                    <input type="submit" value="Delete" />
                </form:form>
            </li>
        </c:forEach>
    </ul>
    <h4>Total cost: ${totalCost}</h4>
</div>