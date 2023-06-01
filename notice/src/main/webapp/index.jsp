<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="main.do" /> <!-- forward 는 앞에서 무엇인가가 던져지면 그거 무시하고 바로 main.do로 보내버리고(request response가 두개만들어짐.)
										dispatcher 는 앞에서 던져진것을 가지고 main.do로 간다. 원래는 서버가 만들어줘야 하는 request를 내가 들고간다고 보면 됨.-->
</body>
</html>