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
	

	
	
	public boolean addThisUserToParticipants(user uservary)
	{
		connection.ConnectDataBase();
		PreparedStatement pst5 = null;
		String INSERT_SQL5 = "INSERT INTO  act18(userName,userEmail,userSex,IsCreater) VALUES(?,?,?,?)";
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
	
	
	
	
	
	public boolean addParticipantToVoteActivity(String UserEmail)
	{
		connection.ConnectDataBase();
		PreparedStatement pst6 = null;
		String INSERT_SQL6 = "INSERT INTO activity(Owner,Act_name,IsVote,IsCreater) VALUES(?,?,?,?)";
		boolean flag6 = false;
		try {
			pst6 = connection.connect.prepareStatement(INSERT_SQL6);
			pst6.setString(1, UserEmail);
			pst6.setString(2, "act18");
			pst6.setString(3, "Yes");
			pst6.setString(4, "No");
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
}
