<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
	</head>
	<body>
		<br>
		<br>
		<a href="userlogin.do" class="linkStyle"><bean:message key="link.user.login"/></a><br><br>
		<a href="registration.do" class="linkStyle"><bean:message key="link.user.registration"/></a>
	</body>
</html>