 
package com.mycompany.e_commerce_project.servlet;

 
import com.mycompany.e_commerce_project.dao.CategoryDao;
import com.mycompany.e_commerce_project.dao.ProductDao;
import com.mycompany.e_commerce_project.entites.Category;
 
import com.mycompany.e_commerce_project.entites.Product;
import com.mycompany.e_commerce_project.helper.FactoryProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
 
@MultipartConfig
public class AddProductServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
             String ap=request.getParameter("operation1");
             if (ap.trim().equals("addproduct")) {
                String pName = request.getParameter("pName");
                String   pDesc = request.getParameter("pDescription");
                int pPrice = Integer.parseInt(request.getParameter("pPrice"));
                int pDiscount= Integer.parseInt(request.getParameter("pDiscount"));
                int  pQuantity = Integer.parseInt(request.getParameter("pQuantity"));
                int categoryId = Integer.parseInt(request.getParameter("categoryId"));
                Part part = request.getPart("pPic");

               
               Product p= new Product();
                p.setpName(pName);
                p.setpDescription(pDesc);
                p.setpPrice(pPrice); 
                p.setpDiscount(pDiscount);
                p.setpQuantity(pQuantity);
                p.setpPhoto(part.getSubmittedFileName());
                
                CategoryDao cdao=new CategoryDao(FactoryProvider.getFactory());
                Category cat=cdao.getCategoryById(categoryId);
                
                p.setCategory(cat);
           
              
                

                ProductDao pdao = new ProductDao(FactoryProvider.getFactory());
                 pdao.saveProduct(p);
                
                  //Photo Upload
//                  find out path to upload photo
                    
//                  String path =  request.getContextPath();
                   String path=request.getRealPath("Image")+File.separator+"products"+File.separator+part.getSubmittedFileName();
                   System.out.println(path);
                
                   FileOutputStream fos=new FileOutputStream(path);
                   InputStream is =  (part.getInputStream());
                 //reading data
                 
                 
                 byte [] data= new byte[is.available()];
                 is.read(data);
                 fos.write(data);
                 fos.close();
                 
                 
                HttpSession httpsession= request.getSession();
                httpsession.setAttribute("message", "Product is add successful!");
                response.sendRedirect("admin.jsp");
                return;
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
