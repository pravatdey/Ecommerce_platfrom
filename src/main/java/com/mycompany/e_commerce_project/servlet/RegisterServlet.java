 
package com.mycompany.e_commerce_project.servlet;

import com.mycompany.e_commerce_project.entites.User;
import com.mycompany.e_commerce_project.helper.FactoryProvider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import org.hibernate.Session;
import org.hibernate.Transaction;

 
public class RegisterServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            try{
                String User_name=request.getParameter("user_name");
                String User_Email=request.getParameter("user_email");
                String User_Password = request.getParameter("user_password");
                String User_Phone=request.getParameter("user_phone");
                String User_Address=request.getParameter("user_address");
              User user=  new User(User_name, User_Email, User_Password, User_Phone, "default.jpg", User_Address,"Normal");
              
                Session hibernateSession=FactoryProvider.getFactory().openSession();
               Transaction tx= hibernateSession.beginTransaction();
              int USer_id=(int) hibernateSession.save(user);
                
                
                
                tx.commit();
                hibernateSession.close();
                
                HttpSession httpsession=request.getSession();
                httpsession.setAttribute("message", "Registration Successful !!");
                response.sendRedirect("register.jsp");
                return;
                
            }catch(Exception e){
                e.printStackTrace();
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
