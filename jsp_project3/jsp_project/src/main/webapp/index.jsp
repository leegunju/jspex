<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Index Page</h1>
	
	<c:if test="${ses.id ne null }">
		${ses.id }님 login 하였습니다. <br>
		${ses.id }님은 ${ses.age}세입니다. <br>
		계정생성일 : ${ses.reg_date }<br>
		마지막 접속 : ${ses.last_login }<br>
		
		<a href="/mem/modify"><button class="btn btn-primary">회원정보수정</button></a>
		<a href="/mem/logout"><button class="btn btn-primary">logout</button></a>
		<a href="/mem/delete"><button class="btn btn-primary">회원탈퇴</button></a>
		
		<br><br>
		<a href="/brd/register"><button class="btn btn-primary">게시글 작성</button></a>
		<a href="/brd/page"><button class="btn btn-primary">게시글 보기</button></a>
	</c:if>
	
	<c:if test="${ses.id eq null }">
		<a href="/mem/login"><button class="btn btn-primary">login</button></a>
		<a href="/mem/join"><button class="btn btn-primary">join</button></a>
	</c:if>
	
	<a href="/mem/list"><button class="btn btn-primary">회원리스트이동</button></a>
	
	<script type="text/javascript">
	const msg_login = `<c:out value="${msg_login}" />`;
	console.log(msg_login);
	if(msg_login === '0'){
		alert('로그인 정보가 올바르지 않습니다.');
	}
	</script>
	
</body>
</html>