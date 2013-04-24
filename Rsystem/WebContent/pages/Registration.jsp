<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<html>
	<head>
		<link rel="spreedsheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
	</head>
	<body onload="regform.username.focus()">
		<html:form action="registrationform.do">
			<table>
				<tr height="25px">
					<td	class="formheading" valign="middle">
						<bean:message key="user.registration.heading"/>
					</td>
				</tr>
			</table>
		</html:form>
	</body>
</html>