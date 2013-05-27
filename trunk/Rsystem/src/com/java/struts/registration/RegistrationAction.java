package com.java.struts.registration;

import java.util.HashMap;

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
				if(username!=null&&password!=null&&conformpassword!=null&&firstname!=null&&lastname!=null&&email!=null&&address!=null&&city!=null&&state!=null&&pincode!=null)
				{
					if(password.equals(conformpassword))
					{
						HashMap<String,String> datamap=new HashMap<String,String>();
						datamap.put("uname", username);
						datamap.put("pwd", password);
						datamap.put("fname", firstname);
						datamap.put("lname", lastname);
						datamap.put("email", email);
						datamap.put("address", address);
						datamap.put("city", city);
						datamap.put("state", state);
						datamap.put("pin", pincode);
						String res=new DatabaseDAO().registration(driver, url, user, pwd, datamap);
						
						if(res.equalsIgnoreCase("success"))
						{
							result="success";
						}else
						{
							messages.add("registration.error", new ActionMessage(res));
							saveMessages(request,messages);
						}
					}else
					{
						messages.add("registration.pwdnotmatch", new ActionMessage("registration.pwdnotmatch"));
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
