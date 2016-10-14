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
public class RegisterServlet extends HttpServlet {
  @EJB
  private UserManager userManager;
  
  public RegisterServlet(){
   
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
         request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
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
      if(request.getParameter("pwd").equals(request.getParameter("pwd_check"))){
         if(userManager.register(new User(request.getParameter("user"), request.getParameter("pwd"), request.getParameter("fname"), request.getParameter("lname"), request.getParameter("email")))){
            request.getSession().setAttribute("user", request.getParameter("user"));
            request.getSession().setAttribute("fname", request.getParameter("fname"));
            request.getSession().setAttribute("lname", request.getParameter("lname"));
            request.getSession().setAttribute("email", request.getParameter("email"));
            response.sendRedirect("protected");
         }else{
            request.setAttribute("error", "Username not available");
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
         }
      }
      else{
         request.setAttribute("error", "Passwords don't match");
         request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
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
   }// </editor-fold>

}
