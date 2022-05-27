<%@ include file="common/includes.jspf"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>



<title>Single Flower</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" href="/css/single.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

<div class="container content profile">
    <div class="row">
        <!-- left section -->
        <div class="left-section pull-left">

        </div>

        <div class="col-md-12 mid-col">
            <div class="small-container single-page">
                <table>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th>Subtotal</th>
                    </tr>
                    <tr>
                        <td>
                            <div class="single-info">
                                <img src="/images/img.png" width="200"
                                     height="200"/>
                                <div>
                                    <p>Gele Name</p>
                                    <small>Price: $50.00</small>
                                </div>
                            </div>
                        </td>
                        </td>
                        <td><input type="number" value="1"></td>
                        <td>$50.00</td>
                    </tr>
                </table>
                <form:form method="POST" action="/cart/add" modelAttribute="product">
                    <form:input type="hidden" path="id" value="${product.id}" />
                    <input type="submit" value="Add to Cart" />
                </form:form>
            </div>
        </div>
        <!-- right section -->
        <div class="left-section pull-right">

        </div>

    </div>
</div>




<body>
<h2 align="center"> Single product here ${product.name}!</h2>
</body>
</html>