<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="foodTypeArray" value="${FoodTypeUtil.FOOD_TYPE_ARRAY}" />

<!DOCTYPE html>
<html>
<head>
<script>
 /* 냉장고에서 넘어오기, 글쓰기에서 넘어오기, 글 수정에서 넘어오기 */
/* function myRefgCreate(targetUri) {
	form.action = targetUri;
	form.submit();
}
 */
 
 function setForm(targetUri){
	 
	 var targetUri;
	 
	 if (){
		 // 글쓰기버튼 클릭 
		var title = document.getElementById("title");
		var content = document.getElementById(id);
		title.placeholder="제목"
	  	targetUri = 
		
	 }else{
		 // 냉장고에서 넘어옴 
		 
	 }else{
		 // 수정버튼 
	 }
	 document.getElementById(id);
		
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
    
        <form name="form" method="POST" action="<c:url value='/myRefg/post'/>">
            <p class="write_myrefri">
            <input id="title" class="write_myrefri" type="text" name="title" required></p>  
           <select id="foodType" class="kind_01" name="foodType">
                	<c:forEach var="foodType" items="${foodTypeArray}" >
                		<c:choose> 
							<c:when test="${foodType == foodList.foodType}"> 
								<option value="${foodType}" selected>${foodType}</option>
							</c:when> 
							<c:otherwise>
								<option value="${foodType}">${foodType}</option>
							</c:otherwise>
						</c:choose>  
                	</c:forEach>
          	</select>
        
            
            <div style="display: inline-block;" class="content">
                <textarea class="content" type="text" name="content" placeholder="메모를 입력해주세요."></textarea>
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