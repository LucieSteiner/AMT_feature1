<%-- 
    Document   : login
    Author     : Lucie Steiner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <link rel="stylesheet" href="assets/css/main.css" />
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Log in</title>
   </head>
   <body>

      <!-- Header -->
      <header id="header">
         <div class="inner">
            <span class="logo">
               <a href="login" class="button">Log in</a>
               <a href="register" class="button">Register</a>
            </span>
            <nav id="nav">
               <a href="protected">Home</a>
            </nav>
            <a href="#navPanel" class="navPanelToggle"><span class="fa fa-bars"></span></a>
         </div>
      </header>

      <!-- Banner -->
      <section id="banner">
         <h1>Welcome to AMT</h1>
         <p>An exclusive HEIG-VD course by Olivier Liechti</p>
      </section>
      
      <!-- Content -->
      <section id="login">
         <div class="login-card">
            <h1>Log-in</h1><br>
            <span class="error">${error}</span>
            <form method="post">
               <input type="text" name="user" placeholder="Username">
               <input type="password" name="pwd" placeholder="Password">
               <input type="submit" name="login" class="login login-submit" value="login">
            </form>

            <div class="login-help">
               <a href="register">No account yet? Register here</a>
            </div>
         </div>
      </section>
      
      <!-- Footer -->
      <footer id="footer">
         <div class="inner">
            <div class="flex">
               <div class="copyright">
                  &copy; Untitled. Design: <a href="https://templated.co">TEMPLATED</a>. Images: <a href="https://unsplash.com">Unsplash</a>.
               </div>
            </div>
         </div>
      </footer>

      <!-- Scripts -->
      <script src="assets/js/jquery.min.js"></script>
      <script src="assets/js/skel.min.js"></script>
      <script src="assets/js/util.js"></script>
      <script src="assets/js/main.js"></script>

   </body>
</html>
