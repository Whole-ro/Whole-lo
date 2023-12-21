<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/whole/css/changePass_Mypage2.css">

<script language="JavaScript">
	function updatepw() {
		if (form.password.value == "") {
			alert("비밀번호를 입력하십시오.");
			form.password.focus();
			return false;
		}
		form.submit();
	}
</script>
</head>
<body>
	<form name="form" method="GET"
		action="<c:url value='/user/updatepassword'>
		<c:param name="password" value='${param.password}'/>
		</c:url>">
		">
		<div
			style="width: 1532px; height: 997px; top: 200px; position: relative; background: white">
			<div
				style="width: 263px; height: 60px; left: 632px; top: 134px; position: absolute; text-align: center; color: black; font-size: 40px; font-family: Inter; font-weight: 700; word-wrap: break-word">비밀번호
				변경</div>

			<div
				style="width: 398px; height: 54px; left: 568px; top: 316px; position: absolute">
				<input type="password" name="password" size="20"
					style="font-size: 20px; width: 398px; height: 54px; left: 0px; top: 0px; position: absolute; border: 2px #ADADAD solid"
					placeholder="변경하고자 하는 비밀번호를 입력하세요.">
			</div>

			<input type="submit" class="custom-button" value="비밀번호 변경"
				onClick="updatepw()"
				style="width: 398px; height: 54px; left: 566px; top: 411px; position: absolute; background: #508975; border-color: #508975; font-size: 20px; font-weight: 600; color: white;" />
		</div>
	</form>
</body>
</html>