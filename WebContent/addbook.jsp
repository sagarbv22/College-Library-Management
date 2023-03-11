<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


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



	<h1>Add Books</h1>
		<form method="post" action="./controller/add">
			<table class="table table-bordered">
				<tr>
					<th>Book id</th>
					<td><input type="text" class="form-control" name="bid"
						required="required" placeholder="Enter the book id"></td>
				</tr>
				<tr>
					<th>Book Title</th>
					<td><input type="text" class="form-control" name="title"
						required="required" placeholder="Enter the title" ></td>
				</tr>
				<tr>
					<th>Book Author</th>
					<td><input type="text" class="form-control" name="author"
						required="required" placeholder="Enter the author name"></td>
				</tr>
				<tr>
					<th>Book Quantity</th>
					<td><input type="text" class="form-control" name="quantity"
						required="required" placeholder="Enter the quantity"></td>
				</tr>


				<tr>
					<th></th>
					<td><input type="submit" class="btn btn-primary" value="Add" /></td>
				</tr>
			</table>
		</form>



		<h5>
			<a href="./managebooks.jsp" class="btn btn-secondary">Back</a>
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