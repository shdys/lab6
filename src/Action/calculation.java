package Action;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



//import java.util.ArrayList;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;

import java.math.*;

import model.Activity;






public class calculation extends ActionSupport{
	public Activity act;
	public double average,girls,extra;
    public String name;
    public double temp;
    public int Female;
    public double Percent;
    public int Leavenumber;

  
		
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Activity getAct() {
		return act;
	}

	public void setAct(Activity act) {
		this.act = act;
	}


	public double getAverage() {
		return average;
	}


	public void setAverage(double average) {
		this.average = average;
	}

	
	public int getFemale() {
		return Female;
	}

	public void setFemale(int female) {
		Female = female;
	}

	
	public double getPercent() {
		return Percent;
	}

	public void setPercent(double percent) {
		Percent = percent;
	}

	public int getLeavenumber() {
		return Leavenumber;
	}

	public void setLeavenumber(int leavenumber) {
		Leavenumber = leavenumber;
	}
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session= request.getSession();
	String actname = (String)session.getAttribute("actname");
	public String execute(){

		try{
			DownloadSQL down = new DownloadSQL();
			setAct(down.getActivitySandN(actname));
			if ((down.getActivitySandN(actname).Type).equals("Normal")){
				temp=(Double.parseDouble(act.Sum))/(Integer.parseInt(act.Number));
			}
			else if((down.getActivitySandN(actname).Type).equals("Girls for free")){
				temp=(Double.parseDouble(act.Sum))/(Integer.parseInt(act.Number)-Female);
			    girls=0;
			}
			else if((down.getActivitySandN(actname).Type).equals("Leaving early pay more")){
				temp=((Double.parseDouble(act.Sum))/(Leavenumber*Percent*0.01+Integer.parseInt(act.Number)));
				//extra=(1+percent*0.01)*e.average;
			}
		    average=temp;
			//g.ave=temp;
			//g.girls=girls;
			//e.average=temp3;
			//e.extra=extra;
			return act.Type;	
		}catch (Exception e) {
	return ERROR;
	}
}
}
