package Action;

import com.opensymphony.xwork2.ActionSupport;

public class calculation extends ActionSupport{
	private static final String SUCEESS = null;
	private static String data=null;
	
       public static String getData() {
		return data;
	}

	public String execute(){ 
		   data="12";
    	   return SUCCESS;
       }
}
