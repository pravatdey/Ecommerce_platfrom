//add item
function add_to_cart(pid, pName, price) {


    let cart = localStorage.getItem("cart");
    if (cart == null) {
        let products = [];
        let product = {productId: pid, prodictName: pName, productQuantity: 1, productPrice: price};
        products.push(product);
        localStorage.setItem("cart", JSON.stringify(products));
//        console.log("Product is added for the first time");
        showToast("Item is added to cart");

    } else {
        let pcart = JSON.parse(cart);
        let oldproduct = pcart.find((item) => item.productId == pid);
        if (oldproduct) {
            oldproduct.productQuantity = oldproduct.productQuantity + 1;
            pcart.map((item) => {
                if (item.productId == oldproduct.productId) {
                    item.productQuantity - oldproduct.productQuantity;
                }
            })
            localStorage.setItem("cart", JSON.stringify(pcart));
//            console.log("Product Quantity is increase");
              showToast( oldproduct.prodictName+" Quantity is increased ,Quantity="+  +oldproduct.productQuantity);
        } else {
            let product = {productId: pid, prodictName: pName, productQuantity: 1, productPrice: price};
            pcart.push(product)
            localStorage.setItem("cart", JSON.stringify(pcart));
//            console.log("Product is added");
             showToast("Product is added to cart");

        }
    }
    updateCart();

}

//update cart

function updateCart(){
let cartString=localStorage.getItem("Cart");
let cart=JSON.parse(cartString);
if(cart==null ||cart.length==0){
console.log("Cart is empty!!");
$(".cart-items").html("( 0 )");
$(".cart-body").html("<h3>Cart does not have any items</h1>");
$("/.checkout-btn").attr('disabled',true);
}else{
 console.log(cart);
$(".cart-items").html(`(${cart.length})`);
let tale=`
    <table class='table'>
    <head class='thread-length'>
    <tr>
    <th>Item Name</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Total Price</th>
    <th>Action</th>
    </tr>
    </head>`;
let totalPrice=0;
cart.map((item)=>{
table+=`
<tr>
<td>${item.prodictName}</td>
<td>${item.productPrice}</td>
<td>${item.productQuantity}</td>
<td>${item.productQuantity*item.productPrice}</td>
<td><button onclick='deleteItemFromCart(${item.productId)' class='btn btn-danger btn-sm'>Remove</button></td>
</tr>`
totalPrice+=item.productPrice*item.productQuantity;
})
 table=table+`
 <tr><td colspan='5' class='text-right font-wight-bold'>Total Price:${totalPrice}</td></tr>
 </table>`
$(".cart-body").html(table);
$("/.checkout-btn").attr('disabled',false);
}
}
//delete item
function deleteItemFromCart(pid){
let cart=JSON.parse(localStorage.getItem('cart'));
let newcart=cart.filter((item)=>item.productId!=pid)
localStorage.setItem('cart',JSON.stringify(newcart))
updateCart();
 showToast("Item is removed from cart");

}
$(document).ready(function(){

updateCart()

})


function showToast(content){
$("#toast").addClass("display");
$("#toast").html(content);
setTimeout{()=>{
$("#toast").removeClass("dispaly");
},2000);
}
function goToCheckout{
window.location="checkout.jsp"

}
