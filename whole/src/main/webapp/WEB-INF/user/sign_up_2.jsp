<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link type="text/css" rel="stylesheet" href="/sign_up.css">
<link rel="stylesheet" href="/whole/css/agreement.css">
<link href="https://fonts.googleapis.com/css?family=Inter&display=swap"
	rel="stylesheet" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Corinthia:wght@700&display=swap"
	rel="stylesheet">
	
<link href="/whole/css/sign_up.css" rel="stylesheet" />
<!-- link href="/css/agreement.css" rel="stylesheet" /-->

<title>회원정보입력</title>

</head>
<body>
	<div class="agreement_header">
		<header>
			<h3>Whole로 가입하기</h3>
			<img src="/whole/img/ic_linelogo.png">
		</header>
	</div>
	<div class="agreement_step_container">
		<span class="step_number">01</span> <span class="step_number">02</span>
		<span class="step_number">03</span> <span class="step_title">약관동의</span>
		<span class="step_title">본인인증</span> <span class="step_title">회원정보입력</span>
	</div>
	<div class="top_line">
		<hr>
	</div>
	<div style="text-align: center" ; class="agreement_content">
		<div class="content_title">회원정보입력</div>
		<div class="content_text">회원님의 정보를 입력해주세요.</div>
		<br>
		<br>
		<div>
			<form name="form" method="POST"
				action="<c:url value='/user/register' />">
				이메일
				<p>
					<input class="userInfo" type="email" name="email" placeholder="이메일"
						required>
				</p>
				비밀번호
				<p>
					<input class="userInfo" type="password" name="password"
						placeholder="비밀번호" required>
				</p>
				비밀번호 재확인
				<p>
					<input class="userInfo" type="password" name="pw_re"
						placeholder="비밀번호 재확인 " required>
				</p>
				성별
				<p>
					<select name="gender" id="gender" class="userInfo">
						<option value=MALE>남자</option>
						<option value=FEMALE>여자</option>
					</select>
				</p>
				관심
				<p>
					<select name="interest" id="interest" class="userInfo">
						<option value="0">수영</option>
						<option value="1">헬스</option>
						<option value="2">등산</option>
						<option value="3">요가</option>
						<option value="4">필라테스</option>
						<option value="5">런닝</option>
						<option value="6">스쿼시</option>
						<option value="7">술</option>
						<option value="8">요리</option>
						<option value="9">그림</option>
						<option value="10">맛집투어</option>
						<option value="11">영화감상</option>
						<option value="12">코딩</option>
						<option value="13">음악</option>
						<option value="14">기타</option>
					</select>
				</p>

				주소
				<p>
					<input class="userInfo" type="text" name="addresss"
						placeholder="주소  " required>
				</p>

				닉네임
				<p>
					<input class="userInfo" type="text" name="nickname"
						placeholder="사용자 닉네임 " required>
				</p>

				한줄 소개
				<p>
					<input class="userInfo" type="text" name="introduction"
						placeholder="한줄소개" height="30" required>
				</p>
				<br>
				<input class="signUpButton" type="submit" value="회원가입 ">
			</form>
		</div>
</body>
</html>