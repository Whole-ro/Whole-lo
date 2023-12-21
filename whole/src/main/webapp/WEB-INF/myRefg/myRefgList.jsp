<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.service.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<link rel="stylesheet" href="/whole/css/Sharing.css">
<link rel="stylesheet" href="/whole/css/item_detail.css">
<link rel="stylesheet" href="/whole/css/header.css">

<head>
<meta charset="UTF-8" />
<title>나눔 장터</title>
    <script>
        function changeFontColor(clicked_button, unclicked_button) {
            // 버튼 클릭 시 폰트 색 변경
            clicked_button.style.color = '#000000'; //클릭 시 검은색
            unclicked_button.style.color = '#9D9D9D'; //아닐 시 회색
        }
        
    </script>
</head>

<body>
  <link rel="stylesheet" type="text/css" href="/whole/css/withWith/withwith.css">
  <%@ include file="../fragments/header.jsp"%>
  	
<div class="wrap">
	<div class="wrap_content">
		<div class="sub_wrap">
			<div class="sub_title">
				<p id="statisitc-color">
					${mostFood} 종류를 많이 드셨네요.<p>
				"${nickname}" 님의 냉장고 신호등은 ${light} 입니다.<p>
				빨간 음식 :
				<c:forEach var="redFood" items="${redList}">
					${redFood.title}
				</c:forEach>
				<p>
				초록 음식 :
				<c:forEach var="blueFood" items="${blueList}">
					${blueFood.title}
				</c:forEach>
				</p>
				<c:if test="${light eq '빨간색'}">
				<p>대신 이런 음식은 어떠신가요?
				<c:forEach var="recommendGreenFood" items="${recommendgreenFood}">
					${recommendGreenFood}
				</c:forEach></p>
				</c:if>
					<c:if test="${light eq '파란색'}">
				<p>아주 좋아요!<br/>이런 음식도 있어요!
				<c:forEach var="recommendGreenFood" items="${recommendgreenFood}">
					${recommendGreenFood}
				</c:forEach></p>
				</c:if>
					<c:if test="${light eq '노란색'}">
				<p>이런 음식은 기피하세요!
				<c:forEach var="notrecommendredFood" items="${notrecommendredFood}">
					${notrecommendredFood}
				</c:forEach></p>
				</c:if>
			</div>

			<div class="sub_logo">
				<img src="/whole/img/market/Logo.png" alt=" " width="350px" height="300px" />
			</div>

		</div>
		
		<div class="main_content">
			<div class="main_content_detail">
			  	<button style=" width: 100px; height: 45px; background:#508975; color: white; font-size: 18px;"
			   	onclick="location.href='<c:url value='/myRefg/postForm'/>'">글작성 </button >
		
        	<div class="hashBtn">
            	<button class="hashTagbtn_style <%= (request.getRequestURI().equals("/myRefg/list")) ? "active-button" : "" %>" 
            	id="btn_all" onclick="changeFontColor(this, btn_exp); location.href='<c:url value='/myRefg/list'/>'">#전체</button>
            	<button class="hashTagbtn_style" id="btn_exp" onclick="changeFontColor(this, btn_all); location.href='<c:url value='/myRefg/search/exp'/>'">#유통기한 3일</button>
        	</div>
				<div class="item_list">
						<c:forEach var="item" items="${foodList}">
							<div class="item-detail">
							<a
								href="<c:url value='/myRefg/list/detail'>
											<c:param name='postId' value='${item.postId}'/>
										</c:url>">
								<div class="item_img">
								<img src="${item.image}" alt="이미지를 찾을 수 없음" />
								</div>
								<div id="item-title">${item.title}</div>
								<div id="item-expDate">
									<p>${item.expDate}까지</p>
								</div>
								<div id="item-uploadtime">
									<p>${item.regDate}</p>
								</div>
							</a>
					</div>
					</c:forEach>

				</div>
			</div>

		</div>
	</div>
</div>
</div>
</div>
<script src="/whole/js/share.js"></script>

</body>

</html>