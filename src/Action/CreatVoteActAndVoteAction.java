package Action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import db.UploadSQL;
import db.DownloadSQL;
import model.user;

public class CreatVoteActAndVoteAction {
	public String userEmail = null;
	public String voteActivityName = null;
	public String type = null;
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getVoteActivityName() {
		return voteActivityName;
	}
	public void setVoteActivityName(String voteActivityName) {
		this.voteActivityName = voteActivityName;
	}
	
	
	public String execute(){
		try {
			UploadSQL up7 = new UploadSQL();
			boolean CreatVoteActAndVoteActionFlag =  up7.inputVoteResult(getUserEmail(),getVoteActivityName(),getType());
			
			
			
			return Action.SUCCESS;
		} catch (Exception e) {
			return Action.ERROR;
		}
	}
	
}
