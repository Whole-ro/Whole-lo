<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.entity.*, model.manager.*"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<%
UserEntity user = (UserEntity) request.getAttribute("user");
%>
<html>
<link rel="stylesheet" href="/whole/css/mypage.css">
<head>
<meta charset="UTF-8" />
<title>마이페이지</title>
</head>

<body>
	<!-- 마이페이지 -->
	<div
		style="width: 263px; height: 60px; left:715px; top: 70px; position: absolute; text-align: center; color: black; font-size: 40px; font-family: Inter;">
		<b>마이페이지</b>
	</div>

	<!-- 둘러싼 네모 -->
	<div
		style="width: 898px; height: 600px; left: 400px; top: 150px; position: absolute">
		<div class="Rectangle12"
			style="width: 898px; height: 610px; background: rgba(217, 217, 217, 0); border-radius: 10px; border: 1px black solid"></div>

		<!-- 회원 정보 title-->
		<div
			style="width: 116px; height: 28px; left: 117px; top: 28px; position: absolute; text-align: center; color: black; font-size: 20px; font-family: Inter;">
			<b>회원 정보</b>
		</div>
		<div class="Line20"
			style="width: 674px; height: 1px; left: 124px; top: 70px; position: absolute; justify-content: center; align-items: center; display: inline-flex">
			<div class="Line3"
				style="width: 674px; height: 0px; border: 1px black solid"></div>
		</div>

		<!-- 정보변경 title -->
		<div
			style="width: 105px; height: 28px; left: 125px; top: 420px; position: absolute; text-align: center; color: black; font-size: 20px; font-family: Inter;">
			<b>정보 변경</b>
		</div>
		<div class="Line25"
			style="width: 674px; height: 1px; left: 124px; top: 462px; position: absolute; justify-content: center; align-items: center; display: inline-flex">
			<div class="Line3"
				style="width: 674px; height: 0px; border: 1px black solid"></div>
		</div>

		<!-- 버튼 -->
		<div id="logout"
			style="width: 101px; height: 37px; left: 626px; top: 577px; position: absolute">
			<input type="button" value="로그아웃"
				style="width: 80px; height: 30px; left: 0px; top: 0px; position: absolute; background: #508975; border-color: #508975; color: white; font-size: 15px; font-family: Inter; font-weight: 700;"
				onclick="document.location='main.html'" />
		</div>
		<div id="withdraw"
			style="width: 80px; height: 30px; left: 755px; top: 577px; position: absolute">
			<input type="button" value="회원탈퇴"
				style="width: 80px; height: 30px; left: 0px; top: 0px; position: absolute; background: #508975; border-color: #508975; color: white; font-size: 15px; font-family: Inter; font-weight: 700;" />
		</div>
	</div>

	<!-- 내용-회원정보 -->
	<form name="myPage_memeber">
		<table class="table-member" width="30%" height="330">
			<tr>
				<td id="name" colspan="2">
					<div class="custom-text">${usernickname}</div>
				</td>
			</tr>
			<tr>
				<td id="gender" colspan="2">
					<div class="custom-text">${usergender}</div>
				</td>
			</tr>
			<tr>
				<td id="school" colspan="2">
					<div class="custom-text">${userinterest}</div>
				</td>
			</tr>
			<tr>
				<td id="email" colspan="2">
					<div class="custom-text">${useremail}</div>
				</td>
			</tr>

			<tr>
				<td id="introduce" colspan="2">
					<div class="custom-text">${userintroduction}</div>
				</td>
			</tr>
			<tr>
				<td id="address" colspan="2">
					<div class="custom-text">${useraddress}</div>
				</td>
			</tr>
			<tr>
				<td id="checkWrite" colspan="2" style="cursor:pointer;">
					<div class="custom-text"
						onclick="document.location='checkWrite_Mypage.html'">내가 쓴 글
						확인</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="cursor:pointer;">
					<div class="custom-text"
						onclick="document.location='checkFood_Mypage.html'">나의 냉장고
						확인</div>
				</td>
			</tr>
		</table>
	</form>

	<!-- 내용-정보 변경 -->
	<form name="myPage_change">
		<table class="table-change" width="30%" height="125">
			<tr>
				<td id="changeEmail" colspan="2" style="cursor:pointer;"> 
					<div class="custom-text" style="cursor:pointer;"
						onclick="document.location='changeEmail_Mypage.html'">이메일 변경</div>
				</td>
			</tr>
			<tr>
				<td id="changePassword" colspan="2" style="cursor:pointer;">
					<div class="custom-text"
						onclick="document.location='changePass_Mypage.html'">비밀번호 변경</div>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="cursor:pointer;">
					<div class="custom-text">나의 정보 변경</div>
				</td>
			</tr>
		</table>

	</form>
</body>

</html>