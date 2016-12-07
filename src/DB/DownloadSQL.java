package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Activity;
import model.AutoActivity;
import model.Participant;
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
	
	
	public AutoActivity getActivity(String Act_name){
		 connection.ConnectDataBase();
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 String SEARCH_SQL = "SELECT Sum,Type from"+ Act_name +"WHERE IsCreate = Yes";

		try {
			AutoActivity act=new AutoActivity();
			pst = connection.connect.prepareStatement(SEARCH_SQL);

			pst.setString(1, Act_name);

			rs = pst.executeQuery();
			

			while (rs.next()) {
				//act.setUserEmail(Act_name);
				//acty.setNumber(rs.getString("Number"));
				act.setSum(rs.getString("Sum"));
				act.setType(rs.getString("Type"));
			}
			pst.close();
	        return act;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
	
	
	
		
	
	public AutoActivity getActivityNumber(String Act_name){
		 connection.ConnectDataBase();
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 String SEARCH_SQL = "SELECT count(userName) from"+ Act_name;

		try {
			AutoActivity act=new AutoActivity();
			pst = connection.connect.prepareStatement(SEARCH_SQL);

			pst.setString(1, Act_name);

			rs = pst.executeQuery();
			

			while (rs.next()) {
				//act.setUserEmail(Act_name);
				//acty.setNumber(rs.getString("Number"));
				act.setNumber(rs.getString("count(userName)"));
			}
			pst.close();
	        return act;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
	
	
	public AutoActivity getActivityFemale(String Act_name){
		 connection.ConnectDataBase();
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 String SEARCH_SQL = "SELECT count(*),userSex from"+ Act_name+"group by userSex having userSex=Femal ";

		try {
			AutoActivity act=new AutoActivity();
			pst = connection.connect.prepareStatement(SEARCH_SQL);

			pst.setString(1, Act_name);

			rs = pst.executeQuery();
			

			while (rs.next()) {
				//act.setUserEmail(Act_name);
				//acty.setNumber(rs.getString("Number"));
				act.setFemale(rs.getString("count(*)"));
			}
			pst.close();
	        return act;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
	public AutoActivity getActivityLeaving(String Act_name){
		 connection.ConnectDataBase();
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 String SEARCH_SQL = "SELECT count(*),leaveEarly from"+ Act_name+"group by leaveEarly having leaveEarly=Yes ";

		try {
			AutoActivity act=new AutoActivity();
			pst = connection.connect.prepareStatement(SEARCH_SQL);

			pst.setString(1, Act_name);

			rs = pst.executeQuery();
			

			while (rs.next()) {
				//act.setUserEmail(Act_name);
				//acty.setNumber(rs.getString("Number"));
				act.setLeavepeople(rs.getString("count(*)"));
			}
			pst.close();
	        return act;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
	
	
	public AutoActivity getActivityPercent(String Act_name){
		 connection.ConnectDataBase();
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 String SEARCH_SQL = "SELECT payMorePercentage from"+ Act_name+"where IsCreater=Yes";

		try {
			AutoActivity act=new AutoActivity();
			pst = connection.connect.prepareStatement(SEARCH_SQL);

			pst.setString(1, Act_name);

			rs = pst.executeQuery();
			

			while (rs.next()) {
				//act.setUserEmail(Act_name);
				//acty.setNumber(rs.getString("Number"));
				act.setPercent(rs.getString("payMorePercentage"));
			}
			pst.close();
	        return act;
		    } 
		    catch (SQLException e) {
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
				acty.setAct_name(Act_name);
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
	
	
	
	
	
	
	
	public ArrayList<Participant> getAllParticipant()
	{
		connection.ConnectDataBase();
		PreparedStatement pst3 = null;
		ResultSet rs3 = null;
		String SEARCH_SQL3 = "SELECT userName,userEmail,userSex,IsCreater  FROM act18";

		try {
			ArrayList<Participant> Participantlist = new ArrayList<Participant>();
			pst3 = connection.connect.prepareStatement(SEARCH_SQL3);
			rs3 = pst3.executeQuery();
			while (rs3.next()) {
				Participant com  = new Participant();
				
				com.setUserName(rs3.getString("userName"));
				com.setUserEmail(rs3.getString("userEmail"));
				com.setUserSex(rs3.getString("userSex"));
				com.setIsCreater(rs3.getString("IsCreater"));
				
				Participantlist.add(com);
			}
			pst3.close();	
			return Participantlist;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
	
	
	public ArrayList<user> getUsersByName(String userName){
		connection.ConnectDataBase();
		PreparedStatement pst4 = null;
		ResultSet rs4 = null;
		String SEARCH_SQL4 = "SELECT userEmail,userName,userSex FROM user WHERE userName = ?";

		try {
			ArrayList<user> userlist4 = new ArrayList<user>();
			pst4 = connection.connect.prepareStatement(SEARCH_SQL4);
			pst4.setString(1, userName);
			rs4 = pst4.executeQuery();
			while (rs4.next()) {
				user com4  = new user();
				
				com4.setUserEmail(rs4.getString("userEmail"));
				com4.setUserName(rs4.getString("userName"));
				com4.setUserSex(rs4.getString("userSex"));
				userlist4.add(com4);
			}
			pst4.close();	
			return userlist4;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
}
