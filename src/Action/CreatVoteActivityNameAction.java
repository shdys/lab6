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


public class CreatVoteActivityNameAction {
	private String userEmail = null;
	private String voteActivityName = null;
	
	
	
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
			UploadSQL up = new UploadSQL();
			boolean CreatVoteActivityNameFlag =  up.creatNewVoteActivityName(getUserEmail(),getVoteActivityName());
			//boolean CreatVoteActivityTableFlag = up.ceratVoteActivityTable(getUserEmail(),getVoteActivityName());
			up.ceratVoteActivityTable(getUserEmail(),getVoteActivityName());
			//if(CreatVoteActivityNameFlag && CreatVoteActivityTableFlag)
			if(CreatVoteActivityNameFlag)
			{
				return Action.SUCCESS;
			}
			return Action.ERROR;
		} catch (Exception e) {
			return Action.ERROR;
		}
		
		
		
	}
}
