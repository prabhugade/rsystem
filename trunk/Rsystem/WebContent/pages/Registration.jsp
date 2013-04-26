<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<html>
	<head>
		<link rel="spreedsheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
	</head>
	<body onload="regform.username.focus()">
		<html:form action="registrer.do">
			<table>
				<tr height="25px">
					<td	class="formheading" valign="middle">
						<bean:message key="reg.heading"/>
					</td>
				</tr>
			</table>
			<br/>
			<table>
			<tr><td class="lableStyle"><bean:message key="reg.username"/>
				<td><html:text property="username" maxlength="80" size="18" style="color: #000000; font-weight: bold;background-color:#C9D9E4; width : 174px;"/>
			</tr>
			<tr><td class="lableStyle"><bean:message key="reg.password"/>
				<td><html:password property="password" maxlength="80" size="18" style="color: #000000; font-weight: bold;background-color:#C9D9E4; width : 174px;"/>
			</tr>
			<tr><td class="lableStyle"><bean:message key="reg.conformpassword"/>
				<td><html:password property="conformpassword" maxlength="80" size="18" style="color: #000000; font-weight: bold;background-color:#C9D9E4; width : 174px;"/>
			</tr>
			<tr><td class="lableStyle"><bean:message key="reg.firstname"/>
				<td><html:text property="firstname" maxlength="80" size="18" style="color: #000000; font-weight: bold;background-color:#C9D9E4; width : 174px;"/>
			</tr>
			<tr><td class="lableStyle"><bean:message key="reg.lastname"/>
				<td><html:text property="lastname" maxlength="80" size="18" style="color: #000000; font-weight: bold;background-color:#C9D9E4; width : 174px;"/>
			</tr>
			<tr><td class="lableStyle"><bean:message key="reg.email"/>
				<td><html:text property="email" maxlength="80" size="18" style="color: #000000; font-weight: bold;background-color:#C9D9E4; width : 174px;"/>
			</tr>
			<tr><td class="lableStyle"><bean:message key="reg.address"/>
				<td><html:textarea property="address" style="color: #000000; font-weight: bold;background-color:#C9D9E4; width : 174px;"/>
			</tr>
			<tr><td class="lableStyle"><bean:message key="reg.city"/>
				<td><html:text property="city" maxlength="80" size="18" style="color: #000000; font-weight: bold;background-color:#C9D9E4; width : 174px;"/>
			</tr>
			<tr><td class="lableStyle"><bean:message key="reg.state"/>
				<td><html:text property="state" maxlength="80" size="18" style="color: #000000; font-weight: bold;background-color:#C9D9E4; width : 174px;"/>
			</tr>
			<tr><td class="lableStyle"><bean:message key="reg.pincode"/>
				<td><html:text property="pincode" maxlength="80" size="18" style="color: #000000; font-weight: bold;background-color:#C9D9E4; width : 174px;"/>
			</tr>
			<tr><td><input type="submit" value=<bean:message key="user.login.submit"/>></td>
				<td><input type="reset" value=<bean:message key="user.login.reset"/>></td>
			</tr>
			</table>
		</html:form>
	</body>
</html>