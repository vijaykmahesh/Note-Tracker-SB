<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
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
		<h1>Welcome to Blog</h1>
		<hr />


		<form:form action="submit-blog" modelAttribute="blogObj" method="POST">

			<form:hidden path="id" />

			<div class="mb-3">
				<label for="blogTitleField" class="form-label">Blog Title :</label>
				<form:input class="form-control" id="blogTitleField" type="text" 
					path="blogTitle" />
					<form:errors path="blogTitle" class="text-danger" />
			</div>

			<div class="mb-3">
				<label for="blogSubjectField" class="form-label">Subject :</label>
				<form:input class="form-control" id="blogSubjectField" type="text"
					path="subject" />
					<form:errors path="subject" class="text-danger" />
			</div>

			<div class="mb-3">
				<label for="blogWrittenField" class="form-label">Written By
					:</label>
				<form:input class="form-control" id="blogWrittenField" type="text"
					path="writtenBy" />
					<form:errors path="writtenBy" class="text-danger" />
			</div>

			<div class="mb-3">
				<label for="blogMediaLink" class="form-label">Social Media
					Link :</label>
				<form:input class="form-control" id="blogMediaLink" type="text"
					path="socialMediaLink" />
			</div>

			<div class="mb-3">
				<label for="blogDate" class="form-label">Date :</label>
				<form:input type="date" id="blogDate" path="date" />
				 <form:errors path="date" class="text-danger" />
			</div>

			<div class="mb-3">
				<label for="blogContent" class="form-label">Contents :</label>
				<form:textarea class="form-control" id="blogContent" rows="4"
					cols="50" path="content" />
					<form:errors path="content" class="text-danger" />
			</div>


			<input type="submit" value="POST" class="btn btn-success">
		</form:form>
	</div>

</body>
</html>







