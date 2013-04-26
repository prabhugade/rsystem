package com.java.struts.registration;

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

public class RegistrationAction extends Action 
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request,HttpServletResponse response)throws java.lang.Exception
	{	
		String driver,url,user,pwd;
		ActionErrors errors=new ActionErrors();
		ActionMessages messages=new ActionMessages();
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
				
				String username=dform.get("username").toString();
				String password=dform.get("password").toString();
				String conformpassword=dform.get("conformpassword").toString();
				String firstname=dform.get("firstname").toString();
				String lastname=dform.get("lastname").toString();
				String email=dform.get("email").toString();
				String address=dform.get("address").toString();
				String city=dform.get("city").toString();
				String state=dform.get("state").toString();
				String pincode=dform.get("pincode").toString();
								
				if(username!=null&&pwd!=null)
				{
					String res=new DatabaseDAO().loginCheck(driver, url, user, pwd, username, password);
					if(res.equalsIgnoreCase("success"))
					{
						result="success";
					}else
					{
						messages.add("user.login.statuserror", new ActionMessage(res));
						saveMessages(request,messages);
					}
					System.out.println(result);
				}
			}				
		}catch(Exception e)
		{
			errors.add("user.login.exception", new ActionError(e.getMessage()));
			saveErrors(request,errors);
		}
		System.out.println(result);
		return mapping.findForward(result);
	}
}
