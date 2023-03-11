<%@ page language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Issue Books</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
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
    p {
        text-align: center;
        color: #fff;
        font-size: 18px;
        font-weight: bold;
        text-shadow: 2px 2px 4px #000;
    }
</style>
</head>
<body>
    <div class="container">
    <br><br><br>
        <c:choose>
            <c:when test="${status eq 'success'}">
                <h1>Issued Successfully.</h1>
                <br>
                <br>
                <br>
                <br>
                <p>Note: Inform the Student to Return it back within 15 days. If Student fail to return, INR 10/day fine will be added.</p>
            </c:when>
            <c:when test="${limit eq 'out'}">
                <h1>Student Limit Is Reached.</h1>
                <br>
                <br>
                <br>
                <br>
                <p>Note: Student can borrow only 3 books.</p>
            </c:when>
            <c:when test="${quantity eq 'less'}">
                <h1>Book is not available right now.</h1>
                <br>
                <br>
                <br>
                <br>
                <p>Note: Book is not available right now.</p>
            </c:when>
            <c:otherwise>
                <h1>Book Issue Failed.</h1>
                <br><br><br>
                <p>Note: Please enter the correct student id and book id  </p>
            </c:otherwise>
        </c:choose>
        <h5>
            <a href="../homepage.jsp" class="btn btn-secondary">Home</a>
        </h5>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
