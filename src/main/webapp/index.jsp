<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style type="text/css">
	 body{
            background-color: rgb(88, 88, 240);
        }
        .container{
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            height: 500px;
            width: 500px;
            border: 1px solid whitesmoke;
            border-radius: 10px;
            background-color: aliceblue;
        }
        a:hover{
            color: orangered !important;
        }
</style>
</head>
<body>

	<div class="container">
        <div>
            <h3 style="text-align: center;">REGISTER</h3>
        </div>
        <form action="addemp" method="post">
            <div class="mt-5">
                <label for="name" class="form-label">Enter Your Name</label>
                <input type="text" class="form-control" name="name" id="name" required>
            </div>
            <div>
                <label for="pwd" class="form-label">Enter Your Password</label>
                <input type="password" class="form-control" name="pwd" id="pwd" required>
            </div>
            <div>
                <label for="email" class="form-label">Enter Your Email</label>
                <input type="email" class="form-control" name="email" id="email" required>
            </div>
            <div>
                <label for="cnt" class="form-label">Enter Your Country</label>
                <input type="text" class="form-control" name="cnt" id="cnt" required>
            </div>
            <br>
            <div class="d-grid">
                <button class="btn btn-primary" type="submit" value="Add & Save">Add & Save</button>
            </div>
        </form>
        <div style="display: flex; justify-content: center; margin-top: 20px;">
            <a id="anc" href="home" style="color: black;">View Employees...</a>
        </div>
    </div>
	
	
	
</body>
</html>