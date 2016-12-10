package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.user;

public class UploadSQL {
	static DataBaseConnector connection = new DataBaseConnector();
	
	
	public boolean setNewUser(String userEmail,String userPassword,String userName,String userSex){
		connection.ConnectDataBase();
		PreparedStatement pst = null;
		String INSERT_SQL = "INSERT INTO user(userEmail,userPassword,userName,userSex) VALUES(?,?,?,?)";		
		boolean flag = false;
        try {
			pst = connection.connect.prepareStatement(INSERT_SQL);
			pst.setString(1, userEmail);
			pst.setString(2, userPassword);
			pst.setString(3, userName);
			pst.setString(4, userSex);
			
			/////////////////////////////////////
			int i = pst.executeUpdate();
			/////////////////////////////////////
			
			if (i == 1) {
				flag = true;
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public boolean creatNewVoteActivityName(String UserEmail,String getVoteActivityName,String getBeforeOrAfter){
		connection.ConnectDataBase();
		PreparedStatement pst2 = null;
		String INSERT_SQL2 = "INSERT INTO activity(Owner,Act_name,IsVote,IsCreater,BeforeOrAfter) VALUES(?,?,?,?,?)";
		boolean flag2 = false;
		try {
			pst2 = connection.connect.prepareStatement(INSERT_SQL2);
			pst2.setString(1, UserEmail);
			pst2.setString(2, getVoteActivityName);
			pst2.setString(3, "Yes");
			pst2.setString(4, "Yes");
			pst2.setString(5, getBeforeOrAfter);
			int vary2 = pst2.executeUpdate();
			if(vary2 == 1){
				flag2 = true;
			}
			pst2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag2;
	}
	

	
	
	
	public boolean ceratVoteActivityTable(String UserEmail,String getVoteActivityName)
	{
		connection.ConnectDataBase();
		PreparedStatement pst3 = null;
		String INSERT_SQL3 = "create table "+getVoteActivityName+" (userName VARCHAR(255),userEmail VARCHAR(255),userSex VARCHAR(255),leaveEarly VARCHAR(255),payMorePercentage VARCHAR(255),moneyShouldPay VARCHAR(255),Sum VARCHAR(255),Type VARCHAR(255),IsCreater VARCHAR(255),VoteResult VARCHAR(255),PRIMARY KEY ( userEmail ));";
		boolean flag3 = false;
		try {
			pst3 = connection.connect.prepareStatement(INSERT_SQL3);
			int vary3 = pst3.executeUpdate();
			if(vary3 == 1){
				flag3 = true;
			}
			pst3.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag3;
	}
	
	
	
	
	public boolean ceratVoteActivityTableInit(user UserVary,String getVoteActivityName)
	{
		connection.ConnectDataBase();
		PreparedStatement pst4 = null;
		String INSERT_SQL4 = "INSERT INTO "+getVoteActivityName+" (userName,userEmail,userSex,IsCreater) VALUES(?,?,?,?)";
		boolean flag4 = false;
		try {
			pst4 = connection.connect.prepareStatement(INSERT_SQL4);
			pst4.setString(1, UserVary.userName);
			pst4.setString(2, UserVary.userEmail);
			pst4.setString(3, UserVary.userSex);
			pst4.setString(4, "Yes");
			int vary4 = pst4.executeUpdate();
			if(vary4 == 1){
				flag4 = true;
			}
			pst4.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag4;
	}
	

	
	
	public boolean addThisUserToParticipants(user uservary,String getVoteACTName)
	{
		connection.ConnectDataBase();
		PreparedStatement pst5 = null;
		String INSERT_SQL5 = "INSERT INTO " + getVoteACTName + " (userName,userEmail,userSex,IsCreater) VALUES(?,?,?,?)";
		boolean flag5 = false;
		try {
			pst5 = connection.connect.prepareStatement(INSERT_SQL5);
			pst5.setString(1, uservary.userName);
			pst5.setString(2, uservary.userEmail);
			pst5.setString(3, uservary.userSex);
			pst5.setString(4, "No");
			int vary5 = pst5.executeUpdate();
			if(vary5 == 1){
				flag5 = true;
			}
			pst5.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag5;
	}
	
	
	
	
	
	public boolean addParticipantToVoteActivity(String UserEmail,String getVoteACTName,String getBeforeOrAfter)
	{
		connection.ConnectDataBase();
		PreparedStatement pst6 = null;
		String INSERT_SQL6 = "INSERT INTO activity(Owner,Act_name,IsVote,IsCreater,BeforeOrAfter) VALUES(?,?,?,?,?)";
		boolean flag6 = false;
		try {
			pst6 = connection.connect.prepareStatement(INSERT_SQL6);
			pst6.setString(1, UserEmail);
			pst6.setString(2, getVoteACTName);
			pst6.setString(3, "Yes");
			pst6.setString(4, "No");
			pst6.setString(5, getBeforeOrAfter);
			int vary6 = pst6.executeUpdate();
			if(vary6 == 1){
				flag6 = true;
			}
			pst6.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag6;
	}
	
	
	
	
	public boolean inputVoteResult(String UserEmail,String VoteActivityName,String Type)
	{
		connection.ConnectDataBase();
		PreparedStatement pst7 = null;
		String INSERT_SQL7 = "update "+VoteActivityName+" set VoteResult = ? where userEmail = ?";
		boolean flag7 = false;
		try {
			pst7 = connection.connect.prepareStatement(INSERT_SQL7);
			pst7.setString(1, Type);
			pst7.setString(2, UserEmail);
			int vary7 = pst7.executeUpdate();
			if(vary7 == 1){
				flag7 = true;
			}
			pst7.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag7;
	}
	
	
	public boolean AddActNameToTMPDDT1(String getUserEmail,String getVoteActivityName)
	{
		connection.ConnectDataBase();
		PreparedStatement pst8 = null;
		String INSERT_SQL8 = "update temporarydata set information1 = ? , information2 = ? where startPage = ? && EndPage = ?";
		//String INSERT_SQL8 = "update temporarydata set information1 = ?  where  endPage = ?";
		boolean flag8 = false;
		try {
			pst8 = connection.connect.prepareStatement(INSERT_SQL8);
			pst8.setString(1, getUserEmail);
			pst8.setString(2, getVoteActivityName);
			pst8.setString(3, "DravenTest1");
			pst8.setString(4, "CreatVoteSuccess");
			
			int vary8 = pst8.executeUpdate();
			if(vary8 == 1){
				flag8 = true;
			}
			pst8.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag8;
	}
	
	
	
	
	
	public boolean AddEmailToTMPDDT4(String getUserEmail)
	{
		connection.ConnectDataBase();
		PreparedStatement pst9 = null;
		String INSERT_SQL9 = "update temporarydata set information1 = ? where startPage = ? && EndPage = ?";
		boolean flag9 = false;
		try {
			pst9 = connection.connect.prepareStatement(INSERT_SQL9);
			pst9.setString(1, getUserEmail);
			pst9.setString(2, "DravenTest4");
			pst9.setString(3, "SelfParticipantVoteACTDetail");
			
			int vary9 = pst9.executeUpdate();
			if(vary9 == 1){
				flag9 = true;
			}
			pst9.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag9;
	}
	
	
	
	
	
	public boolean AddActnameToTMPDDT4(String getAct_name)
	{
		connection.ConnectDataBase();
		PreparedStatement pst10 = null;
		String INSERT_SQL10 = "update temporarydata set information2 = ? where startPage = ? && EndPage = ?";
		boolean flag10 = false;
		try {
			pst10 = connection.connect.prepareStatement(INSERT_SQL10);
			pst10.setString(1, getAct_name);
			pst10.setString(2, "DravenTest4");
			pst10.setString(3, "SelfParticipantVoteACTDetail");
			
			int vary10 = pst10.executeUpdate();
			if(vary10 == 1){
				flag10 = true;
			}
			pst10.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag10;
	}
	
	
	public boolean changeVoteResult(String getAct_Name,String getEmail,String getVoteResult)
	{
		connection.ConnectDataBase();
		PreparedStatement pst11 = null;
		String INSERT_SQL11 = "update "+getAct_Name+" set VoteResult = ? where userEmail = ?";
		boolean flag11 = false;
		try {
			pst11 = connection.connect.prepareStatement(INSERT_SQL11);
			pst11.setString(1, getVoteResult);
			pst11.setString(2, getEmail);
			int vary11 = pst11.executeUpdate();
			if(vary11 == 1){
				flag11 = true;
			}
			pst11.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag11;
	}
	
}
