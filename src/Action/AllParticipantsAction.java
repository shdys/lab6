package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import model.Participant;

public class AllParticipantsAction extends ActionSupport{
	public ArrayList<Participant> Participants;
	
	public ArrayList<Participant> getParticipants() {
		return Participants;
	}



	public void setParticipants(ArrayList<Participant> participants) {
		this.Participants = participants;
	}



	@Override
	public String execute(){
		try{
			DownloadSQL down = new DownloadSQL();
			setParticipants(down.getAllParticipant());
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
		
	}
}
