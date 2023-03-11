<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
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
<c:when test="${student ne null }">
		<form method="post" action="./updatestudent">
			<table class="table table-bordered">
				<tr>
					<th>Student Id</th>
					<td><input type="text" class="form-control" name="sid"
						readonly="readonly" value="${student.sid}"></td>
				</tr>
				<tr>
					<th>Student name</th>
					<td><input type="text" class="form-control" name="sname"
						value="${student.sname}"></td>
				</tr>
				<tr>
					<th>Student branch</th>
					<td><input type="text" class="form-control" name="sbranch"
						value="${student.sbranch }"></td>
				</tr>
				<tr>
					<th>Student phone number</th>
					<td><input type="text" class="form-control" name="sphone"
						value="${student.sphone }"></td>
				</tr>
				<tr>
					<th>Student password</th>
					<td><input type="text" class="form-control" name="password"
						value="${student.password }"></td>
				</tr>
				<tr>
					<th>Student Issued books</th>
					<td><input type="text" class="form-control" name="books"
						value="${student.books }"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" class="btn btn-primary"
						value="Update"></td>
				</tr>
			</table>
		</form>
		</c:when>
		<c:otherwise>
		<br><br><br>
			<h1>Student not found for this ID :: ${id} </h1>
		</c:otherwise>
</c:choose>


		<h5>
			<a href="/LibraryManagementSystem/updatestudent.jsp"
				class="btn btn-secondary">Back</a>
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