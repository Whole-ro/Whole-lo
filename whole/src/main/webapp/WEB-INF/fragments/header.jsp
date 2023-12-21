<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="header">
            <nav class="navbar">
                <div class="navbar_logo1"><img class="logo1" onClick="location.href='findPw.html'" src="/whole/img/ic_logo.png"></div>
                <ul class="navbar_text">
<!--                          mappings.put("/market", new ListMarketController());
 -->                
                    <li>
                    	<span class="text2" onClick="location.href='<c:url value='/myRefg/list'/>'">
                    		나만의 냉장고
                    	</span></li>
                    <li>
                    
                    	<span class="text2" onClick="location.href='<c:url value='/market'/>'">
                    		나눔, 장터
                    		</span>
                    </li>
                    <li>
                    	<span class="text2" onClick="location.href='<c:url value='/withWith'/>'">
                    		같이 가치
                    		</span>
                    	</li>
                </ul>
                <ul class="navbar_img">
                    <li><img class="logo_left" src="/whole/img/market/ic_message.png" onClick="location.href='findPw.html'"></li>
                    <li><img class="logo_left" src="/whole/img/market/ic_bell.png" onClick="location.href='findPw.html'"></li>
                    <li><p class="logo_left" onClick="location.href='<c:url value='/user/view'/>'" >MY</p></li>
                </ul>
            </nav>
    </div>
</body>
</html>