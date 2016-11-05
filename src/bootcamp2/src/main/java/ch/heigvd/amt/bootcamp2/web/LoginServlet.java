package ch.heigvd.amt.bootcamp2.web;

import ch.heigvd.amt.bootcamp2.model.User;
import ch.heigvd.amt.bootcamp2.services.UserManager;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles access to the login page and login attempts
 * 
 * @author Lucie Steiner
 */
public class LoginServlet extends HttpServlet {

   @EJB
   UserManager userManager;

   /**
    * Handles access to the login page
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      
      //Only allows access if the user is not connected, otherwise, it is redirected to its profile
      if (request.getSession().getAttribute("user") == null) {
         request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
      } else {
         response.sendRedirect("protected?p=info");
      }
   }

   /**
    * Handles login attempts
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      
      //Searches for the user in the database
      User user = userManager.findOne(request.getParameter("user"));
      
      //Checks that the user exists and that the password is right
      if (user != null && user.getPassword().equals(request.getParameter("pwd"))) {
         
         //Sets all session variables and redirects the user to its profile
         request.getSession().setAttribute("user", user.getUsername());
         request.getSession().setAttribute("fname", user.getFirstName());
         request.getSession().setAttribute("lname", user.getLastName());
         request.getSession().setAttribute("email", user.getEmail());
         response.sendRedirect("protected?p=info");
      } else {
         
         //Sends an error and reloads the login page
         request.setAttribute("error", "Username or password is wrong");
         request.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(request, response);
      }

   }

}
