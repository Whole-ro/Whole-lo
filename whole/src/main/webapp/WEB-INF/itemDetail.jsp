<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.entity.*, model.manager.*, controller.user.*"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
ItemEntity item = (ItemEntity) request.getAttribute("item");
String userSessionID = null;

if (session.getAttribute("id") != null) {

	userSessionID = (String) session.getAttribute("id");
}
Long a = Long.parseLong(userSessionID);
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
<%@ include file="./fragments/header.jsp"%>
	<div class="header"></div>
	<div class="wrap">
		<div class="wrap_content_detail">
			<div class="wrap_content_image">
				<div style="overflow: hidden">
					<div class="carousel_main">
						<div class="carousel_wrapper">
							<div class="carousel_slide">
								<img src="<%=item.getImage()%>" width="300px" height=" 350px"
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
					<span>#나눔/장터 </span><span>#<%=item.getItemType() %></span>
				</div>
			</div>
			<div class="wrap_content_item">
				<div class="item_title">
					<p><%=item.getTitle()%></p>
				</div>
				
				<div class="item_price">
					<p><%=item.getPrice()%>원
					</p>
				</div>
				<div class="upload_day">
					<p>
						<fmt:parseDate value="${item.regDate}" pattern="yyyy-MM-dd"
							var="parsedRegDate" type="date" />
						<fmt:formatDate value="${parsedRegDate}" pattern="yyyy/MM/dd" />
					</p>
				</div>
				<hr class="item_hr" />
				<div class="item_detail">
					<p>
						<%=item.getContent()%><br />
					</p>
				</div>
				<hr class="item_hr" />
				<div class="content_icons">
					<div class="icon">
						<img src="/whole/img/market/heart.png" alt="이미지를 찾을 수 없음" />
						<div class="heart_count">
							<p>3</p>
						</div>
					</div>
					<div class="icon">
						<img src="/whole/img/market/message.png" alt="이미지를 찾을 수 없음" />
					</div>
					<div class="icon">
						<img src="/whole/img/market/bookmark.png" alt="이미지를 찾을 수 없음"/>
						<div class="scrap_count">
							<p>3</p>
						</div>
					</div>
				</div>
				
		<c:if test="${sessionScope.id eq param.writerId.toString()}">
			<form>
				<div class="Group29" style="width: 116px; height: 55px; left: 1284px; top: 520px; position: absolute">
					<a style="width: 100px; height: 45px; position: absolute; background: #508975; text-align: center; color: white; font-size: 18px;" 
					href="<c:url value='/market/delete'>
						<c:param name='myMarketId' value='${param.postId}'/>
					</c:url>">
					삭제</a>

				</div>
			</form>
				<div class="Group30" style="width: 116px; height: 55px; left: 1164px; top: 520px; position: absolute">
				<a style="width: 100px; height: 45px; position: absolute; background: #508975; text-align: center; color: white; font-size: 18px;" 
					href="<c:url value='/market/post/update'>
						<c:param name='postId' value='${param.postId}'/>
						<c:param name='writerId' value='${param.writerId}'/>
					</c:url>">
					수정 </a>
				</div>
				</c:if>
			</div>
		</div>
		<script src="../../js/Share.js"></script>
</body>

</html>