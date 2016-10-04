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
                        <a href="index.html" class="logo">AMT</a>
                        <nav id="nav">
                                <a href="index.html">Home</a>
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
            <form method="post">
               <label>Username</label>
               <input type="text" name="user"/>
               <label>Password</label>
               <input type="password" name="pwd"/>
               <input type="submit">
               
            </form>
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
