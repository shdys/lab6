package Action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import model.activityone;

public class AllVoteBeforeActivityAction extends ActionSupport{
	public ArrayList<activityone> AllVoteBeforeActivitys;
	public String userEmail;
	


	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public ArrayList<activityone> getAllVoteBeforeActivitys() {
		return AllVoteBeforeActivitys;
	}

	public void setAllVoteBeforeActivitys(ArrayList<activityone> allVoteBeforeActivitys) {
		AllVoteBeforeActivitys = allVoteBeforeActivitys;
	}
	
	@Override
	public String execute(){
		try{
			HttpServletRequest request=ServletActionContext.getRequest();
			HttpSession session= request.getSession();
			setUserEmail( (String)session.getAttribute("ename"));
			DownloadSQL down = new DownloadSQL();
			setAllVoteBeforeActivitys(down.getAllVoteBeforeActivitys(getUserEmail()));
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
		
	}

}
