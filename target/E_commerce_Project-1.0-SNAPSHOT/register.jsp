 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New User</title>

        <%@include file="Componets/Commen-css_js.jsp" %>

    </head>
    <body>

        <%@include file="Componets/navbar.jsp" %>
        <div class="container-fluid">
            <div class="row mt-0">
                <div class="col-md-5 offset-md-4">
                    <div class="card">
                           
                        <%@include  file="Componets/message.jsp" %>
                        <div class="card-body  ">


                            <h3 class="text-center my-0">Sign-Up</h3>
                            <form action="RegisterServlet" method="post">
                                <div class="form-group">
                                    <label for="name">User Name</label>
                                    <input name="user_name" type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder=" Enter here" required>
                                </div>
                                <div class="form-group">
                                    <label for="email">User Email</label>
                                    <input name="user_email" type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder=" Enter here" required>
                                </div>
                                <div class="form-group">
                                    <label for="password">User Password</label>
                                    <input name="user_password" type="password" class="form-control" id="password" aria-describedby="emailHelp" placeholder=" Enter here" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
                                </div>

                                <div class="form-group">
                                    <label for="phone">User Phone</label>
                                    <input name="user_phone" type="number" class="form-control" id="phone" aria-describedby="emailHelp" pattern="[0-9]{4}-[0-9]{6}" placeholder=" Enter here" required>
                                </div>
                                <div class="form-group">
                                    <label for="phone">User Address</label>
                                    <textarea name="user_address" style="height: 70px;" class="form-control" placeholder="Enter Your address" required ></textarea>
                                </div>
                                <div class="container">
                                    <button class="btn btn-outline-success">Register</button>
                                    <button  type="reset" class="btn btn-outline-waring" >Reset</button>

                                </div>
                                <div>                
                                </div>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
