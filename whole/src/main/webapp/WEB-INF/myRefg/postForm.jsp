<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="foodTypeArray" value="${FoodTypeUtil.FOOD_TYPE_ARRAY}" />

<!DOCTYPE html>
<html>
<head>
<script>

function myRefgCreate(targetUri) {
	form.action = targetUri;
	form.submit();
}

</script>
    <meta charset="utf-8">
	<link rel="stylesheet" type="text/css" href="/whole/css/myRefg/postForm.css">
	   <link rel="stylesheet" href="/whole/css/header.css">
	   
</head>
<body>
        <%@ include file="../fragments/header.jsp"%>
    <div class="write_myrefri" style="text-align: center; margin-top: 100px;">
    
        <form name="form" method="POST" action="<c:url value='/myRefg/post' />">
            <p class="write_myrefri"><input class="write_myrefri" type="text" name="title" placeholder="제목" required></p>
            <p class="epDate"> 유통기한 <input type="date" name="expDate" required>  까지  
              
                <select class="kind_01" name="foodType">
                <c:forEach var="foodType" items="${foodTypeArray}" >
                    <option value="${index}">${foodType}</option>
                </c:forEach>
                </select>
            </p>
            <div style="display: inline-block;" class="content">
                <textarea class="content" type="text" name="content" placeholder="메모를 입력해주세요."></textarea>
                <hr>
                <p><input type="file" name="image" class="fileUpload"/></p>
            </div>
            <div class="button">
                <input class="postButton" type="submit" value="업로드"  onClick="myRefgCreate()">
                <input class="cancelButton"type="submit" value="취소">
            </div>
            
        </form>
    </div>
</body>
</html>