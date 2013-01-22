<%-- 
    Document   : shop
    Created on : 22-Jan-2013, 08:59:06
    Author     : Brian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shop</title>
        <link rel="stylesheet" type="text/css" href="css/shopping.css">
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/javascript/shopping.js"></script>
    </head>
    <body>
        <div id="content">
            <div id="left">
                <form action="${pageContext.request.contextPath}/shopping" method="POST">
                    <h3>Foreign piss</h3>
                    <image src="image/product/beer/tyskie.jpeg"/>
                    <div><b>Price: </b>€<span id="price-1">2.99</div>
                    <input type ="submit" value="Add to cart" name="1" class="product" id="pid-1"/>
                </form>
                <form action="${pageContext.request.contextPath}/shopping" method="POST">
                    <h3>Whiskey</h3>
                    <image src="image/product/whiskey/whiskey.jpg"/>
                    <div><b>Price: </b>€<span id="price-2">12.99</div>
                    <input type ="submit" value="Add to cart" name="2" class="product" id="pid-2"/>
                </form>                    
            </div>
            <div id="right">
                <form action="${pageContext.request.contextPath}/checkout" method="POST">
                    <h3>Shopping Cart</h3>
                    <div><b>Total: </b>€<span id="checkout_total">0.00</span></div>
                    <input type ="submit" value="Edit cart" id="cart-edit"/>
                    <input type ="submit" value="Checkout" id="cart-checkout"/>
                </form>
            </div>
        </div>                    
    </body>
</html>
