<%@page import="com.mycompany.e_commerce_project.entites.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.e_commerce_project.dao.CategoryDao"%>
<%@page import="com.mycompany.e_commerce_project.helper.FactoryProvider"%>
<%@page import="com.mycompany.e_commerce_project.entites.User"%>
<%

    User user = (User) session.getAttribute("current-user");
    if (user == null) {
        session.setAttribute("message", "Not Logged in! Login first");
        response.sendRedirect("login.jsp");
        return;
    } else {
        if (user.getUser_Type().equals("normal")) {
            session.setAttribute("message", "You are not admin!,Do not access this page");
            response.sendRedirect("login.jsp");
            return;
        }

    }


%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Admin Panel</title>
        <%@include file="Componets/Commen-css_js.jsp" %>

    </head>
    <body>
        <%@include file="Componets/navbar.jsp" %>

        <div class="container admin">
            <div class="container-fluid">

                <%@include file="Componets/message.jsp"  %>
            </div>
            <div class="row mt-4">
                <!--first col-->
                <div class="col-md-4">

                    <div class="card ">
                        <div class="card-body text-center">
                            <div class="container">
                                <img style="max-width: 125px" class="img-fluid rounded-circle" src="Image/team.png" alt="User_icons"/>
                            </div>
                            <h1 class="text-uppercase text-muted">User</h1>
                        </div>
                    </div>
                </div>
                <!--second cal-->
                <div class="col-md-4">
                    <div class="card">
                        <div class="card-body  text-center">
                            <div class="container">
                                <img style="max-width: 125px" class="img-fluid rounded-circle" src="Image/list.png" alt="User_icons"/>
                            </div>
                            <h1 class="text-uppercase text-muted">Categories</h1>
                        </div>
                    </div>
                </div>
                <!--third col-->
                <div class="col-md-4">
                    <div class="card ">
                        <div class="card-body text-center">
                            <div class="container">
                                <img style="max-width: 125px" class="img-fluid rounded-circle" src="Image/product.png" alt="User_icons"/>
                            </div>
                            <h1 class="text-uppercase text-muted">Products</h1>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6">
                    <div class="card " data-toggle="modal" data-target="#add-category-modal">
                        <div class="card-body text-center">
                            <div class="container">
                                <img style="max-width: 125px" class="img-fluid rounded-circle" src="Image/arithmetic.png" alt="User_icons"/>
                            </div>
                            <p class="mt-2"> Add to new Category</p>
                            <h1 class="text-uppercase text-muted">Add Category</h1>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card" data-toggle="modal" data-target="#add-product-modal">
                        <div class="card-body text-center">
                            <div class="container">
                                <img style="max-width: 125px" class="img-fluid rounded-circle" src="Image/plus.png" alt="User_icons"/>
                            </div>
                            <p class="mt-2">Add new Product</p>
                            <h1 class="text-uppercase text-muted">Add Product</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--add category model-->


        <!-- Modal -->
        <div class="modal fade" id="add-category-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header custom-bg text-white">
                        <h5 class="modal-title" id="exampleModalLabel">Category details</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="ProductOperationServlet" method="post">
                            <input type="hidden" name="operation" value="addcategory">
                            <div class="form-group">
                                <input type="text" class="form-control" name="catTitle" placeholder="Enter category title" required/>
                            </div>

                            <div class="form-group">
                                <textarea name="catDescription" style="height: 300px;" class="form-control" placeholder="Enter category discription" required ></textarea>
                            </div>
                            <div class="container text-center">
                                <button class="btn btn-outline-success">Add Category</button>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>

                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
        <!--Product modal-->


        <div class="modal fade" id="add-product-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Product Details</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form action="AddProductServlet" method="post" enctype="multipart/form-data">
                            <input type="hidden" name="operation1" value="addproduct"/>
                            <!--Product -->
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Enter product name" name="pName" required /> 
                            </div>
                            <div class="form-group">
                                 <textarea name="pDescription" style="height: 200px;" class="form-control" placeholder="Enter product discription" required ></textarea>
                            </div>
                            <div class="form-group">
                                <input type="number" class="form-control" placeholder="Enter price of the product" name="pPrice" required /> 
                            </div>
                            <div class="form-group">
                                <input type="number" class="form-control" placeholder="Enter product discount" name="pDiscount" required /> 
                            </div>
                            <div class="form-group">
                                <input type="number" class="form-control" placeholder="Enter product Quantity" name="pQuantity" required /> 
                            </div>
                            
                            <%
                               CategoryDao cdao= new CategoryDao(FactoryProvider.getFactory());
                               List<Category> list=cdao.getCategories();
                             %>

                            <!--product category-->
                            <div class="form-group" >
                                <select name="categoryId" id="" class="form-control">
                                    <%
                                        for(Category c:list){
                                        %>
                                    <option value="<%= c.getCategoryId()%>"> <%= c.getCategoryTitle()%></option>
                                     <%}%>                   
                                </select>
                            </div>   

                            <div class="form-group">
                                <label  for="pPic">Select Picture of product</label>
                                <br>
                                <input type="file"  id="pPic" name="pPic"/>
                            </div>


                            <div class="container text-center">
                                <button class="btn btn-outline-success">Add Category</button>
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            </div>      







                        </form>
                    </div>
                     
                </div>
            </div>
        </div>
    </body>
</html>
