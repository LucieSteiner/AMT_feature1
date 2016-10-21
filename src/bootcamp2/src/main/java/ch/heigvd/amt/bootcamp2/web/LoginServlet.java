package ch.heigvd.amt.bootcamp2.web;

import ch.heigvd.amt.bootcamp2.model.User;
import ch.heigvd.amt.bootcamp2.services.UserManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucie
 */
public class LoginServlet extends HttpServlet {

   
   @EJB
   UserManager userManager;
   

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
      if(request.getSession().getAttribute("user") == null){
         request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
      }
      else{
         response.sendRedirect("protected?p=info");
      }
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
      
         if(userManager.checkLogin(request.getParameter("user"), request.getParameter("pwd"))){
            User user = userManager.loadUser(request.getParameter("user"));
            request.getSession().setAttribute("user", user.getUsername());        
            request.getSession().setAttribute("fname", user.getFirstName());
            request.getSession().setAttribute("lname", user.getLastName());
            request.getSession().setAttribute("email", user.getEmail());
            response.sendRedirect("protected?p=info");
         }else{
            request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
         }
      
   }

   /**
    * Returns a short description of the servlet.
    *
    * @return a String containing servlet description
    */
   @Override
   public String getServletInfo() {
      return "Short description";
   }

}
