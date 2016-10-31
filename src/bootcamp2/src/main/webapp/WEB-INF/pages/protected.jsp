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
                      <span class="logo">
                           <a href="logout" class="button">Log out</a>
                      </span>
                        <nav id="nav">
                                <a href="protected?p=info">Profile</a>
                                <a href="protected?p=listUserAccounts">Accounts</a>
                        </nav>
                        <a href="#navPanel" class="navPanelToggle"><span class="fa fa-bars"></span></a>
                </div>
        </header>

<!-- Banner -->
         <section id="banner">
            <h1>Welcome to AMT</h1>
            <p>An exclusive HEIG-VD course by Olivier Liechti</p>
         </section>
         <section class="container">
            <h3>Your information: </h3>
            <table>
               <tr>
                  <td><label>Firstname: </label></td>
                  <td>${sessionScope.fname}</td>
               </tr>
               <tr>
                  <td><label>Lastname: </label></td>
                  <td>${sessionScope.lname}</td>
               </tr>
               <tr>
                  <td><label>Email: </label></td>
                  <td>${sessionScope.email}</td>
               </tr>
            
            </table>
            
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
