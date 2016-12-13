package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import db.UploadSQL;
import model.Participant;
import model.user;


public class AddThisUserToParticipantsAction extends ActionSupport {
	public String userEmail1;
	public user uservary;
	public String BeforeOrAfter;
	
	public String getBeforeOrAfter() {
		return BeforeOrAfter;
	}
	public void setBeforeOrAfter(String beforeOrAfter) {
		BeforeOrAfter = beforeOrAfter;
	}
	
	public String getUserEmail1() {
		return userEmail1;
	}
	public void setUserEmail1(String userEmail1) {
		this.userEmail1 = userEmail1;
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
			setBeforeOrAfter(down5.getVoteCreaterBOA(down5.getVoteACTName()));
			
			setUservary(down5.getUserByEmail(getUserEmail1()));
			boolean addSuccess = up5.addThisUserToParticipants(getUservary(),down5.getVoteACTName());
			
			boolean addSuccess2 = up5.addParticipantToVoteActivity(getUserEmail1(),down5.getVoteACTName(),getBeforeOrAfter());
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
