<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="/sign_up.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
</script>

<!-- <script src = "./sign_up.js"></script> -->
</head>
<body>
	<form>
		이메일 
        <p> <input class="userInfo" type="email" name="email" placeholder="이메일" required></p>
        비밀번호 
        <p><input class="userInfo" type="password" name="pw" placeholder="비밀번호" required></p>
        비밀번호 재확인 
        <p><input class="userInfo" type="password" name="pw_re" placeholder="비밀번호 재확인 " required></p>
        성별 
        <p>
      
        <select name="성별" id="gender">
    		<option value="0">남자 </option>
    		<option value="1">여자 </option>
    	</select>
    	</p>
    	관심
    	<p>
    	<select name="관심사 " id="interest">
    		<option value="0">수영 </option>
    		<option value="1">헬스 </option>
    		<option value="2">등산 </option>
			<option value="3">요가 </option>
			<option value="4">필라테스 </option>
    		<option value="5">런닝 </option>
    		<option value="6">스쿼시 </option>
    		<option value="7">술 </option>
    		<option value="8">요리 </option>
    		<option value="9">그림 </option>
    		<option value="10">맛집투어 </option>
    		<option value="11">영화감상 </option>
    		<option value="12">코딩 </option>
    		<option value="13">음악 </option>
    		<option value="14">기타 </option>
    	</select>
    	</p>
		
		주소 
        <p><input class="userInfo" type="text" name="email" placeholder="주소  " required></p>
		
    	닉네임 
        <p><input class="userInfo" type="text" name="text" placeholder="사용자 닉네임 " required></p>
        
        한줄 소개 
        <p><input class="userInfo" type="text" name="email" placeholder="한줄소개" height="30" required></p>
        
        <input class="signUpButton"type="submit" value="회원가입 ">
    </form>  
</body>
</html>