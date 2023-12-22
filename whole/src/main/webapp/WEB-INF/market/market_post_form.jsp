<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="util.*"%>
<%@page import="model.*"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="marketTypeArray" value="${MarketTypeUtil.MARKET_TYPE_ARRAY}" />
<% request.setCharacterEncoding("UTF-8");
 %>
<!DOCTYPE html>
<html>
<head>
<script>

/* function myRefgCreate(targetUri) {
	form.action = targetUri;
	form.submit();
}
 */
</script>
    <meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="/whole/css/myRefg/postForm.css">
	   <link rel="stylesheet" href="/whole/css/header.css">
	   
</head>
<body>

        <%@ include file="../fragments/header.jsp"%>
    <div class="write_myrefri" style="text-align: center; margin-top: 100px;">
    
        <form name="form" method="POST" action="<c:url value='/market/post/create'/>">
            <c:choose>
            	<c:when test="${param.isnewPost == 1}">
            	    <p class="write_myrefri"><input class="write_myrefri" type="text" name="title" placeholder="제목" required></p>
            	</c:when>
            	<c:when test="${isnewPost != 1}">
            	    <p class="write_myrefri"><input class="write_myrefri" type="text" name="title" value="${food.title}" required></p>
            	
            	</c:when>
           </c:choose>
            <p class="epDate"> 가격  <input type="number" name="price" required>  원 
                <select class="kind_01" name="itemType">
                	<c:forEach var="itemType" items="${marketTypeArray}" >
                    	<option value="${itemType}">${itemType}</option>
                	</c:forEach>
                </select>
            </p>
            <div style="display: inline-block;" class="content">
               <c:choose>
            		<c:when test="${param.isnewPost == 1}" >
            			<textarea class="content" type="text" name="content" placeholder="메모를 입력해주세요."></textarea>
                	</c:when>
                	<c:when test="${param.isnewPost != 1}">
                	    <textarea class="content" type="text" name="content">유통기한은 ${food.expDate} 까지 입니다.</textarea>            	
            	</c:when>
           </c:choose>
                <hr>
                <p><input type="file" name="image" class="fileUpload"/></p>
            </div>
            <input class="button" type="submit" value="업로드">
            <input class="button"type="submit" value="취소">
<!--             <div class="button">
                
            </div> -->
            
        </form>
    </div>
</body>
</html>