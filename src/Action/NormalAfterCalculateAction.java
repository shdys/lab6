package Action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import db.DownloadSQL;
import db.UploadSQL;
import model.user;

public class NormalAfterCalculateAction extends ActionSupport{
	public float SumPrice;
	public int SumPeopleNumber;
	public float Avg_Price;
	
	
	
	

	public float getSumPrice() {
		return SumPrice;
	}





	public void setSumPrice(float sumPrice) {
		SumPrice = sumPrice;
	}










	public int getSumPeopleNumber() {
		return SumPeopleNumber;
	}





	public void setSumPeopleNumber(int sumPeopleNumber) {
		SumPeopleNumber = sumPeopleNumber;
	}





	public float getAvg_Price() {
		return Avg_Price;
	}





	public void setAvg_Price(float avg_Price) {
		Avg_Price = avg_Price;
	}





	@Override
	public String execute(){
		try{
			setAvg_Price(getSumPrice() / getSumPeopleNumber());
			
			return SUCCESS;
			
		}catch(Exception e){
			return ERROR;
		}
		
	}

}
