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
import org.apache.struts.validator.DynaValidatorForm;

import com.java.database.DatabaseDAO;

public class UpdateUserProfile extends Action 
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request,HttpServletResponse response)throws java.lang.Exception
	{
		String driver,url,user,pwd;
		DynaValidatorForm dform=(DynaValidatorForm)form;
		HttpSession session=request.getSession(true);
		ActionMessages messages=new ActionMessages();
		String res="failed";
		if(session!=null)
		{
			ServletContext cg=getServlet().getServletContext();
			driver=cg.getInitParameter("driver");
			url = cg.getInitParameter("url");
			user = cg.getInitParameter("user");
			pwd = cg.getInitParameter("password");
			String username=dform.get("uname").toString();
			String password=dform.get("password").toString();
			String fname=dform.get("fname").toString();
			String lname=dform.get("lname").toString();
			String email=dform.get("email").toString();
			String address=dform.get("address").toString();
			String city=dform.get("city").toString();
			String state=dform.get("state").toString();
			String pincode=dform.get("pincode").toString();
			String uid=dform.get("uid").toString();
			
			res=new DatabaseDAO().updateUserInformation(driver,url,user,pwd,username,password,fname,lname,email,address,city,state,pincode,uid);
			if(res.equalsIgnoreCase("success"))
			{
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				res="success";
				messages.add("profile.success", new ActionMessage(res));
				saveMessages(request,messages);
			}else
			{
				messages.add("user.not.valid", new ActionMessage(res));
				saveMessages(request,messages);
			}
		}else
		{
			messages.add("user.not.error", new ActionMessage("exception"));
			saveMessages(request,messages);
		}
		return mapping.findForward(res);
	}
}
