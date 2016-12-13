package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import db.UploadSQL;
import model.user;

public class GirlsAfterCalculateAction extends ActionSupport{
	public float SumPrice;
	public int MalePeopleNumber;
	public float MalePayMoney;
	
	
	public float getSumPrice() {
		return SumPrice;
	}


	public void setSumPrice(float sumPrice) {
		SumPrice = sumPrice;
	}


	public int getMalePeopleNumber() {
		return MalePeopleNumber;
	}


	public void setMalePeopleNumber(int malePeopleNumber) {
		MalePeopleNumber = malePeopleNumber;
	}


	public float getMalePayMoney() {
		return MalePayMoney;
	}


	public void setMalePayMoney(float malePayMoney) {
		MalePayMoney = malePayMoney;
	}


	@Override
	public String execute(){
		try{
			setMalePayMoney(getSumPrice() / getMalePeopleNumber());
			
			return SUCCESS;
			
		}catch(Exception e){
			return ERROR;
		}
		
	}

}
