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

import model.AutoActivity;






public class AutoCalculation extends ActionSupport{
	public AutoActivity act;
	public double average,girls,extra;
    public String name;
    public double temp;
    //public int Female;
    //public double Percent;
    //public int Leavenumber;

  
		
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AutoActivity getAct() {
		return act;
	}

	public void setAct(AutoActivity act) {
		this.act = act;
	}

	public double getAverage() {
		return average;
	}


	public void setAverage(double average) {
		this.average = average;
	}

	
	/*public int getFemale() {
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
	}*/
	
	HttpServletRequest request=ServletActionContext.getRequest();
	HttpSession session= request.getSession();
	String actname = (String)session.getAttribute("actname");
	public String execute(){

		try{
			DownloadSQL down = new DownloadSQL();
			setAct(down.getActivity(actname));
			if ((down.getActivity(actname).Type).equals("Normal")){
				setAct(down.getActivityNumber(actname));
				temp=(Double.parseDouble(act.Sum))/(Integer.parseInt(act.Number));
			}
			else if((down.getActivitySandN(actname).Type).equals("Girls for free")){
				setAct(down.getActivityFemale(actname));
				temp=(Double.parseDouble(act.Sum))/(Integer.parseInt(act.Number)-Integer.parseInt(act.Female));
			    girls=0;
			}
			else if((down.getActivitySandN(actname).Type).equals("Leaving early pay more")){
				setAct(down.getActivityLeaving(actname));
				setAct(down.getActivityPercent(actname));
				temp=((Double.parseDouble(act.Sum))/(Integer.parseInt(act.leavepeople)*Integer.parseInt(act.percent)*0.01+Integer.parseInt(act.Number)));
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
