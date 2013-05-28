package com.java.struts.profile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.java.database.DatabaseDAO;

public class GetProfileAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request,HttpServletResponse response)throws java.lang.Exception
	{
		String driver,url,user,pwd;
		HttpSession session=request.getSession(true);
		ActionMessages messages=new ActionMessages();
		String result="failed";
		if(session!=null)
		{
			ServletContext cg=getServlet().getServletContext();
			driver=cg.getInitParameter("driver");
			url = cg.getInitParameter("url");
			user = cg.getInitParameter("user");
			pwd = cg.getInitParameter("password");
			String username=(String)session.getAttribute("username");
			String password=(String)session.getAttribute("password");
			UserDataPojo pojo=new DatabaseDAO().getUserInformation(driver,url,user,pwd,username,password);
			if(pojo!=null)
			{
				request.setAttribute("custdata", pojo);
				result="success";
			}else
			{
				messages.add("failed to get data",new ActionMessage("failed to get data"));
				saveMessages(request, messages);
			}
			
		}else
		{
			messages.add("session failed",new ActionMessage("session failed"));
			saveMessages(request, messages);
		}
		return mapping.findForward(result);
	}
}
