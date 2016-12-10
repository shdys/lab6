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
	
	
	public ArrayList<Participant> getAllParticipant(String getVoteACTName)
	{
		connection.ConnectDataBase();
		PreparedStatement pst3 = null;
		ResultSet rs3 = null;
		String SEARCH_SQL3 = "SELECT * FROM " + getVoteACTName;

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
	
	
	
	
	public ArrayList<activityone> getAllSelfCreateActivitys(String getUserEmail){
		connection.ConnectDataBase();
		PreparedStatement pst7 = null;
		ResultSet rs7 = null;
		String SEARCH_SQL7 = "SELECT Act_name FROM activity WHERE Owner = ?";

		try {
			ArrayList<activityone> activitylist7 = new ArrayList<activityone>();
			pst7 = connection.connect.prepareStatement(SEARCH_SQL7);
			pst7.setString(1, getUserEmail);
			rs7 = pst7.executeQuery();
			while (rs7.next()) {
				activityone com7 = new activityone();
				
				com7.setAct_name(rs7.getString("Act_name"));
				activitylist7.add(com7);
			}
			pst7.close();	
			return activitylist7;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
	
	public String getVoteACTName()
	{
		connection.ConnectDataBase();
		PreparedStatement pst8 = null;
		ResultSet rs8 = null;
		String SEARCH_SQL8 = "SELECT * FROM temporarydata WHERE StartPage = ? && EndPage = ?";

		try {
			String ResultString = null;
			pst8 = connection.connect.prepareStatement(SEARCH_SQL8);
			pst8.setString(1, "DravenTest1");
			pst8.setString(2, "CreatVoteSuccess");
			rs8 = pst8.executeQuery();
			
			while (rs8.next()) {
				String com8;
				com8=rs8.getString("Information2");
				ResultString = com8;
			}
			pst8.close();	
			return ResultString;
					
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
	
	public String getVoteACTCreaterEmail()
	{
		connection.ConnectDataBase();
		PreparedStatement pst9 = null;
		ResultSet rs9 = null;
		String SEARCH_SQL9 = "SELECT * FROM temporarydata WHERE StartPage = ? && EndPage = ?";

		try {
			String ResultString = null;
			pst9 = connection.connect.prepareStatement(SEARCH_SQL9);
			pst9.setString(1, "DravenTest1");
			pst9.setString(2, "CreatVoteSuccess");
			rs9 = pst9.executeQuery();
			
			while (rs9.next()) {
				String com9;
				com9 = rs9.getString("Information1");
				ResultString = com9;
			}
			pst9.close();	
			return ResultString;
					
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
	
	public activityone getActivityDetailByACTNMAndEM(String getAct_name,String getEmail){
		connection.ConnectDataBase();
		PreparedStatement pst10 = null;
		ResultSet rs10 = null;
		String SEARCH_SQL10 = "SELECT * FROM activity WHERE Act_name = ? && Owner = ?";

		try {
			activityone ActivityDetailResult = new activityone();
			pst10 = connection.connect.prepareStatement(SEARCH_SQL10);
			pst10.setString(1, getAct_name);
			pst10.setString(2, getEmail);
			rs10 = pst10.executeQuery();
			while (rs10.next()) {
				
				ActivityDetailResult.setOwner(rs10.getString("Owner"));
				ActivityDetailResult.setAct_name(rs10.getString("Act_Name"));
				ActivityDetailResult.setNumber(rs10.getString("Number"));
				ActivityDetailResult.setSum(rs10.getString("Sum"));
				ActivityDetailResult.setType(rs10.getString("Type"));
				ActivityDetailResult.setIsVote(rs10.getString("IsVote"));
				ActivityDetailResult.setIsCreater(rs10.getString("IsCreater"));
				ActivityDetailResult.setBeforeOrAfter(rs10.getString("BeforeOrAfter"));
				
				
			}
			pst10.close();	
			return ActivityDetailResult;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
	
	
	
	
	public String getVoteCreaterBOA(String getAct_name){
		connection.ConnectDataBase();
		PreparedStatement pst11 = null;
		ResultSet rs11 = null;
		String SEARCH_SQL11 = "SELECT * FROM activity WHERE Act_name = ? && IsCreater = ?";

		try {
			activityone ActivityDetailResult11 = new activityone();
			pst11 = connection.connect.prepareStatement(SEARCH_SQL11);
			pst11.setString(1, getAct_name);
			pst11.setString(2, "Yes");
			rs11 = pst11.executeQuery();
			while (rs11.next()) {
				
				ActivityDetailResult11.setOwner(rs11.getString("Owner"));
				ActivityDetailResult11.setAct_name(rs11.getString("Act_Name"));
				ActivityDetailResult11.setNumber(rs11.getString("Number"));
				ActivityDetailResult11.setSum(rs11.getString("Sum"));
				ActivityDetailResult11.setType(rs11.getString("Type"));
				ActivityDetailResult11.setIsVote(rs11.getString("IsVote"));
				ActivityDetailResult11.setIsCreater(rs11.getString("IsCreater"));
				ActivityDetailResult11.setBeforeOrAfter(rs11.getString("BeforeOrAfter"));
				
				
			}
			pst11.close();	
			return ActivityDetailResult11.BeforeOrAfter;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
	
	public String getACTNMFromTPDDT4()
	{
		connection.ConnectDataBase();
		PreparedStatement pst12 = null;
		ResultSet rs12 = null;
		String SEARCH_SQL12 = "SELECT * FROM temporarydata WHERE StartPage = ? && EndPage = ?";

		try {
			String ResultString12 = null;
			pst12 = connection.connect.prepareStatement(SEARCH_SQL12);
			pst12.setString(1, "DravenTest4");
			pst12.setString(2, "SelfParticipantVoteACTDetail");
			rs12 = pst12.executeQuery();
			
			while (rs12.next()) {
				String com12;
				com12=rs12.getString("Information2");
				ResultString12 = com12;
			}
			pst12.close();	
			return ResultString12;
					
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
	
	
	public String getEMFromTPDT4()
	{
		connection.ConnectDataBase();
		PreparedStatement pst13 = null;
		ResultSet rs13 = null;
		String SEARCH_SQL13 = "SELECT * FROM temporarydata WHERE StartPage = ? && EndPage = ?";

		try {
			String ResultString13 = null;
			pst13 = connection.connect.prepareStatement(SEARCH_SQL13);
			pst13.setString(1, "DravenTest4");
			pst13.setString(2, "SelfParticipantVoteACTDetail");
			rs13 = pst13.executeQuery();
			
			while (rs13.next()) {
				String com13;
				com13 = rs13.getString("Information1");
				ResultString13 = com13;
			}
			pst13.close();	
			return ResultString13;
					
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
	public int getVoteACTNormalNum(String getAct_name)
	{
		connection.ConnectDataBase();
		PreparedStatement pst14 = null;
		ResultSet rs14 = null;
		String SEARCH_SQL14 = "SELECT * FROM " + getAct_name + " WHERE VoteResult = ? ";
		try {
			int NormalNum = 0;
			pst14 = connection.connect.prepareStatement(SEARCH_SQL14);
			pst14.setString(1, "Normal");
			rs14 = pst14.executeQuery();
			while (rs14.next()) {
				NormalNum += 1;
			}
			pst14.close();	
			return NormalNum;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return 0;
		    }
	}
	
	
	public int getVoteACTLeaveNum(String getAct_name)
	{
		connection.ConnectDataBase();
		PreparedStatement pst15 = null;
		ResultSet rs15 = null;
		String SEARCH_SQL15 = "SELECT * FROM " + getAct_name + " WHERE VoteResult = ? ";
		try {
			int LeaveNum = 0;
			pst15 = connection.connect.prepareStatement(SEARCH_SQL15);
			pst15.setString(1, "Leave");
			rs15 = pst15.executeQuery();
			while (rs15.next()) {
				LeaveNum += 1;
			}
			pst15.close();	
			return LeaveNum;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return 0;
		    }
	}
	
	
	public int getVoteACTGirlsNum(String getAct_name)
	{
		connection.ConnectDataBase();
		PreparedStatement pst16 = null;
		ResultSet rs16 = null;
		String SEARCH_SQL16 = "SELECT * FROM " + getAct_name + " WHERE VoteResult = ? ";
		try {
			int GirlsNum = 0;
			pst16 = connection.connect.prepareStatement(SEARCH_SQL16);
			pst16.setString(1, "Girls");
			rs16 = pst16.executeQuery();
			while (rs16.next()) {
				GirlsNum += 1;
			}
			pst16.close();	
			return GirlsNum;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return 0;
		    }
	}
	
	
	
	
	
	public int getTotalPeopleNum(String getAct_name)
	{
		connection.ConnectDataBase();
		PreparedStatement pst17 = null;
		ResultSet rs17 = null;
		String SEARCH_SQL17 = "SELECT * FROM " + getAct_name ;
		try {
			int TotalPeopleNum = 0;
			pst17 = connection.connect.prepareStatement(SEARCH_SQL17);
			rs17 = pst17.executeQuery();
			while (rs17.next()) {
				TotalPeopleNum += 1;
			}
			pst17.close();	
			return TotalPeopleNum;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return 0;
		    }
	}
	
	
	
	
	
	
	public int getTotalBoyNum(String getAct_name)
	{
		connection.ConnectDataBase();
		PreparedStatement pst18 = null;
		ResultSet rs18 = null;
		String SEARCH_SQL18 = "SELECT * FROM " + getAct_name + " WHERE userSex = ? ";
		try {
			int TotalBoyNum = 0;
			pst18 = connection.connect.prepareStatement(SEARCH_SQL18);
			pst18.setString(1, "male");
			rs18 = pst18.executeQuery();
			while (rs18.next()) {
				TotalBoyNum += 1;
			}
			pst18.close();	
			return TotalBoyNum;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return 0;
		    }
	}
	
	
	
	
	public int getTotalNotLeaveNum(String getAct_name)
	{
		connection.ConnectDataBase();
		PreparedStatement pst19 = null;
		ResultSet rs19 = null;
		String SEARCH_SQL19 = "SELECT * FROM " + getAct_name + " WHERE leaveEarly = ? ";
		try {
			int TotalNotLeaveNum = 0;
			pst19 = connection.connect.prepareStatement(SEARCH_SQL19);
			pst19.setString(1, "No");
			rs19 = pst19.executeQuery();
			while (rs19.next()) {
				TotalNotLeaveNum += 1;
			}
			pst19.close();	
			return TotalNotLeaveNum;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return 0;
		    }
	}
}
