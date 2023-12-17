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
				<div class="search">
					<img id="search_img" src="/whole/img/market/Look.png" alt=" " width="35px"
						height="35px"> <select>
						<option value="제목">제목</option>
					</select> <input id="search_keyword" value="원하는 제목으로 검색하세요"></input>
					<button id="search_btn" type="button" value="검색">검색</button>
				</div>
			</div>

			<div class="sub_logo">
				<img src="/whole/img/market/Logo.png" alt=" " width="350px" height="300px" />
			</div>

		</div>
		<div class="main_content">
			<div class="main_content_detail">
				<div class="tag_btns">
					<button id="btn-01">#전체</button>
					<button id="btn-02">#유통기한 3일전</button>
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