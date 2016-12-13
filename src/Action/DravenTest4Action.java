package Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import db.UploadSQL;
import model.activityone;

public class DravenTest4Action extends ActionSupport{
	public String userEmail;
	public ArrayList<activityone> AllSelfCreateActivitys;

	public ArrayList<activityone> getAllSelfCreateActivitys() {
		return AllSelfCreateActivitys;
	}

	public void setAllSelfCreateActivitys(ArrayList<activityone> allSelfCreateActivitys) {
		AllSelfCreateActivitys = allSelfCreateActivitys;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	@Override
	public String execute(){
		try{
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session= request.getSession();
			setUserEmail( (String)session.getAttribute("ename"));
			DownloadSQL down = new DownloadSQL();
			UploadSQL up = new UploadSQL();
			up.AddEmailToTMPDDT4(getUserEmail());
			setAllSelfCreateActivitys(down.getAllSelfCreateActivitys(getUserEmail()));
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
		
	}
	
}
