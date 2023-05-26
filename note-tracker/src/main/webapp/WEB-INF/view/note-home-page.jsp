<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet" />

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="menu.jsp" %>

<div class="container">
 <h1> Welcome to Note Tracker </h1>
 
 <form:form action="submit-form" modelAttribute="noteObj" method="POST">
 
  <form:hidden path="id"/>
 
 <div class="mb-3">
   <label for="forNoteFeild" class="form-label">Enter your note :</label>
   <form:input class="form-control" id="forNoteFeild" type="text" path="note"/>
   <form:errors path="note" class="text-danger" />
 </div>
  
  <div class="mb-3">
  <label for="decriptionField" class="form-label">Description :</label>
   <form:textarea class="form-control" id="decriptionField" rows="4" cols="50" path="desc" />
  <form:errors path="desc" class="text-danger" />
  </div>
  
  

 
  <input type="submit" class="btn btn-success"> 
 </form:form>
 
</div>
</body>
</html>