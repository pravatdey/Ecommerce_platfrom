function add_to_cart(pid, pName, price) {


    let cart = localStorage.getItem("cart");
    if (cart == null) {
        let products = [];
        let product = {productId: pid, prodictName: pName, productQuantity: 1, productPrice: price};
        products.push(product);
        localStorage.setItem("cart", JSON.stringify(products));
        console.log("Product is added for the first time");

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
            console.log("Product Quantity is increase");
        } else {
            let product = {productId: pid, prodictName: pName, productQuantity: 1, productPrice: price};
            pcart.push(product)
            localStorage.setItem("cart", JSON.stringify(pcart));
            console.log("Product is added");

        }
    }

}

