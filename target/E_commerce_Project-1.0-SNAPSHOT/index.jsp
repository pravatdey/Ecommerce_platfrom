  

<%@page import="com.mycompany.e_commerce_project.helper.Halper"%>
<%@page import="com.mycompany.e_commerce_project.entites.Category"%>
<%@page import="com.mycompany.e_commerce_project.dao.CategoryDao"%>
<%@page import="com.mycompany.e_commerce_project.entites.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.e_commerce_project.dao.ProductDao"%>
<%@page import="com.mycompany.e_commerce_project.helper.FactoryProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ecommerce-HomePage</title>

        <%@include file="Componets/Commen-css_js.jsp" %>

    </head>
    <body>

        <%@include file="Componets/navbar.jsp" %>
        <div class="container-fluid">
            <div class="row mt-3 mx-2">

                <%                String cat = request.getParameter("category");

                    ProductDao pdao = new ProductDao(FactoryProvider.getFactory());
                    List<Product> list = null;
                     if (cat==null||cat.trim().equals("all")) {
                        list = pdao.getAllProducts();
                    } else {
                        int cid = Integer.parseInt(cat.trim());
                        list = pdao.getAllProductsById(cid);
                    }

                    CategoryDao cdao = new CategoryDao(FactoryProvider.getFactory());
                    List<Category> clist = cdao.getCategories();
                %>
                <!--show category-->
                <div class="col-md-2">
                    <div class="list-group mt-4">
                        <a href="index.jsp?category=all" class="list-group-item list-group-item-action active">
                            All Products
                        </a>

                        <%
                            for (Category c : clist) {
                        %>

                        <a href="index.jsp?category=<%= c.getCategoryId()%>" class="list-group-item list-group-item-action"><%= c.getCategoryTitle()%></a>
                        <%
                            }

                        %>
                    </div>
                </div>
                <!--show products-->
                <div class="col-md-10">
                    <div class="row mt-4">
                        <div class="col-md-12">
                            <div class="card-columns">
                                <!--product traversing-->
                                <%                                for (Product p : list) {
                                %>
                                <div class="card">
                                    <div class="container text-center">
                                        <img src="Image/products/<%= p.getpPhoto()%>" style="max-height: 200px;max-width:100%; " class="card-img-top m-2" alt="...">

                                    </div>
                                    <div class="card-body">
                                        <h5 class="card-title"><%= p.getpName()%></h5>
                                        <p class="card-text">
                                            <%= Halper.get10words(p.getpDescription())%>
                                        </p>
                                    </div>
                                    <div class="card-footer">
                                        <button class="btn btn-outline-success ">&#x20B9;<%= p.getPriceAfterDiscount()%>/-<br> <span class="text-primary discount-label">&#x20B9; <%= p.getpPrice()%> <%= p.getpDiscount()%>% off</span></button><br><br>
                                        <button class="btn" onclick="add_to_cart(<%= p.getPid()%>, '<%= p.getpName() %>)',<%= p.getPriceAfterDiscount() %>">Add to Cart</button>
                                        <button class="btn btn-primary">Buy now</button>
                                    </div>
                                </div>
                                <%}%>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
