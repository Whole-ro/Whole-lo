<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="/whole/css/login.css">
<meta charset="UTF-8">
	<p class="headText">
    	Whole로 
    <img class="logo1" src="../../img/ic_logo.png"></p>
    
<script language="JavaScript">
function login() {
	if (form.email.value == "") {
		alert("사용자 ID를 입력하십시오.");
		form.email.focus();
		return false;
	} 
	if (form.password.value == "") {
		alert("비밀번호를 입력하십시오.");
		form.password.focus();
		return false;
	}		
	form.submit();
}

function userCreate(targetUri) {
	form.action = targetUri;
	form.method="GET";		// register form 요청
	form.submit();
}
</script>
</head>
<body>
    <div style="text-align: center; margin-top: 118px;">
    <img class="logo2" src="/whole/img/ic_logo.png">
    <p class="text1">홀로,</p>
    <p class="text2">당신의 홀로서기를 응원합니다.</p>
    <div class="login">
    <form name="form" method="POST" action="<c:url value='/user/login' />">
    	<!--<input type="text" style="width:240" name="email">
    	<input type="password" style="width:240" name="password">-->
        <p><input class="userInfo" type="email" name="email" placeholder="이메일" required></p>
        <p><input class="userInfo" type="password" name="password" placeholder="비밀번호" required></p> 
        <p class="autoLogin">
            <input  type="checkbox" name="autoLogin" value="autoLogin">로그인 유지
            <br>
        </p>
        <input class="loginButton"type="submit" value="로그인" onClick="login()">
    </form>  
    </div>
    <hr style="margin-top: 72px; margin-bottom: 32px; width: 400px;"> 
    <div style="margin-bottom: 35px;">
        <span class="find" onClick="location.href='findId.html'">아이디 찾기</span>
        <span style="margin-left: 22px; margin-right: 22px;">|</span>
        <span class="find" onClick="location.href='findPw.html'">비밀번호 찾기</span>
    </div> 
    <p>
        <span class="text1">홀로가 처음이신가요?</span>
        <span class="text2" onClick="userCreate('<c:url value='/user/register/agreeTerms'/>')">  회원가입하러가기</span>
    </p>   
    </div>
</body>
</html>