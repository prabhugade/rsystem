<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<html>
	<body>
	<central><h4><bean:message key="body.heading"/><h4></central>
		<table width=100%>
			<tr>
				<td width=25%><IMG SRC="<%=request.getContextPath()%>/images/reminder.gif" BORDER="0" width=90%></td>
				<td>
					<ul><li>Register your account in Reminder System...You never miss your friends birthdays, important meetings and so on.</li></ul>
					<ul><li>You can create reminders on different basis like daily, weekly, monthly and yearly.</li></ul>
				</td>				
			</tr>			
			<tr>
				<td width=25%><IMG SRC="<%=request.getContextPath()%>/images/email.png" BORDER="0" width=90%></td>
				<td width=75%>
					<ul><li>Once You created the reminders you will get the alert mails on specified dates.</li></ul>
				</td>
			</tr>
		</table>
	</body>
</html>