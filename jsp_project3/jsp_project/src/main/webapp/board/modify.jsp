<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Modify Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Board Modify Page</h1>
	<br>
	<form class="mb-3" action="/brd/edit" method="post" enctype="multipart/form-data">
		bno : <input class="form-control" type="text" name="bno" value="${bvo.bno }" readonly="readonly"><br>
		title : <input class="form-control" type="text" name="title" value="${bvo.title }"><br>
		writer : <input class="form-control" type="text" name="writer" value="${bvo.writer }" readonly="readonly"><br>
		content : <textarea class="form-control" rows="3" cols="30" name="content">${bvo.content }</textarea><br>
		reg_date : <input class="form-control" type="text" name="reg_date" value="${bvo.reg_date }" readonly="readonly"><br>
		image_file : <img alt="없음" src="/_fileUpload/th_${bvo.image_file }">
		<input type="hidden" name="image_file" value="${bvo.image_file }">
		<input type="file" name="new_file">
		<button class="btn btn-primary" type="submit">수정완료</button>
	</form>
</body>
</html>