<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.dto.*, model.manager.*"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
FoodDTO food = (FoodDTO) request.getAttribute("item");
%>
<html>
<link rel="stylesheet" href="/whole/css/Sharing.css">
<link rel="stylesheet" href="/whole/css/item_detail.css">
<link rel="stylesheet" href="/whole/css/header.css">
<head>
<meta charset="UTF-8" />
<title>나눔 장터</title>
</head>
<body>
<%@ include file="../fragments/header.jsp"%>
	<div class="header"></div>
	<div class="wrap">
		<div class="wrap_content_detail">
			<div class="wrap_content_image">
				<div style="overflow: hidden">
					<div class="carousel_main">
						<div class="carousel_wrapper">
							<div class="carousel_slide">
								<img src="<%=food.getImage()%>" width="300px" height=" 350px"
									alt="이미지를 찾을 수 없음" />
							</div>
							<div class="carousel_slide">
								<img src="/whole/img/market/background_n1.jpg" width="300px"
									height=" 350px" alt="이미지를 찾을 수 없음" />
							</div>
							<div class="carousel_slide">
								<img src="/whole/img/market/blue-galaxy-wallpaper.jpg" width="300px"
									height=" 350px" alt="이미지를 찾을 수 없음" />
							</div>
						</div>
						<div class="carousel_button_container">
							<button type="button" class="carousel_prev">prev</button>
							<button type="button" class="carousel_next">next</button>
						</div>
						<div class="carousel_pagination">
							<div class="carousel_circle"></div>
							<div class="carousel_circle"></div>
							<div class="carousel_circle"></div>
							<div class="carousel_circle"></div>
						</div>
					</div>
				</div>
				<div class="carousel_tag">
					<span>#<%=food.getFoodType()%> </span>
				</div>
		
			</div>
			<div class="wrap_content_item">
				<div class="item_title">
					<p><%=food.getTitle()%></p>
				</div>
				<div class="item_price">
					<p><%=food.getExpDate()%>까지
					</p>
				</div>
				<div class="upload_day">
					<p>
						<fmt:parseDate value="${food.regDate}" pattern="yyyy-MM-dd"
							var="parsedRegDate" type="date" />
						<fmt:formatDate value="${parsedRegDate}" pattern="yyyy/MM/dd" />
					</p>
				</div>
				<hr class="item_hr" />
				<div class="item_detail">
					<p>
						<%=food.getContent()%><br />
					</p>
				</div>
				<div class="Group29" style="width: 116px; height: 55px; left: 984px; top: 515px; position: absolute">
					<button type="button" style="width: 100px; height: 45px; position: absolute; background: #508975; text-align: center; color: white; font-size: 20px;">삭제</button>
				</div>
				<div class="Group30" style="width: 116px; height: 55px; left: 864px; top: 515px; position: absolute">
					<button type="button" style="width: 100px; height: 45px; position: absolute; background: #508975; text-align: center; color: white; font-size: 20px; font-family: Inter;">수정</button>
				</div>
				<div class="Group32" style="width: 253px; height: 55px; left: 867px; top: 450px; position: absolute">
					<button type="button" style="width: 220px; height: 45px; position: absolute; background: #508975; text-align: center; color: white; font-size: 20px; font-family: Inter; font-weight: 500;">이 음식 나눔/판매하기</button>
				</div>
				
			</div>
		</div>
		<script src="../../js/Share.js"></script>
</body>

</html>