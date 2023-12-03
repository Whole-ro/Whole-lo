<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="model.service.*" %>

<!-- 자동정렬 shift +alt + F -->
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8" />
<title>나눔 장터</title>
<script>
function userCreate(targetUri) {
	form.action = targetUri;
	form.method="GET";		// register form 요청
	form.submit();
}
</script>
</head>

<body>

<form name="form" method="POST" action="<c:url value='/market/postlist/' />">
  <table style="width:100%">
	<tr>
	  <td width="20"></td>
	  <td>
	  	<b>UserMan3a</b><br><br>
	   	<table>
	   	  <tr>
		    <td class="title">&nbsp;&nbsp;사용자 관리 - 로그인&nbsp;&nbsp;</td>
		  </tr>
	    </table>  
		
	    <!-- 로그인이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 -->	  
	  
	    <br>	  
	    <table style="width:100%">
		  <tr>
			<td align=left>
			<input type="button" value="로그인" > &nbsp;
			<input type="button" value="조회하기" onClick="userCreate(
								'<c:url value='/market/postlist'/>')">
			</td>						
		  </tr>
		  <tr height="40"><td>(관리자 로그인: admin/admin)</td></tr>
	    </table>
	  </td>	  
	</tr>
	<tr height="100"><td>&nbsp;</td>
	  <td>
		<a href="http://cs.dongduk.ac.kr">
		  <img src="<c:url value='/images/logo.gif' />" /></a>		
	  </td>
	</tr>
  </table>  
</form>

			
</body>

</html>