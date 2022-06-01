<%@ include file="common/includes.jspf"%>

<div class="container">
    <c:forEach items="${userOrders}" var="order">
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h3 class="card-title">Status: ${order.status}</h3>
                <p class="card-text">
                    <div>Order ID: ${order.id}</div>
                    <div>
                        Ship to:
                        <div>
                            City: ${order.address.city}
                        </div>
                        <div>
                            Street: ${order.address.street}
                        </div>
                        <div>
                            House number: ${order.address.houseNumber}
                        </div>
                    </div>
                    <div>
                        Items to be delivered:
                            <ul>
                            <c:forEach items="${order.orderItems}" var="orderItem">
                                <li>Item: ${orderItem.item.product.name}</li>
                                <li>Quantity: ${orderItem.item.quantity}</li>
                            </c:forEach>
                            </ul>
                    </div>
                </p>
            </div>
        </div>
    </c:forEach>
</div>