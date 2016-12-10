package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import db.UploadSQL;
import model.user;
import model.Participant;

public class LeaveVoteHandleAction extends ActionSupport{
	public String Act_name;
	public int Total_num;
	public int NotLeave_num;
	public float Sum_money;
	public double Leave_Average_money;
	public double NotLeave_Average_money;
	public float payMorePercentage;
	
	
	public double getLeave_Average_money() {
		return Leave_Average_money;
	}
	public void setLeave_Average_money(double leave_Average_money) {
		Leave_Average_money = leave_Average_money;
	}
	public double getNotLeave_Average_money() {
		return NotLeave_Average_money;
	}
	public void setNotLeave_Average_money(double notLeave_Average_money) {
		NotLeave_Average_money = notLeave_Average_money;
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
	public int getNotLeave_num() {
		return NotLeave_num;
	}
	public void setNotLeave_num(int notLeave_num) {
		NotLeave_num = notLeave_num;
	}
	public float getSum_money() {
		return Sum_money;
	}
	public void setSum_money(float sum_money) {
		Sum_money = sum_money;
	}
	
	public float getPayMorePercentage() {
		return payMorePercentage;
	}
	public void setPayMorePercentage(float payMorePercentage) {
		this.payMorePercentage = payMorePercentage;
	}
	
	
	@Override
	public String execute(){
		try{
			DownloadSQL down13 = new DownloadSQL();
			UploadSQL up13 = new UploadSQL();
			
			setAct_name(down13.getACTNMFromTPDDT4());
			setTotal_num(down13.getTotalPeopleNum(getAct_name()));
			setNotLeave_num(down13.getTotalNotLeaveNum(getAct_name()));
			
			setNotLeave_Average_money( getSum_money() / ( getNotLeave_num() + ( getTotal_num()-getNotLeave_num() ) * ( 1+0.01*getPayMorePercentage() )  ));
			
			setLeave_Average_money((1 + 0.01 * getPayMorePercentage())* getNotLeave_Average_money());
			up13.AddPayMorePercentageToActivityTable(getPayMorePercentage(),getAct_name());
			up13.AddNumberToActivityTable(getTotal_num(),getAct_name());
			up13.AddSumToVoteActivity(getSum_money(),getAct_name());
			up13.AddSumToActivityTable(getSum_money(),getAct_name());
			
			
			up13.LeaveSetNotLeaveAVGMoney(getAct_name(),getNotLeave_Average_money());

			up13.LeaveSetLeaveAVGMoney(getAct_name(),getLeave_Average_money());
			return SUCCESS;
		}catch(Exception e){
			return ERROR;
		}
		
	}
}
