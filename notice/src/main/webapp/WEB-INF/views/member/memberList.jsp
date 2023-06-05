<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/main.css" rel="stylesheet" type="text/css">
</head>
<body topmargin="0" bottommargin="0" leftmargin="0" rightmargin="0"
	style="background-color: #F6F6F6">
	<div class="menu">
		<nav class="clearfix">
			<ul class="clearfix">
				<li><a href="noticeList.do">게시글 목록</a></li>
				<li><a href="memberList.do">멤버보기</a></li>
				<li><a href="memberLoginForm.do">로그인</a></li>
			</ul>
		</nav>
	</div>
</body>
<body>
	<div align="center">
		<div>
			<h1>회원 목록 보기</h1>
		</div>
		<div>
			<c:forEach items="${members }" var="m">
${m.memberId } : ${m.memberName } : ${m.memberAge } : ${m.memberTel } : ${m.memberGender } <br>
			</c:forEach>
		</div>
		<div>
			<a href="memberJoin.do">회원가입</a>
		</div>
	</div>
</body>
<footer>
	<div>
		<jsp:include page="../main/footer/footer.jsp"></jsp:include>
	</div>
</footer>
</html>