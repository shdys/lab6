package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import db.UploadSQL;
import model.user;

public class LeaveAfterCalculateAction extends ActionSupport{
	public double SumPrice;
	public int SumPeopleNumber;
	public int SumLeavingPeopleNumber;
	public double PayMorePercentage;
	public double NotLeave_Average_money;
	public double Leave_Average_money;

	
	public double getNotLeave_Average_money() {
		return NotLeave_Average_money;
	}


	public void setNotLeave_Average_money(double notLeave_Average_money) {
		NotLeave_Average_money = notLeave_Average_money;
	}


	public double getLeave_Average_money() {
		return Leave_Average_money;
	}


	public void setLeave_Average_money(double leave_Average_money) {
		Leave_Average_money = leave_Average_money;
	}


	public double getSumPrice() {
		return SumPrice;
	}

	
	public void setSumPrice(double sumPrice) {
		SumPrice = sumPrice;
	}


	public int getSumPeopleNumber() {
		return SumPeopleNumber;
	}


	public void setSumPeopleNumber(int sumPeopleNumber) {
		SumPeopleNumber = sumPeopleNumber;
	}


	public int getSumLeavingPeopleNumber() {
		return SumLeavingPeopleNumber;
	}


	public void setSumLeavingPeopleNumber(int sumLeavingPeopleNumber) {
		SumLeavingPeopleNumber = sumLeavingPeopleNumber;
	}


	public double getPayMorePercentage() {
		return PayMorePercentage;
	}


	public void setPayMorePercentage(double payMorePercentage) {
		PayMorePercentage = payMorePercentage;
	}



	@Override
	public String execute(){
		try{
			setNotLeave_Average_money( getSumPrice() / ( getSumPeopleNumber() - getSumLeavingPeopleNumber() + ( getSumLeavingPeopleNumber() ) * ( 1+0.01*getPayMorePercentage() )  ));
			setLeave_Average_money(getNotLeave_Average_money() * (1 + 0.01*getPayMorePercentage()));
			
			
			
			return SUCCESS;
			
		}catch(Exception e){
			return ERROR;
		}
		
	}

}
