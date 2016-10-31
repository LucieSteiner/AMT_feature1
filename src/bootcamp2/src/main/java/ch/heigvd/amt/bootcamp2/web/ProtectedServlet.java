package ch.heigvd.amt.bootcamp2.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucie
 */
public class ProtectedServlet extends HttpServlet {

   

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
      String path = (String)request.getParameter("p");
      String page;
      if(path == null){
         path = "";
      }
      switch(path){
         case "info": 
            request.getRequestDispatcher("/WEB-INF/pages/protected.jsp").forward(request, response);
            break;
         case "listUserAccounts":
            request.getRequestDispatcher("/WEB-INF/pages/listUserAccounts.html").forward(request, response);
            break;
         default:
            request.getRequestDispatcher("/WEB-INF/pages/protected.jsp").forward(request, response);
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
