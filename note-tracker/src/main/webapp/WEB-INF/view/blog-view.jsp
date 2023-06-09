<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css"
	rel="stylesheet" />

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div class="container">
		
		<h2 class="text-center">${blog.blogTitle}</h2>
		<h4 class="text-center">${blog.subject}</h4>
		
		<hr />
		
		<div class="row">
		<div class="col-6"><h1>Author : ${blog.writtenBy}</h1></div>
		<div class="col-6"><h1>${blogDate}</h1></div>
		</div>
		<br/>
		<br/>
		
		
		<p class="h2">${blog.content}</p>
		
		
	</div>

</body>
</html>







