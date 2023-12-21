<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="util.*"%>
<%@page import="model.*" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="foodTypeArray" value="${FoodTypeUtil.FOOD_TYPE_ARRAY}" />

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
 
        <form name="form" method="POST" action="<c:url value='/myRefg/post/update'>
       <c:param name='myPostId' value='${param.myPostId}'/>
					</c:url>">">
            <p class="write_myrefri">
            	<input class="write_myrefri" type="text" name="title" value="${foodList.title}" required>
            	</p>
<!--             	private Long postId;
    private String title;
    private String content;
    private String image;
    private LocalDate regDate;
    private Long writerId;
    private String foodType;
    private LocalDate expDate;
    private IsHealthy isHealthy; -->
            <p class="epDate"> 유통기한 <input type="date" name="expDate" value="${foodList.expDate}" required>  까지  
              
                <select class="kind_01" name="foodType">
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
            </p>
            <div style="display: inline-block;" class="content">
                <textarea class="content" type="text" name="content">${foodList.content}</textarea>
                <hr>
                <p><input type="file" name="image" class="fileUpload"/></p>
            </div>
            <input class="button" type="submit" value="업로드">
            <input class="button"type="submit" value="취소">
            
        </form>
    </div>
</body>
</html>