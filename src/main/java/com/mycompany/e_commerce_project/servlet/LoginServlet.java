 
package com.mycompany.e_commerce_project.servlet;

import com.mycompany.e_commerce_project.dao.UserDao;
import com.mycompany.e_commerce_project.entites.User;
import com.mycompany.e_commerce_project.helper.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
public class LoginServlet extends HttpServlet {
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
              String email = request.getParameter("email");
            String password = request.getParameter("password");

            //Authenticating
            UserDao userDao = new UserDao(FactoryProvider.getFactory());
            User user = userDao.getUserbyEmailandPassword(email, password);
            HttpSession httpsession = request.getSession();

            if (user == null) {
                httpsession.setAttribute("message", "Invalid Details! Try Again");
                response.sendRedirect("login.jsp");
               // return;
            } else {
                //login
                 //out.println("<h1>Welcome" +user.getUser_name()+ "</h1>");
                
                 httpsession.setAttribute("current-user", user);
                 
                 if(user.getUser_Type().equals("admin")){
                     response.sendRedirect("admin.jsp");
                 }else{
                     response.sendRedirect("normal.jsp");
                 } 
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
