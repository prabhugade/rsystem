package com.java.struts.Login;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.DynaValidatorForm;

public class UserLoginAction extends Action
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request,HttpServletResponse response)throws java.lang.Exception
	{	
		String driver,url,user,pwd1;
		ActionErrors errors=new ActionErrors();
		ActionMessages messages=new ActionMessages();
		DynaValidatorForm dform=(DynaValidatorForm) form;
		HttpSession session=request.getSession(true);
		String result="failed";
		try
		{
			if(session!=null)
			{
				ServletContext cg=request.getServletContext();
				driver = cg.getInitParameter("driver");
				url = cg.getInitParameter("url");
				user = cg.getInitParameter("user");
				pwd1 = cg.getInitParameter("password");
				System.out.println(driver+" "+url+" "+user+" "+pwd1);
				String username=dform.get("username").toString();
				String pwd=dform.get("password").toString();
				if(username!=null&&pwd!=null)
				{
					System.out.println(username+" "+pwd);
					System.out.println("success");
				}
			}				
		}catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return mapping.findForward(result);
	}
}
