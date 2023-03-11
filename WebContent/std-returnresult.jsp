<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Return</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
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
        text-align: center;
        margin-top: 50px;
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
        <a href="../stdtest/home" class="btn btn-secondary home-button">Home</a>
        <c:choose>
            <c:when test="${! empty returnPending}">
                <h1>Return Pending History</h1>
                <br>
                <br>

                <c:forEach items="${returnPending}" var="borrow">
                    <form method="post" action="../stdtest/returnrqst">
                        <table class="table table-bordered">
                            <tr>
                                <th>Student ID</th>
                                <td><input type="text" class="form-control" name="sid" value=${borrow.sid} readonly /></td>
                            </tr>
                            <tr>
                                <th>Book ID</th>
                                <td><input type="text" class="form-control" name="bid" value=${borrow.bid} readonly /></td>
                            </tr>
                            <tr>
                                <th>Date Of Borrowed</th>
                                <td><input type="text" class="form-control" name="dob" value='${borrow.dob}' readonly /></td>
                            </tr>
                            <tr>
                                <th>Last To Date Returned</th>
                                <td><input type="text" class="form-control" name="dor" value=${borrow.dor} readonly /></td>
                            </tr>
                            <tr>
                                <th>Is Returned</th>
                                <td><input type="text" class="form-control" name="status" value=${borrow.status} readonly /></td>
                            </tr>
                            <tr>
                                <th>Fine</th>
                                <td><input type="text" class="form-control" name="fine" value=${borrow.fine} readonly /></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td><input type="submit" class="btn btn-primary" value="Return" /></td>
                            </tr>
                        </table>
                    </form>
                    <br>
                    <br>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <br>
                <br>
                <br>
                <br>
                <h1>NO PENDING RETURNS</h1>
            </c:otherwise>
        </c:choose>
        <h5>
            <a href="../stdtest/home" class="btn btn-secondary">Home</a>
        </h5>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>

