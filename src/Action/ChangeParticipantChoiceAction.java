package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import db.UploadSQL;
import model.Participant;
import model.activityone;

public class ChangeParticipantChoiceAction extends ActionSupport{
	public String VoteResult;
	public String Email;
	public String Act_Name;
	
	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getAct_Name() {
		return Act_Name;
	}


	public void setAct_Name(String act_Name) {
		Act_Name = act_Name;
	}


	public String getVoteResult() {
		return VoteResult;
	}


	public void setVoteResult(String voteResult) {
		VoteResult = voteResult;
	}


	@Override
	public String execute(){
		try{
			DownloadSQL down9 = new DownloadSQL();
			UploadSQL up9 = new UploadSQL();
			
			setAct_Name(down9.getACTNMFromTPDDT4());
			setEmail(down9.getEMFromTPDT4());
			
			boolean flag9 = up9.changeVoteResult(getAct_Name(),getEmail(),getVoteResult());
			
			if(flag9)
			{
				return SUCCESS;
			}
			else
			{
				return ERROR;
			}
			
			
		}catch(Exception e){
			return ERROR;
		}
		
	}

}
