<%@page import="com.java.struts.profile.UserDataPojo"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<html>
<head>
<title>Add Reminder</title>
<link rel="stylesheet" type="text/css" media="all" href="<%=request.getContextPath()%>/datepicker/jsDatePick_ltr.min.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/datepicker/jsDatePick.min.1.3.js"></script>
<link rel="spreedsheet" type="text/css"	href="<%=request.getContextPath()%>/css/style.css"/>
	<script type = "text/javascript">
		function changeToBackAction()
		{
			document.forms[0].action='reminder.do';		
			document.forms[0].submit();	
		}
		</script>
		<script type="text/javascript">
	window.onload = function(){
		new JsDatePick({
			useMode:2,
			target:"inputField",
			dateFormat:"%d-%M-%Y"
			/*selectedDate:{				This is an example of what the full configuration offers.
				day:5,						For full documentation about these settings please see the full version of the code.
				month:9,
				year:2006
			},
			yearsRange:[1978,2020],
			limitToToday:false,
			cellColorScheme:"beige",
			dateFormat:"%m-%d-%Y",
			imgPath:"img/",
			weekStartDay:1*/
		});
	};
</script>
</head>
<body>
	<form action="updateuserprofile.do" method="post">
		<table>
			<tr>
				<td><bean:message key="Reminder.Type" /></td>
				<td align="left">
					<select name="type">
					<option value="D"><bean:message key="type.daily"/></option>
					<option value="W"><bean:message key="type.weekly"/></option>
					<option value="M"><bean:message key="type.monthly"/></option>
					<option value="Y"><bean:message key="type.yearly"/></option>
					</select>					
				</td>
			</tr>
			<tr>
				<td>
					<br>					
				</td>
			</tr>
			<tr>
				<td><bean:message key="Reminder.Repeat" /></td>
				<td align="left">
					<select name="repeat">
					<option value="Y"><bean:message key="type.repeat"/></option>
					<option value="N"><bean:message key="type.once"/></option>
					</select>					
				</td>
			</tr>
			<tr>
				<td>
					<br>					
				</td>
			</tr>
			<tr>
				<td><bean:message key="Reminder.Date" /></td>
				<td><input type="text" name="date" size="12" id="inputField" /></td>
			</tr>
			<tr>
				<td><bean:message key="Reminder.Description" /></td>
				<td><input type="text" name="desc" size="12" /></td>
			</tr>
			<tr>
				<td><bean:message key="Reminder.Message" /></td>
				<td><input type="text" name="msg" maxlength="80" size="18" ></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value=<bean:message key="Reminder.insert"/>></td>
					<td><input type="submit"  onClick="changeToBackAction();" value="Back"/>
				</td>
			</tr>
		</table>		
	</form>
</body>
</html>
