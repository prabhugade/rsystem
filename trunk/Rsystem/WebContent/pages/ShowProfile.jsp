<%@page import="com.java.struts.profile.UserDataPojo"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<html>
<head>
<title>Profile</title>
<link rel="spreedsheet" type="text/css"	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>
	<form action="userprofile.do">
	<%UserDataPojo pojo=(UserDataPojo)request.getAttribute("custdata"); 
		if(pojo!=null)
		{
	%>
	<table>
		<tr>
			<td><bean:message key="profile.username" /></td>
			<td><%=pojo.getUserName() %></td>
		</tr>
		<tr>
			<td><bean:message key="profile.firstname" /></td>
			<td><%=pojo.getFirstName() %></td>
		</tr>
		<tr>
			<td><bean:message key="profile.lastname" /></td>
			<td><%=pojo.getLastName() %></td>
		</tr>
		<tr>
			<td><bean:message key="profile.email" /></td>
			<td><%=pojo.getEmail() %></td>
		</tr>
		<tr>
			<td><bean:message key="profile.address" /></td>
			<td><%=pojo.getAddress() %></td>
		</tr>
		<tr>
			<td><bean:message key="profile.city" /></td>
			<td><%=pojo.getCity() %></td>
		</tr>
		<tr>
			<td><bean:message key="profile.state" /></td>
			<td><%=pojo.getState() %></td>
		</tr>
		<tr>
			<td><bean:message key="profile.pincode" /></td>
			<td><%=pojo.getPincode() %></td>
		</tr>
		<tr>
			<td><bean:message key="profile.regdate" /></td>
			<td><%=pojo.getRegisterDate() %></td>
		</tr>
		
	</table>
	<% }%>
	</form>
</body>
</html>
