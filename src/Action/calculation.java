package Action;
/*import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



//import java.util.ArrayList;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;*/
import com.opensymphony.xwork2.ActionSupport;
import DB.DownloadSQL;
import java.math.*;



public class calculation extends ActionSupport{
	public String money;
	public String number;
	public String email;
	public String type;
	public double average=1.2321;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	
	
	public String execute(){
		try{
			DownloadSQL down = new DownloadSQL();
			setMoney(down.getActivityMoney(getEmail()));
			setNumber(down.getActivityPeople(getEmail()));
			setType(down.getActivityType(getEmail()));
			if (type=="NORMAL"){
				average=Double.parseDouble(money)/Integer.parseInt(number);
			}
			return "NORMAL";
			/*else if(type=="girls for free"){
				
			}
*/		}catch (Exception e) {
	return ERROR;
	}
}
}
