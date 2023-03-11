<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Books</title>
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

a {
	color: #fff;
	text-decoration: none;
	border: 1px solid #fff;
	border-radius: 5px;
	padding: 5px 10px;
}

a:hover {
	background-color: #fff;
	color: #000;
}
</style>
</head>
<body>
	<div class="container">
	<br><br><br>
		<c:choose>
			<c:when test="${result eq 'success'}">
				<h1 >Book added
					successfully.</h1>
			</c:when>
			<c:otherwise>
				<h1 >Book addition
					failed.</h1>

			</c:otherwise>
		</c:choose>
		<br> <br>
		<h5>
			<a href="../homepage/managebooks.jsp">Home</a>
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
