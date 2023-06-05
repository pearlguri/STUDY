<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>회원가입</h1>
	</div>
	<div>
		<form id="frm" action="memberInsert.do" onsubmit="return formCheck()"
			method="post">
			<div>
				<table border="1">
					<tr>
						<th width="150">*아이디</th>
						<td width="300"><input type="email" id="memberId"
							name="memberId" required="required">&nbsp;
							<button type="button" id="checkId" value="No" onclick="idCheck()">중복체크</button></td>
					</tr>
					<tr>
						<th>*패스워드</th>
						<td><input type="password" id="memberPassword"
							name="memberPassword" required="required"></td>
					</tr>
					<tr>
						<th>*패스워드 확인</th>
						<td><input type="password" id="passwordCheck"
							name="passwordCheck" required="required"></td>
					</tr>
					<tr>
						<th>*사용자명</th>
						<td><input type="text" id="memberName" name="memberName"
							required="required"></td>
					</tr>
					<tr>
						<th>나이</th>
						<td><input type="number" id="memberAge" name="memberAge"></td>
					</tr>
					<tr>
						<th>*전화번호</th>
						<td><input type="tel" id="memberTel" name="memberTel"
							required="required"></td>
					</tr>
					<tr>
						<th>*성별</th>
						<td><input type="text" id="memberGender" name="memberGender"
							required="required"></td>
					</tr>
				</table>
			</div>
			<br>
			<div>
				<input type="submit" value="등록">&nbsp;&nbsp; <input
					type="reset" value="취 소">&nbsp;&nbsp; <input type="button"
					onclick="location.href='main.do'" value="홈가기">
			</div>
		</form>
	</div>
	<script type="text/javascript">
		function formCheck() {
			let frm = document.getElementById("frm");
			if (frm.memberPassword.value != frm.passwordCheck.value) {
				alert("패스워드가 일치하지 않습니다!");
				frm.memberPassword.value = "";
				frm.passwordCheck.value = "";
				frm.memberPassword.focus();
				return false;
			}
			if (frm.checkId.value != "Yes") {
				alert("아이디 중복체크를 수행하세요.");
				return false;
			}
			return true;
		}

		function idCheck() {
			let id = document.getElementById("memberId").value;
			let checkId = document.getElementById("checkId").value;
			let url = "ajaxCheckId.do?id="+id;
			fetch(url){ //ajax 호출
				.then(response => response.text())
				.then(text => alert(text));
			}
		}
	</script>
</body>
</html>