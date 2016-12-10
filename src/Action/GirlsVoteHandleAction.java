package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import db.UploadSQL;
import model.user;
import model.Participant;

public class GirlsVoteHandleAction extends ActionSupport{
	public String Act_name;
	public int Total_num;
	public int Boy_num;
	public float Sum_money;
	public float Boy_Average_money;
	public float Girl_Average_money;
	
	public float getGirl_Average_money() {
		return Girl_Average_money;
	}
	public void setGirl_Average_money(float girl_Average_money) {
		Girl_Average_money = girl_Average_money;
	}
	public String getAct_name() {
		return Act_name;
	}
	public void setAct_name(String act_name) {
		Act_name = act_name;
	}
	public int getTotal_num() {
		return Total_num;
	}
	public void setTotal_num(int total_num) {
		Total_num = total_num;
	}
	public int getBoy_num() {
		return Boy_num;
	}
	public void setBoy_num(int boy_num) {
		Boy_num = boy_num;
	}
	public float getSum_money() {
		return Sum_money;
	}
	public void setSum_money(float sum_money) {
		Sum_money = sum_money;
	}
	public float getBoy_Average_money() {
		return Boy_Average_money;
	}
	public void setBoy_Average_money(float boy_Average_money) {
		Boy_Average_money = boy_Average_money;
	}
	
	@Override
	public String execute(){
		try{
			DownloadSQL down12 = new DownloadSQL();
			UploadSQL up12 = new UploadSQL();
			
			setAct_name(down12.getACTNMFromTPDDT4());
			setTotal_num(down12.getTotalPeopleNum(getAct_name()));
			setBoy_num(down12.getTotalBoyNum(getAct_name()));
			setBoy_Average_money(getSum_money()/getBoy_num());
			setGirl_Average_money(0);
			
			up12.AddNumberToActivityTable(getTotal_num(),getAct_name());
			up12.AddSumToVoteActivity(getSum_money(),getAct_name());
			up12.AddSumToActivityTable(getSum_money(),getAct_name());
			up12.GirlsSetGirlsAVGMoney(getAct_name());
			up12.GirlsSetBoysAVGMoney(getBoy_Average_money(),getAct_name());
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
		
	}
}
