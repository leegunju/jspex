<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Register Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Board Register Page</h1>
	
	<form class="mb-3" action="/brd/insert" method="post" enctype="multipart/form-data">
		title : <input class="form-control" type="text" name="title"><br>
		writer : <input class="form-control" type="text" name="writer" value="${ses.id }" readonly="readonly"><br>
		content : <textarea class="form-control" rows="3" cols="30" name="content"></textarea><br>
		imageFile : <input type="file" id="file" name="image_file" accept="image/png, image/jpg, image/jpeg, image/bmp, image/gif">
		<button class="btn btn-primary" type="submit">register</button>
	</form>
</body>
</html>