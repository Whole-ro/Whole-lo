<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/whole/css/changePass_Mypage2.css">
</head>
<body>
	<form name="form" method="POST" action="<c:url value='/user/login' />">
		<div
			style="width: 1532px; height: 997px; top: 200px; position: relative; background: white">
			<div
				style="width: 263px; height: 60px; left: 632px; top: 134px; position: absolute; text-align: center; color: black; font-size: 40px; font-family: Inter; font-weight: 700; word-wrap: break-word">비밀번호
				변경</div>

			<div
				style="width: 398px; height: 54px; left: 568px; top: 221px; position: absolute">
				<input type=text size="20"
					style="font-size: 20px; width: 398px; height: 54px; left: 0px; top: 0px; position: absolute; border: 2px #ADADAD solid"
					placeholder="새 비밀번호">
			</div>
			<div
				style="width: 398px; height: 54px; left: 568px; top: 316px; position: absolute">
				<input type=text size="20"
					style="font-size: 20px; width: 398px; height: 54px; left: 0px; top: 0px; position: absolute; border: 2px #ADADAD solid"
					placeholder="새 비밀번호 확인">
			</div>

			<input type="button" class="custom-button" value="확인"
				style="width: 398px; height: 54px; left: 566px; top: 411px; position: absolute; background: #508975; border-color: #508975; font-size: 20px; font-weight: 600; color: white;"
				onClick="document.location='mypage.html'" />
		</div>
	</form>
</body>
</html>