<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
 <hr/>
 
 <a href="/myapp/note-home" class="btn btn-primary">Create Note</a> 
 
 <br/> <br/>

 <table class="table table-striped">
 
 <thead class="table-dark">
  <tr>
    <th> Id</th>
    <th> Note</th>
    <th> Desc</th>
  </tr>
 </thead>
 
<tbody>
 <c:forEach var="tempNote" items="${myNotes}">
 <tr>
    <td>${tempNote.id} </td>
   <td>${tempNote.note} </td>
   <td> ${tempNote.desc} </td>
   <td> <a href="/myapp/update-note?id=${tempNote.id}" class="link-primary">update note</a> </td>
   <td> <a href="/myapp/delete-note?id=${tempNote.id}" class="link-danger" onclick="if(!(confirm('Are you sure you want to delete the record ? '))) return false">delete note</a> </td>
   
 </tr>
 
 </c:forEach>
</tbody>  
 </table>
 
 <a href="/myapp/export/excel">Export to Excel</a>
 
 </div>
 
</body>
</html>







