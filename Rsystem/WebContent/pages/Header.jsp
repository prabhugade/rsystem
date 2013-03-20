<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<html>
	<head><link rel="spreedsheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
	</head>
	<body>
		<table rules="none">
			<tr>
				<td rowspan="2" width="180px"><a href="http://javanotes2all.blogspot.in"><img src="<%=request.getContextPath()%>/images/logo.jpg" BORDER="0" ALT=""></a></td>
				<td align="center" class="layoutheader"><bean:message key="header.heading"/></td>
			</tr>
			<TR>
				<TD align="center"></TD>
			</TR>
			<TR>
				<TD colspan=2 width="1500px" valign="bottom">
					<div class="formQuestion" style="background-color:#F6EFDF ;">
						<span class="noticeMessage">
						</span>
						<span class="emphasise" style="color:#312F2D;"><bean:message key="header.welcome"/>
						</span>
					</div>
				</TD>
			</TR>
		</table>
	</body>
</html>