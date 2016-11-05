/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.heigvd.amt.bootcamp2.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Handles the user's logout
 * 
 * @author Lucie Steiner
 */
public class LogoutServlet extends HttpServlet {

   /**
    * Handles logout by removing all session variables and redirects the user to login page
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      request.getSession().removeAttribute("user");
      request.getSession().removeAttribute("fname");
      request.getSession().removeAttribute("lname");
      request.getSession().removeAttribute("email");
      response.sendRedirect("login");
   }

}
