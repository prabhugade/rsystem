<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<html>
	<head>
		<title></title>
	</head>
	<body>
		<table>
			<tr>
				<td>
					<a href="addingreminders.do" class="linkStyle"><bean:message key="reminder.addreminder"/></a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="editreminders.do" class="linkStyle"><bean:message key="reminder.editreminder"/></a>
				</td>
			</tr>
		</table>
	</body>
</html>