package ch.heigvd.amt.bootcamp2.web;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Filters access to the protected part of the website, to allow only authenticated users
 * 
 * @author Lucie Steiner
 */
public class ProtectedFilter implements Filter {

   private static final boolean debug = true;

   private FilterConfig filterConfig = null;

   public ProtectedFilter() {
   }


   /**
    * Checks that the username session variable is set before allowing access, redirects to login otherwise
    * 
    * @param request The servlet request we are processing
    * @param response The servlet response we are creating
    * @param chain The filter chain we are processing
    *
    * @exception IOException if an input/output error occurs
    * @exception ServletException if a servlet error occurs
    */
   @Override
   public void doFilter(ServletRequest request, ServletResponse response,
           FilterChain chain)
           throws IOException, ServletException {
      HttpServletRequest httpRequest = (HttpServletRequest) request;
      HttpServletResponse httpResponse = (HttpServletResponse) response;

      if (httpRequest.getSession().getAttribute("user") == null) {
         httpResponse.sendRedirect("login");
      }

      Throwable problem = null;
      try {
         chain.doFilter(request, response);
      } catch (Throwable t) {
         problem = t;
         t.printStackTrace();
      }

      if (problem != null) {
         if (problem instanceof ServletException) {
            throw (ServletException) problem;
         }
         if (problem instanceof IOException) {
            throw (IOException) problem;
         }
         sendProcessingError(problem, response);
      }
   }

   /**
    * Return the filter configuration object for this filter.
    */
   public FilterConfig getFilterConfig() {
      return (this.filterConfig);
   }

   /**
    * Set the filter configuration object for this filter.
    *
    * @param filterConfig The filter configuration object
    */
   public void setFilterConfig(FilterConfig filterConfig) {
      this.filterConfig = filterConfig;
   }

   /**
    * Destroy method for this filter
    */
   @Override
   public void destroy() {
   }

   /**
    * Init method for this filter
    *
    * @param filterConfig
    */
   @Override
   public void init(FilterConfig filterConfig) {
      this.filterConfig = filterConfig;
      if (filterConfig != null) {
         if (debug) {
            log("ProtectedFilter:Initializing filter");
         }
      }
   }

   /**
    * Return a String representation of this object.
    */
   @Override
   public String toString() {
      if (filterConfig == null) {
         return ("ProtectedFilter()");
      }
      StringBuffer sb = new StringBuffer("ProtectedFilter(");
      sb.append(filterConfig);
      sb.append(")");
      return (sb.toString());
   }

   private void sendProcessingError(Throwable t, ServletResponse response) {
      String stackTrace = getStackTrace(t);

      if (stackTrace != null && !stackTrace.equals("")) {
         try {
            response.setContentType("text/html");
            PrintStream ps = new PrintStream(response.getOutputStream());
            PrintWriter pw = new PrintWriter(ps);
            pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

            // PENDING! Localize this for next official release
            pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");
            pw.print(stackTrace);
            pw.print("</pre></body>\n</html>"); //NOI18N
            pw.close();
            ps.close();
            response.getOutputStream().close();
         } catch (Exception ex) {
         }
      } else {
         try {
            PrintStream ps = new PrintStream(response.getOutputStream());
            t.printStackTrace(ps);
            ps.close();
            response.getOutputStream().close();
         } catch (Exception ex) {
         }
      }
   }

   public static String getStackTrace(Throwable t) {
      String stackTrace = null;
      try {
         StringWriter sw = new StringWriter();
         PrintWriter pw = new PrintWriter(sw);
         t.printStackTrace(pw);
         pw.close();
         sw.close();
         stackTrace = sw.getBuffer().toString();
      } catch (Exception ex) {
      }
      return stackTrace;
   }

   public void log(String msg) {
      filterConfig.getServletContext().log(msg);
   }

}
