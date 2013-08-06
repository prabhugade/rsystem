<%@page import="com.java.struts.profile.UserDataPojo"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<html>
<head>
<title>Profile</title>
<link rel="spreedsheet" type="text/css"	href="<%=request.getContextPath()%>/css/style.css"/>
	<script type = "text/javascript">
		function changeToBackAction()
		{
			document.forms[0].action='profile.do';		
			document.forms[0].submit();	
		}
		</script>
</head>
<body>
	<form action="updateuserprofile.do" method="post">
		<%
			UserDataPojo pojo = (UserDataPojo) request.getAttribute("custdata");
			if (pojo != null) {
		%>
		<table>
			<tr>
				<td><bean:message key="profile.username" /></td>
				<td><input type="text" name="uname" maxlength="80" size="18" value="<%=pojo.getUserName()%>"></td>
			</tr>
			<tr>
				<td><bean:message key="profile.password" /></td>
				<td><input type="password" name="password" maxlength="80" size="18" value="<%=pojo.getPassword()%>"></td>
			</tr>
			<tr>
				<td><bean:message key="profile.firstname" /></td>
				<td><input type="text" name="fname" maxlength="80" size="18" value="<%=pojo.getFirstName()%>"></td>
			</tr>
			<tr>
				<td><bean:message key="profile.lastname" /></td>
				<td><input type="text" name="lname" maxlength="80" size="18" value="<%=pojo.getLastName()%>"></td>
			</tr>
			<tr>
				<td><bean:message key="profile.email" /></td>
				<td><input type="text" name="email" maxlength="80" size="18" value="<%=pojo.getEmail()%>"></td>
			</tr>
			<tr>
				<td><bean:message key="profile.address" /></td>
				<td><input type="text" name="address" maxlength="80" size="18" value="<%=pojo.getAddress()%>"></td>
			</tr>
			<tr>
				<td><bean:message key="profile.city" /></td>
				<td><input type="text" name="city" maxlength="80" size="18" value="<%=pojo.getCity()%>"></td>
			</tr>
			<tr>
				<td><bean:message key="profile.state" /></td>
				<td><input type="text" name="state" maxlength="80" size="18" value="<%=pojo.getState()%>"></td>
			</tr>
			<tr>
				<td><bean:message key="profile.pincode" /></td>
				<td><input type="text" name="pincode" maxlength="80" size="18" value="<%=pojo.getPincode()%>"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="hidden" name="uid" maxlength="80" size="18" value="<%=pojo.getUid()%>"></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value=<bean:message key="profile.update"/>></td>
					<td><input type="submit"  onClick="changeToBackAction();" value="Back"/>
				</td>
			</tr>
		</table>
		<br/>
			<html:messages id="message" property="profile.success" message="true">
			  <font class="messagedisplay"><bean:message key="profile.success" /></font>
			</html:messages>	
			<html:messages id="message" property="user.not.valid" message="true">
			  <font class="messagedisplay"><bean:message key="user.not.valid" /></font>
			</html:messages>
			<html:messages id="message" property="user.not.error" message="true">
			  <font class="messagedisplay"><bean:message key="user.not.error" /></font>
			</html:messages>
		<%
			}
		%>
	</form>
</body>
</html>
