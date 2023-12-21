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
<link rel="stylesheet" href="/whole/css/Sharing.css">
<link rel="stylesheet" href="/whole/css/item_detail.css">
<link rel="stylesheet" href="/whole/css/header.css">
<head>
<meta charset="UTF-8" />
<title>마이페이지</title>
</head>

<body>
	<%@ include file="../fragments/header.jsp"%>
	<div class="wrap">
		<div class="wrap_content">
			<div class="sub_wrap">
				<div class="sub_title">
					<p style="font-size :20px">
						마이페이지<br />
					</p>
					
					<div class="search">
						<img id="search_img" src="../../imagefile/Look.png" width="35px"
							, height="35px"> <select>
							<option value="제목">제목</option>
							<option value="내용">내용</option>
							<option value="작성자">작성자</option>
						</select> <input id="search_keyword" value="원하는 키워드를 검색하세요"></input>
						<button id="search_btn" type="button" value="검색">검색</button>
					</div>
				</div>

				<div class="sub_logo">
					<img src="../../imagefile/Logo.png" width="350px" , height="300px" />
				</div>

			</div>
			<div class="main_content">
				<div class="main_content_detail">
				<div class="my_info">
					<p style="font-size :15px">
						성별: ${usergender} <br />주소: ${useraddress} <br /> 관심사:
						${userinterest}<br /> 자기소개: ${userintroduction} <br />닉네임: ${ usernickname}
					</p>
					</div>
					<div class="tag_btns">
						<button id="btn-01">#전체</button>
						<button id="btn-02">#생활꿀팁</button>
						<button id="btn-03">#잡담</button>
						<button id="btn-04">#음식속보</button>
					</div>
					<div class="item_list">
						<div class="item">
							<a href="./Item_detail.html">
								<div class="item_img">
									<img src="../../imagefile/spam.png" alt="이미지를 찾을 수 없음" />
								</div>
								<div class="item-detail">
									<div id="item-title">
										<p>[장터]스팸 팔아요</p>
									</div>
									<div id="item-price">
										<p>30,000원</p>
									</div>
									<div id="item-estate">
										<p>성북구</p>
									</div>
									<div id="item-uploadtime">
										<p>2000-11-01 17:09</p>
									</div>
								</div>
							</a>
						</div>

						<div class="item">
							<div class="item_img"></div>
							<div class="item-detail">
								<div id="item-title">
									<p>[장터]스팸 팔아요</p>
								</div>
								<div id="item-price">
									<p>30,000원</p>
								</div>
								<div id="item-estate">
									<p>성북구</p>
								</div>
								<div id="item-uploadtime">
									<p>2000-11-01 17:09</p>
								</div>
							</div>
						</div>

						<div class="item">
							<div class="item_img"></div>
							<div class="item-detail">
								<div id="item-title">
									<p>[장터]스팸 팔아요</p>
								</div>
								<div id="item-price">
									<p>30,000원</p>
								</div>
								<div id="item-estate">
									<p>성북구</p>
								</div>
								<div id="item-uploadtime">
									<p>2000-11-01 17:09</p>
								</div>
							</div>
						</div>

						<div class="item">
							<div class="item_img"></div>
							<div class="item-detail">
								<div id="item-title">
									<p>[장터]스팸 팔아요</p>
								</div>
								<div id="item-price">
									<p>30,000원</p>
								</div>
								<div id="item-estate">
									<p>성북구</p>
								</div>
								<div id="item-uploadtime">
									<p>2000-11-01 17:09</p>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="item_img"></div>
							<div class="item-detail">
								<div id="item-title">
									<p>[장터]스팸 팔아요</p>
								</div>
								<div id="item-price">
									<p>30,000원</p>
								</div>
								<div id="item-estate">
									<p>성북구</p>
								</div>
								<div id="item-uploadtime">
									<p>2000-11-01 17:09</p>
								</div>
							</div>
						</div>
						<div class="item">
							<div class="item_img"></div>
							<div class="item-detail">
								<div id="item-title">
									<p>[장터]스팸 팔아요</p>
								</div>
								<div id="item-price">
									<p>30,000원</p>
								</div>
								<div id="item-estate">
									<p>성북구</p>
								</div>
								<div id="item-uploadtime">
									<p>2000-11-01 17:09</p>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

</body>

</html>