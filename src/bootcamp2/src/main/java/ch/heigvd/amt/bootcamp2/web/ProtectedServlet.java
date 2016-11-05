package ch.heigvd.amt.bootcamp2.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles access to protected pages
 * 
 * @author Lucie Steiner
 */
public class ProtectedServlet extends HttpServlet {

   /**
    * Handles redirection to the right page in the protected part of the website
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      
      //The name of the page to access is stored in a parameter
      String path = (String) request.getParameter("p");
      if (path == null) {
         path = "";
      }
      switch (path) {
         case "info":
            request.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(request, response);
            break;
         case "listUserAccounts":
            request.getRequestDispatcher("/WEB-INF/pages/listUserAccounts.html").forward(request, response);
            break;
         default:
            request.getRequestDispatcher("/WEB-INF/pages/profile.jsp").forward(request, response);
      }

   }

}
