<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
   	<link rel="stylesheet" href="/whole/css/header.css">
    <link rel="stylesheet" type="text/css" href="/whole/css/withWith/withwith.css">
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
            <div class="search_area">
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
            </div>
            </div>
        </div>
      <div class="together_content">
        <div><h1>친구 찾기</h1></div>
        <div class="hashBtn">
            <button class="hashTagbtn_style active-button" id="btn_all" onclick="changeFontColor(this, btn_gender)">#전체</button>
            <button class="hashTagbtn_style" id="btn_gender" onclick="changeFontColor(this, btn_all)">#같은 성별만</button>
        </div>
      </div>
      <div class="commentArea">
          <table class="comment_table">
              <thead>
                <tr>
                  <td class="userImg" rowspan="3"><img src="./img/ic_profile.png" width="100px"></td>
                  <td class="userName" colspan="3">월곡러</td>
                </tr>
                <tr>
                  <td class="userContent" colspan="3">#21세 #oo동 #수영</td>
                </tr>
                <tr>
                  <td class="userContent">같이놀아요와아아아아아ㅏㅇ아ㅏㅇ</td>
                  <td class="icons">
                      <button class="msgBTN" onclick="alert('쪽지 클릭')">쪽지</button>
                  </td>
                  <td class="icons">
                      <button class="accuse" onclick="alert('신고하기 클릭')">
                    <img src="./img/ic_accuse.png" width="25px">신고하기</button>
                  </td>
                </tr>
                <tr>
                  <td colspan="4" class="line"></td>
                </tr>
              </thead>
            </table>
      </div>
</body>

</html>