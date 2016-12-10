package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import db.UploadSQL;
import model.Participant;
import model.activityone;

public class AllSelfCRTACTDetailAction extends ActionSupport{
	public String Act_name;
	public String Email;
	public activityone ActivityDetail;
	public ArrayList<Participant> VoteParticipants;
	
	
	public ArrayList<Participant> getVoteParticipants() {
		return VoteParticipants;
	}


	public void setVoteParticipants(ArrayList<Participant> voteParticipants) {
		VoteParticipants = voteParticipants;
	}


	public activityone getActivityDetail() {
		return ActivityDetail;
	}


	public void setActivityDetail(activityone activityDetail) {
		ActivityDetail = activityDetail;
	}


	public String getAct_name() {
		return Act_name;
	}


	public void setAct_name(String act_name) {
		Act_name = act_name;
	}

	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}

	


	@Override
	public String execute(){
		try{
			DownloadSQL down8 = new DownloadSQL();
			UploadSQL up8 = new UploadSQL();
			
			setEmail(down8.getEMFromTPDT4());
			
			setActivityDetail(down8.getActivityDetailByACTNMAndEM(getAct_name(),getEmail()));
			if(ActivityDetail.IsVote.equals("No"))
			{
				return "NotVote";
			}
			else
			{
				setVoteParticipants(down8.getAllParticipant(getAct_name()));
				up8.AddActnameToTMPDDT4(getAct_name());
				
				if(ActivityDetail.IsCreater.equals("No"))
				{
					return "IsVoteParticipant";
				}
				else
				{
					return "IsVoteCreater";
				}
				
			}
			
		}catch(Exception e){
			return ERROR;
		}
		
	}
	
}
