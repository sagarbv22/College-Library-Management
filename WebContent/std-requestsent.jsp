<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Request</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <style>
        body {
            background-image: url('https://wallpaperaccess.com/full/124383.jpg');
            background-repeat: no-repeat;
            background-size: cover;
        }
        .container {
            margin-top: 50px;
        }
        .options {
            display: flex;
            flex-direction: column;
            justify-content: flex-start;
            align-items: flex-start;
            margin-bottom: 30px;
        }
        .options a {
            margin-bottom: 10px;
            padding: 10px 20px;
            border-radius: 20px;
            color: #fff;
            background-color:#e61db7;
            transition: all 0.3s ease-in-out;
        }
        .options a:hover {
            text-decoration: none;
            background-color: #e61d60;
        }
        h1 {
            text-align: center;
            margin-bottom: 30px;
            color: #fff;
            text-shadow: 2px 2px 4px #000;
        }
        .table th, .table td {
            text-align: center;
            vertical-align: middle;
            font-size: 14px;
        }
        
        table td {
            color: #fff;
        }
        
         table th {
            color: #fff;
        }
        
        
        table {
            width: auto;
            max-width: 600px;
            margin: 20px auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Request Sent</h1>
        <div class="table-responsive">
            <table class="table table-bordered">
                <tbody>
                    <tr>
                        <th>Student ID</th>
                        <th>${request.sid}</th>
                    </tr>
                    <tr>
                        <th>Book ID</th>
                        <th>${request.bid}</th>
                    </tr>
                    <tr>
                        <th>Fine</th>
                        <th>${request.fine}</th>
                    </tr>
                </tbody>
            </table>
            <h6 style="color: white; text-align: center">Note: Request will be accepted within 24hrs</h6>
        </div>
        <div class="options">
            <a href="../stdtest/home">OK</a>
        </div>
    </div>
    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
