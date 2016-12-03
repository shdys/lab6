package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import model.user;

public class SearchUsersByNameAction extends ActionSupport {
	public String userName;
	public ArrayList<user> users;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public ArrayList<user> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<user> users) {
		this.users = users;
	}
	
	@Override
	public String execute(){
		try{
			DownloadSQL down = new DownloadSQL();
			setUsers(down.getUsersByName(userName));
			return SUCCESS;
		}catch (Exception e) {
			return ERROR;
		}
	}
}
