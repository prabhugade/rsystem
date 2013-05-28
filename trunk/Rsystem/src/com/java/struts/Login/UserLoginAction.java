package com.java.struts.Login;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;
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

public class UserLoginAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request,HttpServletResponse response)throws java.lang.Exception
	{	
		String driver,url,user,pwd;
		ActionMessages messages = new ActionMessages(); 
		DynaValidatorForm dform=(DynaValidatorForm)form;
		HttpSession session=request.getSession(true);
		request.setAttribute("message", true);
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
				String username=dform.get("username").toString();
				String password=dform.get("password").toString();
				if(username!=null&&pwd!=null)
				{
					String res=new DatabaseDAO().loginCheck(driver, url, user, pwd, username, password);
					System.out.println(res);
					if(res.equalsIgnoreCase("success"))
					{
						session.setAttribute("username", username);
						session.setAttribute("password", password);
						result="success";
					}else
					{
						System.out.println(res);
						messages.add("user.not.valid", new ActionMessage(res));
						//messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage ("user.not.valid"));
						saveMessages(request,messages);
					}
				}
			}				
		}catch(Exception e)
		{
			System.out.println("exception");
			messages.add("user.not.error", new ActionMessage("exception"));
			//messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage ("user.not.valid"));
			saveMessages(request,messages);
		}
		//request.setAttribute(Globals.MESSAGE_KEY, messages);
		return mapping.findForward(result);
	}
}
