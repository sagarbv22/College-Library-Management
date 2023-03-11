<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Book</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<!-- Custom CSS -->
<style>
body {
	background-image: url('https://wallpaperaccess.com/full/124383.jpg');
	background-repeat: no-repeat;
	background-size: cover;
}

h1, h5 {
	text-align: center;
	color: #fff;
	text-shadow: 2px 2px 4px #000;
}

.table {
	margin-top: 50px;
	margin-bottom: 50px;
	width: 100%;
	max-width: 500px;
	margin-left: auto;
	margin-right: auto;
}

th {
	color: white;
}

.home-button {
	position: absolute;
	top: 10px;
	left: 10px;
}
</style>
</head>
<body>
	<div class="container">

<c:choose>
<c:when test="${ book ne null }">
	
		<form method="post" action="./update">
			<table class="table table-bordered">
				
			
			
			<tr><th>Book Id</th><td><input type="text" class="form-control" name="bid" readonly="readonly" value="${book.bid}"></td></tr>
<tr><th>Book Title</th><td><input type="text"  class="form-control" name="title" value="${book.title }"></td></tr>
<tr><th>Book Author</th><td><input type="text" class="form-control" name="author" value="${book.author }"></td></tr>
<tr><th>Book Quantity</th><td><input type="text"  class="form-control"  name="quantity" value="${book.quantity }"></td></tr>
<tr><th></th><td><input type="submit" class="btn btn-primary" value="update"  ></td></tr>
			</table>
		</form>
</c:when>
<c:otherwise>
<br><br> 
<h1>Book is not available for given ID :: ${ id } </h1>
</c:otherwise>
</c:choose>

		<h5>
			<a href="/LibraryManagementSystem/updatebook.jsp" class="btn btn-secondary">Back</a>
		</h5>
	</div>
	<!-- Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>