<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Students</title>
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

 h5 {
	text-align: center;
	color: #fff;
	text-shadow: 2px 2px 4px #000;
}
h1 {
	margin-top: 50px;
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

<h1>Add Students</h1>
	<form method="post" action="./controller/addstudent">
			<table class="table table-bordered">
				<tr>
					<th>Student id</th>
					<td><input type="text" name="sid" class="form-control" placeholder="Enter the student id" required="required"> </td>
				</tr>
				<tr>
					<th>Student Name</th>
					<td><input type="text" name="sname" class="form-control" placeholder="Enter the student name " required="required"></td>
				</tr>
				<tr>
					<th>Student Branch</th>
					<td><input type="text" name="sbranch" class="form-control" placeholder="Enter the branch" required="required"></td>
				</tr>
				<tr>
					<th>Student Phone Number</th>
					<td><input type="text" name="sphone" class="form-control" placeholder="Enter the phone no" required="required"></td>
				</tr>
				<tr>
					<th>Student Password</th>
					<td><input type="text" name="password" class="form-control" placeholder="Enter the password" required="required"></td>
				</tr>
				<tr>
					<th>Books Issued</th>
					<td><input type="text" name="sbooks" class="form-control" value="0" readonly="readonly"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" class="btn btn-primary" name="ADD-STUDENT"></td>
				</tr>

			</table>


		</form>

		



		<h5>
			<a href="./managestudents.jsp" class="btn btn-secondary">Back</a>
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