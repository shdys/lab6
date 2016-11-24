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
import db.UploadSQL;
import model.user;
//import db.DataBaseConnector;

public class CreateActivityAction {
	private String userEmail = null;
	private String userPassword = null;
	private String userName = null;
	private String userSex = null;
	private String rePassword = null;

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserSex() {
		return userSex;
	}
	
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	
	public String execute(){
		if(getUserPassword().equals(getRePassword()))
		{
		try {
			UploadSQL up = new UploadSQL();
			boolean isUser = up.setNewUser(getUserEmail(),getUserPassword(),getUserName(),getUserSex());
			if(isUser){
				return Action.SUCCESS;
			}
			return Action.ERROR;
		} catch (Exception e) {
			return Action.ERROR;
		}
		}
		else
		{
			return "PasswordNotEqual";
		}
	}
}
