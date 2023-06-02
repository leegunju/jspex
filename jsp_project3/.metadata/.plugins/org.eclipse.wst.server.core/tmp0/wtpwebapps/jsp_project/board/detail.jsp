<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Detail Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Board Detail Page</h1>
	
	<div>
		<img alt="없음" src="/_fileUpload/${bvo.image_file }">	
	</div>
	
	<table class="table">
		<tr>
			<th scope="col">bno</th>
			<td>${bvo.bno }</td>
		</tr>
		<tr>
			<th scope="col">title</th>
			<td>${bvo.title }</td>
		</tr>
		<tr>
			<th scope="col">writer</th>
			<td>${bvo.writer }</td>
		</tr>
		<tr>
			<th scope="col">content</th>
			<td>${bvo.content }</td>
		</tr>
		<tr>
			<th scope="col">reg_date</th>
			<td>${bvo.reg_date }</td>
		</tr>
		<tr>
			<th scope="col">read_count</th>
			<td>${bvo.read_count }</td>
		</tr>
	</table>
	<a href="/brd/modify?bno=${bvo.bno }"><button class="btn btn-primary" type="button">수정</button></a>
	<a href="/brd/remove?bno=${bvo.bno }"><button class="btn btn-primary" type="button">삭제</button></a>
	<a href="/brd/page"><button class="btn btn-primary" type="button">list</button></a>
	<a href="/"><button class="btn btn-primary" type="button">index</button></a>
	
	<div><br><br>
		<h3>comment line</h3><br><br>
		<!-- 댓글 작성 라인 -->
		<input type="text" id="cmtWriter" value="${ses.id }" readonly="readonly">
		<br>
		<input type="text" id="cmtText" placeholder="Add Comment">
		<button type="button" id="cmtAddBtn">댓글등록</button>
	</div><br>
	
	<!-- 댓글 표시 라인 -->
	<div class="accordion" id="accordionExample">
		<div class="accordion-item">
			<h2 class="accordion-header" id="headingOne">
				<button class="accordion-button" type="button"
					data-bs-toggle="collapse" data-bs-target="#collapseOne"
					aria-expanded="true" aria-controls="collapseOne">
					cno, writer
				</button>
			</h2>
			<div id="collapseOne" class="accordion-collapse collapse show"
				aria-labelledby="headingOne" data-bs-parent="#accordionExample">
				<div class="accordion-body">
					content, reg_date
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		const bnoVal = `<c:out value="${bvo.bno }" />`;
	</script>
	<script src="/resource/board_detail.js"></script>
	<script type="text/javascript">
		printCommentList(bnoVal);
	</script>
</body>
</html>