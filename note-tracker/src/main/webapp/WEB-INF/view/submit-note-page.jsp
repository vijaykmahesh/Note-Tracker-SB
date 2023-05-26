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
 
 Your Entered note is : ${noteObj.note}
 <br/>
 Your Desc is : ${noteObj.desc}
 
 <br/>
 <br/>
 
  <a href="/myapp/find-all-notes" class="link-success">Show All Notes</a> 
 
 </div>
 
</body>
</html>