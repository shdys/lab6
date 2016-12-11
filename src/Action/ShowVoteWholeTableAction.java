package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import model.Participant;

public class ShowVoteWholeTableAction extends ActionSupport{
	public ArrayList<Participant> Participants;
	public String Act_name;
	public ArrayList<Participant> getParticipants() {
		return Participants;
	}
	public void setParticipants(ArrayList<Participant> participants) {
		Participants = participants;
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
			DownloadSQL down15 = new DownloadSQL();
			
			setAct_name(down15.getACTNMFromTPDDT4());
			
			setParticipants(down15.getAllParticipant(getAct_name()));
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
		
	}

}
