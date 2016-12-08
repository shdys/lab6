package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import db.UploadSQL;
import model.Participant;
import model.user;


public class AddThisUserToParticipantsAction extends ActionSupport {
	public String userEmail;
	public user uservary;
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public user getUservary() {
		return uservary;
	}
	public void setUservary(user uservary) {
		this.uservary = uservary;
	}
	
	
	@Override
	public String execute(){
		try{
			DownloadSQL down5 = new DownloadSQL();
			UploadSQL up5 = new UploadSQL();
			
			
			setUservary(down5.getUserByEmail(getUserEmail()));
			boolean addSuccess = up5.addThisUserToParticipants(uservary,down5.getVoteACTName());
			boolean addSuccess2 = up5.addParticipantToVoteActivity(userEmail,down5.getVoteACTName());
			if(addSuccess == false || addSuccess2 == false)
			{
				return ERROR;
			}
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
		
	}
}
