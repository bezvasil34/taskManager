<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Task manager</title>

 <link  rel="stylesheet" href="resources/css/profile.css"/>
 
 

</head>
<body >

			<sf:form action="logout" method="post">
        <button class="btn btn-default" >Logout</button>
        ${userAuth.name}
        </sf:form>
			
<div class="container">
  <div class="task__head task--row">YOUR TASKS </div>
  <c:forEach var="task" items="${tasks}">
  <div>
 <h2> ${task.description} ${task.date} <a href="delete/${task.id }">delete</a> <a href="edit/${task.id }">edit</a> </h2>
 </div>
  </c:forEach>

     <div> <h2><a href="addtaskpage">Add Task</a></h2></div>
  </div>

  

 

</body>

</html>