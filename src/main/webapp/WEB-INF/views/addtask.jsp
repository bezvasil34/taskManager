<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add task</title>

<link  rel="stylesheet" href="resources/css/addtask.css"/>
</head>
<body>
<sf:form action="addtask/prof" method="get">
        <button class="btn btn-default" >All tasks</button>
        </sf:form>
<div class="container">
  <div class="task__head task--row">ADD TASK </div>
  <sf:form action="addtask"  method="post">
  <input class="inp" name="description" placeholder="Enter task"/>
  <input name="date" class="date" type="date">
<button>Add</button>
  
  </sf:form>
  </div>
 
  
</div>

</body>
</html>