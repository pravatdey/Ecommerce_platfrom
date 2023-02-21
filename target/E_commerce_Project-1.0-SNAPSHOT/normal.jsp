<%@page import="com.mycompany.e_commerce_project.entites.User"%>
<%
     User user = (User) session.getAttribute("current-user");
    if (user == null) {
        session.setAttribute("message", "Not Logged in! Login first");
        response.sendRedirect("login.jsp");
        return;
    } else {
        if (user.getUser_Type().equals("admin")) {
            session.setAttribute("message", "You are not normal user!,Do not access this page");
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>This is normal user</h1>
    </body>
</html>
