<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
         
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html>

<html>
<head>
 <link  rel="stylesheet" href="resources/css/index.css"/>
<!-- <link href="resources/css/bootstrap.min.css" rel="stylesheet" media="screen"> -->

  
 
</head>
<meta name="viewport" content="width=device-width"> 
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
    
<body>



<div class="form button group">
  <button type="button" id="one">Register</button>
  <button type="button" id="two">Login</button>
</div>
<!-- registration -->
<sf:form action="newUser" method="post" id="registration">
  <p>
    <input type="text" name="name" id="username" placeholder="Enter your name"/>
   
  </p>
  <p>
    <input type="text" name="username" id="username" placeholder="Enter your username" />
    
  </p>
   <p>
    <input type="text" name="email" id="username" placeholder="Enter your email" />
   
  </p>
  <p>
    <input type="password" name="password" id="password" placeholder="Enter your password"/>
    
  </p>
 
  <input type="submit" name="submit" id="submit"/>
</sf:form>
<!-- login -->
<sf:form role="form" action="loginproc" method="get" id="login">
  <p>
    <input type="text" name="username" id="username" placeholder="Enter your username" >
  </p>
  <p>
    <input type="password" name="password" id="password" placeholder="Enter your password">
  </p>
  <input type="submit" name="log_in" id="log_in" value="Login">
</sf:form>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>

  <script src="resources/js/index.js"></script>


<!--     <script src="resources/js/bootstrap.min.js"></script> -->



</body>
</html>
