<%@ include file="common/includes.jspf"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
    <h2>Your order:</h2>
    <c:forEach items="${cart.cartItems}" var="orderItem">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h3 class="card-title">${orderItem.product.name}</h3>
                <p class="card-text">Price: ${orderItem.product.price} Eur.</p>
            </div>
        </div>
    </c:forEach>
    <h4>Enter shipping details</h4>
    <form:form method="POST" action="/checkout/complete" modelAttribute="userOrder">
        <label for="city">City</label><br />
        <form:input type="text" path="address.city" name="City" /><br />
        <label for="street">Street</label><br />
        <form:input type="text" path="address.street" name="Street"/><br />
        <label for="houseNumber">House Number</label><br />
        <form:input type="number" path="address.houseNumber" name="House number" /><br />
        <c:forEach items="${cart.cartItems}" var="item" varStatus="status">
            <form:input type="hidden" path="orderItems[${status.index}].item" value="${item.id}" />
        </c:forEach>
        <input type="submit" value="Complete" />
    </form:form>
</div>
