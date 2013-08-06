package com.java.struts.reminders;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.DynaValidatorForm;

import com.java.database.DatabaseDAO;

public class AddreminderAction extends Action 
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request,HttpServletResponse response)throws java.lang.Exception
	{	
		String driver,url,user,pwd;
		ActionErrors errors=new ActionErrors();
		ActionMessages messages = new ActionMessages(); 
		DynaValidatorForm dform=(DynaValidatorForm)form;
		HttpSession session=request.getSession(true);
		String result="failed";
		try
		{
			if(session!=null)
			{
				ServletContext cg=getServlet().getServletContext();
				driver = cg.getInitParameter("driver");
				url = cg.getInitParameter("url");
				user = cg.getInitParameter("user");
				pwd = cg.getInitParameter("password");
				String username=(String)session.getAttribute("username");
				String password=(String)session.getAttribute("password");
				String type=dform.get("type").toString();
				String repeat=dform.get("repeat").toString();
				String date=dform.get("date").toString();
				String desc=dform.get("desc").toString();
				String msg=dform.get("msg").toString();
				String status=dform.get("status").toString();
				status=(status.length()>0?status:"0");
				if(username!=null&&type!=null&&repeat!=null&&date!=null&&desc!=null&&msg!=null&&status!=null)
				{
					result=new DatabaseDAO().addReminderInformation(driver, url, user, pwd, username, password, type, repeat, date, desc, msg, status);
					if(result.equalsIgnoreCase("success"))
					{
						messages.add("reminder.success", new ActionMessage(result));
						saveMessages(request,messages);
					}else
					{
							messages.add("reminder.failed", new ActionMessage(result));
							saveMessages(request,messages);
					}

				}
			}				
		}catch(Exception e)
		{
			errors.add("registration.error", new ActionError(e.getMessage()));
			saveErrors(request,errors);
		}
		return mapping.findForward(result);
	}
}
