<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import = "java.util.*, model.entity.*, model.manager.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
	PostManager manager = PostManager.getInstance();
	ItemEntity item = manager.findItem("7");
	// List<ItemEntity> itemList = manager.findItem(postId);
	if(item==null){
		System.out.print("item이 null");
	}
--%>
<html>
<body>
<h2><a href = "<c:url value='/market/post/detail'>
					<c:param name='postId' value='7'/>
				</c:url>">클릭</a></h2>
</body>
</html>
