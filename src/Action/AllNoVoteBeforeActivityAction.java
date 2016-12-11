package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import model.activityone;


public class AllNoVoteBeforeActivityAction extends ActionSupport{
	public ArrayList<activityone> AllNoVoteBeforeActivitys;

	public ArrayList<activityone> getAllNoVoteBeforeActivitys() {
		return AllNoVoteBeforeActivitys;
	}

	public void setAllNoVoteBeforeActivitys(ArrayList<activityone> allNoVoteBeforeActivitys) {
		AllNoVoteBeforeActivitys = allNoVoteBeforeActivitys;
	}
	
	
	@Override
	public String execute(){
		try{
			DownloadSQL down = new DownloadSQL();
			setAllNoVoteBeforeActivitys(down.getAllNoVoteBeforeActivitys());
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
		
	}
}
