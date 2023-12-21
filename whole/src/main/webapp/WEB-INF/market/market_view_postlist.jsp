<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.service.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/whole/css/Sharing.css">
<link rel="stylesheet" href="/whole/css/item_detail.css">
<link rel="stylesheet" href="/whole/css/header.css">
<link rel=stylesheet href="<c:url value='/css/withwith/withwith.css' />"
	type="text/css">

<meta charset="UTF-8" />

<title>나눔 장터</title>
</head>

<body>
	<%@ include file="../fragments/header.jsp"%>

	<div class="wrap">
		<div class="wrap_content">
			<div class="sub_wrap">
				<div class="sub_title">
					<p>
						나누는 즐거움<br /> 소소한 용돈 벌이
					</p>
				</div>

				<div class="sub_logo">
					<img src="/whole/img/market/Logo.png" alt=" " width="350px"
						height="300px" />
				</div>

			</div>
			<div class="main_content">
				<div class="main_content_detail">
					<div class="hashBtn" align=center>
						<button class="hashTagbtn_style id="btn-01" onclick="location.href='<c:url value='/market'/>'">#전체</button>
						<button class="hashTagbtn_style id="btn-02" onclick="location.href='<c:url value='/market/type'><c:param name='itemType' value='food' /></c:url>'">#음식</button>
						<button class="hashTagbtn_style id="btn-03" onclick="location.href='<c:url value='/market/type'><c:param name='itemType' value='appliances' /></c:url>'">#가전제품</button>
					</div>
					<div class="item_list">
						<c:forEach var="item" items="${marketList}">
							<div class="item-detail">
								<a
									href="<c:url value='/market/post/detail'>
												<c:param name='postId' value='${item.postId}'/> 
											</c:url>">
									<div class="item_img">
										<img src="${item.image}" alt="이미지를 찾을 수 없음" />
									</div>
									<div id="item-title">${item.title}</div>
									<div id="item-price">
										<p>${item.price}원</p>
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


	<script src="/whole/js/share.js"></script>
</body>

</html>