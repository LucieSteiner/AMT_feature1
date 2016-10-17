<%-- 
    Document   : login
    Created on : 4 oct. 2016, 15:54:15
    Author     : Lucie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <link rel="stylesheet" href="assets/css/main.css" />
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>JSP Page</title>
   </head>
   <body>

<!-- Header -->
        <header id="header">
                <div class="inner">
                        <a href="protected" class="logo">AMT</a>
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
         <section id="register">
            <div class="login-card">
               <h1>Register</h1><br>
               <span>${error}</span>
               <form method="post">
                  <input type="text" name="fname" placeholder="Firstname"/>
                  <input type="text" name="lname" placeholder="Lastname"/>
                  <input type="text" name="email" placeholder="E-mail"/>
                  <input type="text" name="user" placeholder="Username"/>
                  <input type="password" name="pwd" placeholder="Password"/>
                  <input type="password" name="pwd_check" placeholder="Repeat password"/><br/>
                  <input type="submit">

               </form>
            </div>
         </section>
<!-- Footer -->
        <footer id="footer">
                <div class="inner">
                        <div class="flex">
                                <div class="copyright">
                                        &copy; Untitled. Design: <a href="https://templated.co">TEMPLATED</a>. Images: <a href="https://unsplash.com">Unsplash</a>.
                                </div>
                                <ul class="icons">
                                        <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
                                        <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
                                        <li><a href="#" class="icon fa-linkedin"><span class="label">linkedIn</span></a></li>
                                        <li><a href="#" class="icon fa-pinterest-p"><span class="label">Pinterest</span></a></li>
                                        <li><a href="#" class="icon fa-vimeo"><span class="label">Vimeo</span></a></li>
                                </ul>
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
