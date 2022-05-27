<%@ include file="/WEB-INF/jsp/common/includes.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container">
    <br>
    <h3><i class="fas fa-shopping-cart"></i> My Cart</h3>
    <br>
    <br>
    <ul class="list-group">
        <c:forEach items="${productsInCart}" var="flower">
            <li class="list-group-item d-flex justify-content-between align-items-center">
                <img class="card-img-top cart-item img-thumbnail" src="<c:url value="/images/${flower.imageUrl}"/>" alt="Card image cap">
                Vnt: ${flower.quantity}
                <span class="badge badge-primary badge-pill">14</span>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">${flower.name}</h5>
                        <p class="card-text">Kaina: ${flower.price}€</p>
                    </div>
                </div>
                <form:form method="POST" action="/cart/delete" modelAttribute="deleteItemRequest">
                    <form:input type="hidden" path="id" value="${flower.getId()}" />
                    <input type="submit" value="Delete" />
                </form:form>
            </li>
        </c:forEach>
    </ul>
    <br>
    <h4>Total cost: ${totalCost}€</h4>
    <form:form method="POST" action="/cart/checkout" modelAttribute="cart" varStatus="idx">
        <c:forEach items="${cart.cartItems}" var="item" varStatus="status">
            <form:input type="hidden" path="cartItems[${status.index}].id" />
            <form:input type="hidden" path="cartItems[${status.index}].product" />
            <form:input type="hidden" path="cartItems[${status.index}].quantity" />
        </c:forEach>
        <input type="submit" value="Checkout" />
    </form:form>
</div>