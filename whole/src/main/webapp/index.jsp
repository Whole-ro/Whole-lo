<html>
<body>
<h2>Hello World!</h2>


<% response.sendRedirect(request.getContextPath() + "/user/register/agreeTerms"); %>
<a href="<c:url value='/user/register/agreeTerms'/">회원가압 </a>

<button onclick="location.href='WEB-I'">Button</button >
</body>
</html>