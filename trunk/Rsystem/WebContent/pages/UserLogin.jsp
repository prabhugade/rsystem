<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<html>
	<head>
		<link rel="spreedsheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
	</head>
	<body onload="loginForm.username.focus()">
		<html:form action="login.do">
			<table>
				<tr height="25px">
					<td	class="formheading" valign="middle">
						<bean:message key="user.login.heading"/>
					</td>
				</tr>
			</table>
			<br/>
			<table>
				<tr><td class="lableStyle"><bean:message key="user.login.username"/> </td>
					<td><html:text property="username" maxlength="80" size="18" style="color: #000000; font-weight: bold;background-color:#C9D9E4; width : 174px;"/></td>
				</tr>
				<tr><td class="lableStyle"><bean:message key="user.login.password"/></td>
					<td><html:password property="password" maxlength="80" size="18" style="color: #000000; font-weight: bold;background-color:#C9D9E4; width : 174px;"/></td>
				</tr>
				<tr><td><input type="submit" value=<bean:message key="user.login.submit"/>></td>
					<td><input type="reset" value=<bean:message key="user.login.reset"/>></td>
				</tr>
			</table>
			<br/>
			<!--<html:messages id="message" property="user.login.statuserror" message="true">
				<font class="messagedisplay"><bean:write name="message"/></font>
			</html:messages> -->
			<font class="errorsdisplay"><html:errors property="user.login.exception"/></font>
		</html:form>
		<TABLE>
					<TR>
						<td class="errorsdisplay"><html:errors property="username"/></td>
					</TR>
					<TR>
						<td class="errorsdisplay"><html:errors property="password"/></td>	
					</TR>
			</TABLE>
	</body>
</html>