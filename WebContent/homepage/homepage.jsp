<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
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
        h2 {
            text-align: center;
            margin-top: 50px;
            font-style: italic;
            font-size: 1.5rem;
            color: #fff;
            text-shadow: 2px 2px 4px #000;
        }
        .card {
            background-color: transparent;
            border: none;
            margin-bottom: 50px;
        }
        .card-header {
            background-color: #e61d88;
            color: #fff;
            font-weight: bold;
            text-shadow: 2px 2px 4px #000;
            border-radius: 20px 20px 0 0;
            padding: 20px;
        }
        .card-body {
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 0 0 20px 20px;
            padding: 20px;
        }
        .jumbotron {
            background-color: rgba(0, 0, 0, 0.8);
            color: #fff;
            text-shadow: 2px 2px 4px #000;
            margin-top: 50px;
            padding: 50px;
        }
        .jumbotron h2 {
            margin-bottom: 30px;
            font-size: 3rem;
        }
        .jumbotron p {
            font-size: 1.5rem;
        }

        .logout-button {
         color: rgb(248, 248, 248);
         background-color: rgb(238, 8, 8);   
        position: absolute;
        top: 10px;
        left: 10px;
        }

    </style>
</head>
<body>
    <div class="container">
            <h1>Welcome to Library</h1>
           
        <a href="./controller/logout" class="btn btn-secondary logout-button">LogOut</a>
        <br><br><br>
        <div class="row">
            <div class="col-md-4">
                <div class="card">
                    <div class="card-header">Manage Books</div>
                    <div class="card-body">
                        <a href="./homepage/managebooks.jsp" class="btn btn-block btn-pink">Go to Manage Books</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-header">Manage Students</div>
                    <div class="card-body">
                        <a href="./homepage/managestudents.jsp" class="btn btn-block btn-pink">Go to Manage Students</a>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <div class="card-header">Issue Books</div>
                    <div class="card-body">
                        <a href="./homepage/issuebook.jsp" class="btn btn-block btn-pink">Go to Issue Books</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card">
                    <div class="card-header">Return Requests</div>
                    <div class="card-body">
                        <a href="./controller/getrequests" class="btn btn-block btn-pink">Go to return requests</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
