<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Student</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Custom CSS -->
<style>
    body {
        background-image: url('https://wallpaperaccess.com/full/124383.jpg');
        background-size: cover;
    }
    .card {
        background-color: #f9f9f9; /* change background color */
    }
    .btn-primary {
        background-color: #077505; /* change button color */
        border-color: #07f403;
    }
    .btn-primary:hover {
        background-color: #0ea40b;
        border-color: #07f403;
    }
</style>
</head>
<body>
<div class="container-fluid">
    <div class="row justify-content-center mt-5">
        <div class="col-lg-4 col-md-6 col-sm-8 col-xs-12">
            <c:choose>
                <c:when test="${student ne null}">
                   
                        <div class="card">
                            <div class="card-header text-center">Student Details</div>
                            <div class="card-body">
                                <table class="table table-bordered">
                                    <tr>
                                        <th> Id</th>
                                        <td><input type="text" class="form-control-plaintext"  value="${student.sid }" readonly></td>
                                    </tr>
                                    <tr>
                                        <th> Name</th>
                                        <td><input type="text" class="form-control-plaintext"  value="${student.sname}" readonly></td>
                                    </tr>
                                    <tr>
                                        <th> Branch</th>
                                        <td><input type="text" class="form-control-plaintext"  value="${student.sbranch}" readonly></td>
                                    </tr>
                                    <tr>
                                        <th>Phone Number</th>
                                        <td><input type="text" class="form-control-plaintext"  value="${student.sphone}" readonly></td>
                                    </tr>
                                    <tr>
                                        <th>Books</th>
                                        <td><input type="text" class="form-control-plaintext"  value="${student.books}" readonly></td>
                                    </tr>
                                   
                                    
                                </table>
                            </div>
                            <div class="card-footer text-center">
                                <a href="../homepage/managestudents.jsp" class="btn btn-link">HOME</a>
                            </div>
                        </div>
                    
                </c:when>
                
                <c:otherwise>
                    <div class="card">
                        <div class="card-header text-center">Student Details</div>
                        <div class="card-body">
                            <h1 class="text-center">Requested Student is not available</h1>
                        </div>
                        <div class="card-footer text-center">
                            <a href="../homepage/managestudents.jsp" class="btn btn-link">Home</a>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
	</div>
    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
