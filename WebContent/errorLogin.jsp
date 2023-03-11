<%@ page language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Staff-Login</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-image:
		url('https://images.pexels.com/photos/2041540/pexels-photo-2041540.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1');
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	height: 100vh;
	margin: 0;
	padding: 0;
}

form {
	background-color: rgba(255, 255, 255, 0.8);
	padding: 20px;
	border-radius: 5px;
	box-shadow: 0px 0px 10px #ccc;
	width: 500px;
	margin: auto;
	margin-top: 50px;
}

h1 {
	text-align: center;
	margin-top: 0;
}

label {
	display: block;
	margin-bottom: 10px;
}

input[type=text], input[type=password], select {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-bottom: 20px;
	font-size: 16px;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
}

input[type=submit]:hover {
	background-color: #45a049;
}

button[type=button] {
	background-color: #008CBA;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	font-size: 16px;
	margin-left: 20px;
}

button[type=button]:hover {
	background-color: #006F8A;
}

.container {
	display: flex;
	justify-content: space-between;
}

.container>div {
	flex-basis: 45%;
}

.clearfix::after {
	content: "";
	clear: both;
	display: table;
}

.signup-link {
	text-align: center;
	margin-top: 20px;
	color: #fff;
	font-size: 16px;
	font-weight: bold;
}

.signup-link a {
	color: #0a7208fd;
	text-decoration: none;
}

.signup-link a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<br>
	<h1 style='color: white; text-align: center;'>Invalid username or
		password.</h1>
	<form method="post" action="./controller">
		<h1>Staff-Login</h1>
		<label for="student-id">Staff ID</label> <input type="text"
			name="userName" placeHolder="user@iNeuron.com" required> <label
			for="password">Password</label> <input type="password"
			name="password" placeHolder="password" required> <input
			type="submit" value="Log In" onclick="callalert()">
		<button type="button" onclick="window.location.href='./index.html'">Lobby</button>

	</form>



</body>
</html>