<%
  User user = (User) session.getAttribute("current-user");
      if (user == null) {
          session.setAttribute("message", "Not Logged in! Login first to access checkout page");
          response.sendRedirect("login.jsp");
          return;
      }else{

      }



%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Check out</title>
        <%@include file="Componets/Commen-css_js.jsp" %>

    </head>
    <body>
       <%@include file="Componets/navbar.jsp" %>
    <div class="container">
    <div class="row mt-5">
    <div class="col-md-6">
    <div class="card">
    <div clas="card-body">
    <h3 class="text-center mb-5">Your seleceted Items</h3>
     <div class="cart-body">
        </div>
        </div>
    </div>
    </div>
    <div class="col-md-6"></div>
    <div class="card">
        <div clas="card-body">
        <h3 class="text-center mb-5">Your details for order</h3>
         <form action="#!">
         <div class="form-group">
             <label for="exampleInputEmail1">Email address</label>
             <input value="<%= user.getUserEmail() %>" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required="">
             <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
           </div>
           <div class="form-group">
               <label for="name">Your name</label>
               <input value="<%= user.getUserName() %>" type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter name" required="">
             </div>
             <div class="form-group">
                            <label for="name">Your Contact</label>
                            <input value="<%= user.getUserPhonr() %>" type="number" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter number" required="">
                          </div>
                 <div class="form-group">
                     <label for="exampleFormControlTextarea1">Your Shipping address</label>
                     <textarea value="<%= user.getUserAddress() %>" required=""  class="form-control" id="exampleFormControlTextarea1" placeholder="Enter your address" rows="3"></textarea>
                   </div>
                   <div class="container text-center">
                   <button clas="btn-btn-outline-success">Order Now</div>
                   <button clas="btn-btn-outline-primary">Continue Shopping</div>

         </form>
            </div>
        </div>
    </div>
        <%@ include file="Componets/commen_model.jsp"%>

    </body>
</html>