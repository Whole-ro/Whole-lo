<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.entity.*, model.manager.*"%>

<!-- jsp:useBean id = "item"  class="model.entity.ItemEntity" scope="page"/-->
<!--jsp:getProperty name="postId" property="*" /-->

<!-- 자동정렬 shift +alt + F -->
<%-- PostManager manager = PostManager.getInstance();
	ItemEntity item = manager.findItem("7");
	// List<ItemEntity> itemList = manager.findItem(postId);
	if(item==null){
		System.out.print("item이 null");
	} 
--%>
<% ItemEntity item = (ItemEntity)request.getAttribute("item"); %>

<html>
<link rel="stylesheet" href="../../css/Sharing.css">
<link rel="stylesheet" href="../../css/item_detail.css">
<head>
<meta charset="UTF-8" />
<title>나눔 장터</title>
</head>
<body>
	<div class="header">헤더</div>
	<div class="wrap">
		<div class="wrap_content">
			<div class="wrap_content_image">
				<div style="overflow: hidden">
					<div class="carousel_main">
						<div class="carousel_wrapper">
							<div class="carousel_slide">
								<img src="../../img/market/spam.png" width="300px"
									height=" 350px" alt="이미지를 찾을 수 없음" />
							</div>
							<div class="carousel_slide">
								<img src="../../img/market/background_n1.jpg" width="300px"
									height=" 350px" alt="이미지를 찾을 수 없음" />
							</div>
							<div class="carousel_slide">
								<img src="../../img/market/blue-galaxy-wallpaper.jpg"
									width="300px" height=" 350px" alt="이미지를 찾을 수 없음" />
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
					<span>#나눔/장터 </span><span>#자취생</span>
				</div>
			</div>
			<div class="wrap_content_item">
				<div class="item_title">
					<p>
						<%= item.getTitle() %></p>
				</div>
				<div class="item_price">
					<p>30,000원</p>
				</div>
				<div class="upload_day">
					<p>2000-11-01 17:09</p>
				</div>
				<hr class="item_hr" />
				<div class="item_detail">
					<p>
						가정에서 요리해드실분이면 저렴하게 가져가셔요<br /> 유통기한26년5월 입니다.
					</p>
				</div>
				<div class="report">
					<p>신고하기</p>
				</div>
				<hr class="item_hr" />
				<div class="content_icons">
					<div class="icon">
						<img src="../../img/market/heart.png" alt="이미지를 찾을 수 없음" />
						<div class="heart_count">
							<p>3</p>
						</div>
					</div>
					<div class="icon">
						<img src="../../img/market/message.png" alt="이미지를 찾을 수 없음" />
					</div>
					<div class="icon">
						<img src="../../img/market/bookmark.png" alt="이미지를 찾을 수 없음" />
						<div class="scrap_count">
							<p>3</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="/js/Share.js"></script>
</body>

</html>