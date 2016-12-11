package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import model.user;

public class NoVoteBeforeModifyAction extends ActionSupport {
	public String Type = null;

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		this.Type = type;
	}
	
	@Override
	public String execute(){
		try{
			String turnType = getType();
			return turnType;
		}catch(Exception e){
			return ERROR;
		}
		
	}
}
