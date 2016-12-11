package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import db.UploadSQL;
import model.user;
import model.Participant;

public class NormalVoteHandleAction extends ActionSupport{
	public String Act_name;
	public int Total_num;
	public float Sum_money;
	public float Average_money;
	
	
	
	
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




	public float getSum_money() {
		return Sum_money;
	}




	public void setSum_money(float sum_money) {
		Sum_money = sum_money;
	}




	public float getAverage_money() {
		return Average_money;
	}




	public void setAverage_money(float average_money) {
		Average_money = average_money;
	}




	@Override
	public String execute(){
		try{
			DownloadSQL down11 = new DownloadSQL();
			UploadSQL up11 = new UploadSQL();
			
			setAct_name(down11.getACTNMFromTPDDT4());
			setTotal_num(down11.getTotalPeopleNum(getAct_name()));
			setAverage_money(getSum_money()/getTotal_num());
			
			up11.AddNumberToActivityTable(getTotal_num(),getAct_name());
			up11.AddSumToVoteActivity(getSum_money(),getAct_name());
			up11.AddSumToActivityTable(getSum_money(),getAct_name());
			up11.NormalSetAVGMoney(getAverage_money(),getAct_name());
			
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
		
	}
}
