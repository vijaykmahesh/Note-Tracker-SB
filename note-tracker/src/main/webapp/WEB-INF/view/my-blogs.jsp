<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file="menu.jsp"%>

	<div class="container">
		<h1 class="text-center">My Blogs</h1>
		<hr />

		<a href="/myapp/blog-home" class="btn btn-primary">Create Blog</a> <br />
		<br />




		<div class="row">
			<c:forEach var="blog" items="${blogsList}">
				<div class="col-4">
					<a href="/myapp/getBlogById?id=${blog.id}"><h4>${blog.blogTitle}</h4></a>
				</div>
			</c:forEach>
		</div>




	</div>

</body>
</html>







