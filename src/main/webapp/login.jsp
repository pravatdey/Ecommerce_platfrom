 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Login</title>
        <%@include file="Componets/Commen-css_js.jsp" %>
       
    </head>
    <body>
        <%@include file="Componets/navbar.jsp" %>

        <div class="container">
            <div class="row">
                <div class="col-md-5 offset-md-4">
                    <div class="card mt-3">
                        <div class="card-header custom-bg text-white">
                            <h3>Login</h3>
                        </div>
                        <div class="card-body">
                            <%@include  file="Componets/message.jsp" %>

                            <form action="LoginServlet" method="POST">
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required="">
                                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">Password</label>
                                    <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required="">
                                </div>
                                <div class="container text-center"> 
                                    <button type="submit" class="btn btn-primary custom-bg mb-2 border-0">Submit</button>
                                    <button  type="reset" class="btn btn-outline-waring custom-bg mb-2 text-white border-0" >Reset</button>

                                </div>
                                <a href="register.jsp" class="text-center d-block mb-2"><h6>Create an account</h6></a>

                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>




    </body>
</html>
