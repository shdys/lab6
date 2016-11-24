package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Activity;
import model.user;



public class DownloadSQL {
	static DataBaseConnector connection = new DataBaseConnector();
	
	
	public user getUserByEmail(String userEmail)
	{
		connection.ConnectDataBase();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String SEARCH_SQL = "SELECT userEmail,userPassword,userName,userSex FROM user  WHERE userEmail = ?";
		try{
			user resultuser = new user();
			
			resultuser.setUserEmail("yhb1209081670@outlook.com");
			resultuser.setUserName("NicholasDraven");
			resultuser.setUserPassword("k780si7d3");
			resultuser.setUserSex("man");
			
			
			pst = connection.connect.prepareStatement(SEARCH_SQL);
			pst.setString(1, userEmail);
			rs = pst.executeQuery();
			while(rs.next()){
				resultuser.setUserEmail(rs.getString("userEmail"));
				resultuser.setUserName(rs.getString("userName"));
				resultuser.setUserPassword(rs.getString("userPassword"));
				resultuser.setUserSex(rs.getString("userSex"));
			}
			pst.close();
			return resultuser;
		}
		catch (SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	public Activity getActivitySandN(String Act_name){
		 connection.ConnectDataBase();
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 String SEARCH_SQL = "SELECT Number,Sum,Type from activity WHERE Act_name = ?";

		try {
			Activity acty=new Activity();
			pst = connection.connect.prepareStatement(SEARCH_SQL);

			pst.setString(1, Act_name);

			rs = pst.executeQuery();
			

			while (rs.next()) {
				acty.setUserEmail(Act_name);
				acty.setNumber(rs.getString("Number"));
				acty.setSum(rs.getString("Sum"));
				acty.setType(rs.getString("Type"));
			}
			pst.close();
	        return acty;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
}
