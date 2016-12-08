package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Activity;
import model.Participant;
import model.user;
import model.activityone;



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
	
	
	public ArrayList<Participant> getAllParticipant()
	{
		connection.ConnectDataBase();
		PreparedStatement pst3 = null;
		ResultSet rs3 = null;
		String SEARCH_SQL3 = "SELECT * FROM act18";

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
				com.setLeaveEarly(rs3.getString("leaveEarly"));
				com.setPayMorePercentage(rs3.getString("payMorePercentage"));
				com.setMoneyShouldPay(rs3.getString("moneyShouldPay"));
				com.setSum(rs3.getString("Sum"));
				com.setType(rs3.getString("Type"));
				com.setVoteResult(rs3.getString("VoteResult"));
				
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
	
	
	
	
	public ArrayList<activityone> getAllVoteBeforeActivitys()
	{
		connection.ConnectDataBase();
		PreparedStatement pst5 = null;
		ResultSet rs5 = null;
		String SEARCH_SQL5 = "SELECT * FROM activity WHERE IsVote = ? && IsCreater = ? && BeforeOrAfter = ?";
		try {
			ArrayList<activityone> activityonelist5 = new ArrayList<activityone>();
			pst5 = connection.connect.prepareStatement(SEARCH_SQL5);
			pst5.setString(1, "Yes");
			pst5.setString(2, "Yes");
			pst5.setString(3, "Before");
			rs5 = pst5.executeQuery();
			while (rs5.next()) {
				activityone com5  = new activityone();
				
				com5.setOwner(rs5.getString("Owner"));
				com5.setAct_name(rs5.getString("Act_name"));
				com5.setNumber(rs5.getString("Number"));
				com5.setSum(rs5.getString("Sum"));
				com5.setType(rs5.getString("Type"));
				com5.setIsVote(rs5.getString("IsVote"));
				com5.setIsCreater(rs5.getString("IsCreater"));
				com5.setBeforeOrAfter(rs5.getString("BeforeOrAfter"));
				
				activityonelist5.add(com5);
			}
			pst5.close();	
			return activityonelist5;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
	
	
	public ArrayList<activityone> getAllNoVoteBeforeActivitys()
	{
		connection.ConnectDataBase();
		PreparedStatement pst6 = null;
		ResultSet rs6 = null;
		String SEARCH_SQL6 = "SELECT * FROM activity WHERE IsVote = ? && IsCreater = ? && BeforeOrAfter = ?";
		try {
			ArrayList<activityone> activityonelist6 = new ArrayList<activityone>();
			pst6 = connection.connect.prepareStatement(SEARCH_SQL6);
			pst6.setString(1, "No");
			pst6.setString(2, "Yes");
			pst6.setString(3, "Before");
			rs6 = pst6.executeQuery();
			while (rs6.next()) {
				activityone com6  = new activityone();
				
				com6.setOwner(rs6.getString("Owner"));
				com6.setAct_name(rs6.getString("Act_name"));
				com6.setNumber(rs6.getString("Number"));
				com6.setSum(rs6.getString("Sum"));
				com6.setType(rs6.getString("Type"));
				com6.setIsVote(rs6.getString("IsVote"));
				com6.setIsCreater(rs6.getString("IsCreater"));
				com6.setBeforeOrAfter(rs6.getString("BeforeOrAfter"));
				
				activityonelist6.add(com6);
			}
			pst6.close();	
			return activityonelist6;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
}
