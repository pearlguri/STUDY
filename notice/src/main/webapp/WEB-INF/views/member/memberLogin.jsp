<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				<li><a href="memberLoginForm.do">로그인</a></li>
			</ul>
		</nav>
	</div>
</body>
</head>
<body>
	<div align="center">
		<div>
			<h1>로그인</h1>
		</div>
	</div>
	<div>
		<form id="frm" action="memberLogin.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">아이디</th>
						<td width="200"><input type="email" id="memberId"
							name="memberId" required="required"></td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td><input type="password" id="memberPassword"
							name="memberPassword" required="required"></td>
					</tr>
				</table>
			</div>
			<br>
			<div>
				<input type="submit" value="로그인">&nbsp;&nbsp; <input
					type="reset" value="취소">
			</div>
		</form>
	</div>
</body>
<footer>
	<div>
		<jsp:include page="../main/footer/footer.jsp"></jsp:include>
	</div>
</footer>
</html>