package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import db.UploadSQL;
import model.activityone;

public class ChangeLeaveAction extends ActionSupport{
	public String ChangeLeaveEmail;
	public String Act_name;
	
	
	public String getChangeLeaveEmail() {
		return ChangeLeaveEmail;
	}

	public void setChangeLeaveEmail(String changeLeaveEmail) {
		ChangeLeaveEmail = changeLeaveEmail;
	}

	public String getAct_name() {
		return Act_name;
	}

	public void setAct_name(String act_name) {
		Act_name = act_name;
	}


	@Override
	public String execute(){
		try{
			DownloadSQL down = new DownloadSQL();
			UploadSQL up = new UploadSQL();
			
			setAct_name(down.getVoteACTName());
			up.changeLeave(getAct_name(),getChangeLeaveEmail());
			
			
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
		
	}

}
