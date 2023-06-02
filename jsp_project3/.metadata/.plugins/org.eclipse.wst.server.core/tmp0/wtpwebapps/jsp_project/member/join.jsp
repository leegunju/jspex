<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Join Page</h1>
	<form class="mb-3" action="/mem/register" method="post">
		ID : <input class="form-control" type="text" name="id" placeholder="ID"><br>
		Password : <input class="form-control" type="password" name="password"><br>
		Email : <input class="form-control" type="text" name="email" placeholder="abc@example.co.kr"><br>
		Age : <input class="form-control" type="text" name="age"><br>
		<button class="btn btn-primary" type="submit">가입완료</button>
	</form>
</body>
</html>