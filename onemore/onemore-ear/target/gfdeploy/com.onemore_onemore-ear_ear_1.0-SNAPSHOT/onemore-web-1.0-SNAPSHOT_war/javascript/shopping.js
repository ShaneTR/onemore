/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
$(function() {
    ajaxifyProducts();
});

function ajaxifyProducts() {
    var baseUrl = "/" + window.location.pathname.split( '/' )[1];
    $(".product").click(function(e){
        var product_id = $(this).attr("id").split("-")[1];
        product = $(this);
        // Make an AJAX call to the server which will add the product to the user's shopping cart
        $.ajax({
            type: "POST",
            url: baseUrl + "/ajax/add_to_cart",
            data: product_id
        })
        .done(function(){
            a = $('#price-1').text();;
            var current_total = parseFloat($("#checkout_total").text(), 10);
            var product_price = parseFloat($('#price-' + product_id).text(), 10);
            var new_total = current_total + product_price;
            $("#checkout_total").text(new_total.toFixed(2));
        })
        .fail(function() {
            alert('fail');
        });
        // Don't follow the link
        e.preventDefault();
    });
}