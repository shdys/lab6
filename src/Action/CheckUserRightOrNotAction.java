package Action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//import com.opensymphony.xwork2.Action;
//import java.sql.*;
import db.DownloadSQL;
import model.user;
//import db.DataBaseConnector;

/**  
* @author Â³¾æ http://luju.me
*
*/

public class CheckUserRightOrNotAction {
	private String userEmail = null;
	private String userPassword = null;
	//private Connection conn = null;
	
	
	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}
	
	public void setUserPassword(String userPassword)
	{
		this.userPassword = userPassword;
	}
	
	public String getUserEmail()
	{
		return userEmail;
	}
	
	public String getUserPassword()
	{
		return userPassword;
	}
	
	public String execute()
	{
		DownloadSQL down = new DownloadSQL();
		String RealPassword = "";
		RealPassword = down.getUserByEmail(getUserEmail()).getUserPassword();
		if(RealPassword.equals(getUserPassword()))
		{
			return Action.SUCCESS;
		}
		else
		{
			return Action.ERROR;
		}
	}
}
