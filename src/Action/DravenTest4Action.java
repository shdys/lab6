package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
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
			DownloadSQL down = new DownloadSQL();
			setAllSelfCreateActivitys(down.getAllSelfCreateActivitys(getUserEmail()));
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
		
	}
	
}
