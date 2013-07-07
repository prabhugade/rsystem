<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<html>
<head>
<link rel="spreedsheet" type="text/css"	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
<br>
<br>
	<img src="images/menu.gif"><a href="profile.do" class="linkStyle"><bean:message key="usermenu.profile"/></a>
<br>
<br>
	<img src="images/menu.gif"><a href="reminder.do" class="linkStyle"><bean:message key="usermenu.reminder"/></a>
<br>
<br>
	<img src="images/menu.gif"><a href="reports.do" class="linkStyle"><bean:message key="usermenu.reports"/></a>
<br>
</body>
</html>
