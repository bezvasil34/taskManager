<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Task</title>

 <link  rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/edit.css" type="text/css"/>
 
 

</head>
<body >
<sf:form action="prof" method="get">
        <button class="btn btn-default" >All tasks</button>
        </sf:form>
        
	

<div class="container">
  <div class="task__head task--row">Edit TASK </div>
  <sf:form action="editTask/${taskForEdit.id }"  method="post">
  <input class="inp" name="newDescription" placeholder="${taskForEdit.description }"/>
  <input name="newDate" class="date" type="date">
<button>Save</button>
</sf:form>
</div>

   


  

 

</body>

</html>