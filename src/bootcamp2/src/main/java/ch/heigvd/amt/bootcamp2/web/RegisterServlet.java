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
 * Handles access to the registration page and user registration
 * 
 * @author Lucie Steiner
 */
public class RegisterServlet extends HttpServlet {

   @EJB
   private UserManager userManager;

   public RegisterServlet() {

   }

   /**
    * Handles access to the registration page
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    *
    */
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      //Only allows access if the user is not connected, otherwise, it is redirected to its profile
      if (request.getSession().getAttribute("user") == null) {
         request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
      } else {
         response.sendRedirect("protected?p=info");
      }
   }

   /**
    * Handles user registration
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      //Checks that all fields are filled
      if (request.getParameter("user").isEmpty() || request.getParameter("pwd").isEmpty() || request.getParameter("pwd_check").isEmpty() || request.getParameter("fname").isEmpty() || request.getParameter("lname").isEmpty() || request.getParameter("email").isEmpty()) {
         request.setAttribute("error", "Please fill all the fields");
         request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
      } else {
         //Check that the passwords match
         if (request.getParameter("pwd").equals(request.getParameter("pwd_check"))) {
            //Registers the user if the username is not already used
            if (userManager.create(new User(request.getParameter("user"), request.getParameter("pwd"), request.getParameter("fname"), request.getParameter("lname"), request.getParameter("email")))) {
               request.getSession().setAttribute("user", request.getParameter("user"));
               request.getSession().setAttribute("fname", request.getParameter("fname"));
               request.getSession().setAttribute("lname", request.getParameter("lname"));
               request.getSession().setAttribute("email", request.getParameter("email"));
               response.sendRedirect("protected?p=info");
            } else {
               request.setAttribute("error", "Username not available");
               request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
            }
         } else {
            request.setAttribute("error", "Passwords don't match");
            request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
         }
      }
   }
}
