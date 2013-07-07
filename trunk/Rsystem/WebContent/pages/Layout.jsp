<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-tiles" prefix="tiles" %>

<html>
	<head>
		<title><tiles:getAsString name="title"/></title>
		<link rel="stylesheet" type="text/css" href=<%=request.getContextPath()%>/css/style.css />
	</head>
	<body>
		<table class="layout" rules="none" align="center">
			<tr class="layoutheader">
				<td colspan="2" align="center"><tiles:insert attribute="header"></tiles:insert></td>
				
			</tr>
			<tr class="bodymiddle">
			<td  class="menu" valign="top" align="center"><tiles:insert attribute="menu"/></td>
			  	<td  align="center" style="background-color:#f8f8ff;" valign="top"><tiles:insert attribute="body"/></td>
	  	    </tr>
	  		<tr class="layoutfooter">
			  	<td colspan="2" align="center"><tiles:insert attribute="footer"/></td>
	  		</tr>
		</table>		
	</body>
</html>