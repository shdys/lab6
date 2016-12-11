package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import db.UploadSQL;
import model.user;

public class MakeACTTypeAction extends ActionSupport{
	public String LastType;
	public String Act_name;
	
	
	public String getAct_name() {
		return Act_name;
	}

	public void setAct_name(String act_name) {
		Act_name = act_name;
	}

	public String getLastType() {
		return LastType;
	}

	public void setLastType(String lastType) {
		LastType = lastType;
	}



	@Override
	public String execute(){
		try{
			DownloadSQL down10 = new DownloadSQL();
			UploadSQL up10 = new UploadSQL();
			
			setAct_name(down10.getACTNMFromTPDDT4());
			
			boolean flag10 = up10.changeVoteType(getAct_name(), getLastType());
			up10.changeVoteTypeIntoACTTable(getAct_name(),getLastType());
			if(getLastType().equals("Normal"))
			{
				return "Normal";
			}
			else if(getLastType().equals("Girls"))
			{
				return "Girls";
			}else
			{
				return "Leave";
			}
			
		}catch(Exception e){
			return ERROR;
		}
		
	}

}
