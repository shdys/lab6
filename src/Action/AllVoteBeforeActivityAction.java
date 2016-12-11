package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import model.activityone;

public class AllVoteBeforeActivityAction extends ActionSupport{
	public ArrayList<activityone> AllVoteBeforeActivitys;

	public ArrayList<activityone> getAllVoteBeforeActivitys() {
		return AllVoteBeforeActivitys;
	}

	public void setAllVoteBeforeActivitys(ArrayList<activityone> allVoteBeforeActivitys) {
		AllVoteBeforeActivitys = allVoteBeforeActivitys;
	}
	
	@Override
	public String execute(){
		try{
			DownloadSQL down = new DownloadSQL();
			setAllVoteBeforeActivitys(down.getAllVoteBeforeActivitys());
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
		
	}

}
