<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.service.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
   	<link rel="stylesheet" href="/whole/css/header.css">
	<link rel=stylesheet href="<c:url value='/css/withwith/withwith.css' />" type="text/css">	
	<title>같이 가치</title>
    <script>
        function changeFontColor(clicked_button, unclicked_button) {
            // 버튼 클릭 시 폰트 색 변경
            clicked_button.style.color = '#000000'; //클릭 시 검은색
            unclicked_button.style.color = '#9D9D9D'; //아닐 시 회색
        }
        
    </script>
</head>
<body>
    <%@ include file="../fragments/header.jsp"%>
    
    <div class="box">
        <div class="box_content">
            <div class="together_title">같이의 가치<br>우리 친구 해요</div>
           <!--  <div class="search_area">
              <span class="search_img">
                <img src="/whole/img/withwith/ic_search.png" width="45px">
              </span>
              <span class="selection">
                <select>
                        <option>제목</option>
                        <option>내용</option>
                </select>
              </span>
              <span class="input_text">
                <input type="text" placeholder="&nbsp;검색" style="width: 345px; height:37px; font-size: 20px;">
              </span>
              <span class="search_btn">
                <button class="searchBtn_style" onclick="alert('검색 클릭')">검색</button>
              </span>
            </div> -->
            </div>
        </div>
      <div class="together_content">
        <div><h1>친구 찾기</h1></div>
        <div class="hashBtn">
            <button class="hashTagbtn_style <%= (request.getRequestURI().equals("/withWith")) ? "active-button" : "" %>" 
            id="btn_all" onclick="changeFontColor(this, btn_gender); location.href='<c:url value='/withWith'/>'">#전체</button>
            <button class="hashTagbtn_style" id="btn_gender" onclick="changeFontColor(this, btn_all); location.href='<c:url value='/withWith/gender'/>'">#같은 성별만</button>
        </div>
      </div>
      <div class="commentArea">
     	 <c:forEach var="user" items="${userList}">
          <table class="comment_table">
              <thead>
                <tr>
                  <td class="userImg" rowspan="3"><img src="/whole/img/withWith/ic_profile.png" width="100px"></td>
                  <td class="userName" colspan="3">${user.nickname}</td>
                </tr>
                <tr>
                  <td class="userContent" colspan="3">#${user.address}</td>
                </tr>
                <tr>
                  <td class="userContent">${user.introduction}</td>


                </tr>
                <tr>
                  <td colspan="4" class="line"></td>
                </tr>
              </thead>
            </table>
          </c:forEach>
      </div>
</body>

</html>