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
	
	
	public boolean creatNewVoteActivityName(String UserEmail,String getVoteActivityName){
		connection.ConnectDataBase();
		PreparedStatement pst2 = null;
		String INSERT_SQL2 = "INSERT INTO activity(Owner,Act_name,IsVote,IsCreater) VALUES(?,?,?,?)";
		boolean flag2 = false;
		try {
			pst2 = connection.connect.prepareStatement(INSERT_SQL2);
			pst2.setString(1, UserEmail);
			pst2.setString(2, getVoteActivityName);
			pst2.setString(3, "Yes");
			pst2.setString(4, "Yes");
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
		String INSERT_SQL3 = "create table "+getVoteActivityName+" (userName VARCHAR(255),userEmail VARCHAR(255),userSex VARCHAR(255),leaveEarly VARCHAR(255),payMorePercentage VARCHAR(255),moneyShouldPay VARCHAR(255),Sum VARCHAR(255),Type VARCHAR(255),IsCreater VARCHAR(255),PRIMARY KEY ( userEmail ));";
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
	
	
}
