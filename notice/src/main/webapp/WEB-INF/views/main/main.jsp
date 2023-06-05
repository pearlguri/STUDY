<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<div align="center">
		<h1>Welcome to My Home</h1>
	</div>
	<link href="./css/main.css" rel="stylesheet" type="text/css">
<head>
</head>
<body topmargin="0" bottommargin="0" leftmargin="0" rightmargin="0"
	style="background-color: #F6F6F6">
	<div class="menu">
		<nav class="clearfix">
			<ul class="clearfix">
				<li><a href="noticeList.do">게시글 목록</a></li>
				<li><a href="memberList.do">멤버보기</a></li>
				<c:if test="${empty id }">
					<li><a class="menuLink" href="memberLoginForm.do">로그인</a></li>
				</c:if>
				<c:if test="${not empty id }">
				<li><a class="menuLink" href="#">로그아웃</a></li>
				</c:if>
				<c:if test="${not empty name }">
				<li><a class="menuLink" href="#">${name }님 로그인</a></li>
				</c:if>
			</ul>
		</nav>
	</div>
	
</body>
<!-- <meta charset="UTF-8"> -->
<!-- <title>Insert title here</title> -->
<!-- <body> -->
<!-- 		<a href="noticeList.do">게시글 목록</a>  -->
<!-- 		<a href="memberList.do">멤버목록 보기</a> -->
<!-- 		<a href="memberLoginForm.do">로그인</a> -->
<!-- </body> -->
<footer>
<div>
	<jsp:include page="../main/footer/footer.jsp"></jsp:include>
	</div>
</footer>
</html>