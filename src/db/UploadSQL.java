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
		String INSERT_SQL4 = "INSERT INTO "+getVoteActivityName+" (userName,userEmail,userSex,IsCreater,leaveEarly) VALUES(?,?,?,?,?)";
		boolean flag4 = false;
		try {
			pst4 = connection.connect.prepareStatement(INSERT_SQL4);
			pst4.setString(1, UserVary.userName);
			pst4.setString(2, UserVary.userEmail);
			pst4.setString(3, UserVary.userSex);
			pst4.setString(4, "Yes");
			pst4.setString(5, "No");
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
		String INSERT_SQL5 = "INSERT INTO " + getVoteACTName + " (userName,userEmail,userSex,IsCreater,leaveEarly) VALUES(?,?,?,?,?)";
		boolean flag5 = false;
		try {
			pst5 = connection.connect.prepareStatement(INSERT_SQL5);
			pst5.setString(1, uservary.userName);
			pst5.setString(2, uservary.userEmail);
			pst5.setString(3, uservary.userSex);
			pst5.setString(4, "No");
			pst5.setString(5, "No");
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
	
	
	
	
	public boolean changeVoteType(String getAct_name,String getLastType)
	{
		connection.ConnectDataBase();
		PreparedStatement pst12 = null;
		String INSERT_SQL12 = "update "+getAct_name+" set Type = ?";
		boolean flag12 = false;
		try {
			pst12 = connection.connect.prepareStatement(INSERT_SQL12);
			pst12.setString(1, getLastType);
			int vary12 = pst12.executeUpdate();
			if(vary12 == 1){
				flag12 = true;
			}
			pst12.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag12;
	}
	
	
	
	public boolean changeLeave(String getAct_name,String getChangeLeaveEmail)
	{
		connection.ConnectDataBase();
		PreparedStatement pst13 = null;
		String INSERT_SQL13 = "update "+ getAct_name +" set leaveEarly = ? where userEmail = ?";
		boolean flag13 = false;
		try {
			pst13 = connection.connect.prepareStatement(INSERT_SQL13);
			pst13.setString(1, "Yes");
			pst13.setString(2, getChangeLeaveEmail);
			int vary13 = pst13.executeUpdate();
			if(vary13 == 1){
				flag13 = true;
			}
			pst13.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag13;
	}
	
	
	public boolean NormalSetAVGMoney(float Average_money,String getAct_name)
	{
		connection.ConnectDataBase();
		PreparedStatement pst14 = null;
		String INSERT_SQL14 = "update " + getAct_name + " set moneyShouldPay = ?";
		boolean flag14 = false;
		try {
			pst14 = connection.connect.prepareStatement(INSERT_SQL14);
			pst14.setString(1, String.valueOf(Average_money));
			int vary14 = pst14.executeUpdate();
			if(vary14 == 1){
				flag14 = true;
			}
			pst14.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag14;
	}
	
	
	public boolean AddSumToVoteActivity(float getSum_money,String getAct_name)
	{
		connection.ConnectDataBase();
		PreparedStatement pst15 = null;
		String INSERT_SQL15 = "update " + getAct_name + " set Sum = ?";
		boolean flag15 = false;
		try {
			pst15 = connection.connect.prepareStatement(INSERT_SQL15);
			pst15.setString(1, String.valueOf(getSum_money));
			int vary15 = pst15.executeUpdate();
			if(vary15 == 1){
				flag15 = true;
			}
			pst15.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag15;
	}
	
	
	
	public boolean AddSumToActivityTable(float getSum_money,String getAct_name)
	{
		connection.ConnectDataBase();
		PreparedStatement pst16 = null;
		String INSERT_SQL16 = "update activity set Sum = ? where Act_name = ?";
		boolean flag16 = false;
		try {
			pst16 = connection.connect.prepareStatement(INSERT_SQL16);
			pst16.setString(1, String.valueOf(getSum_money));
			pst16.setString(2, getAct_name);
			int vary16 = pst16.executeUpdate();
			if(vary16 == 1){
				flag16 = true;
			}
			pst16.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag16;
	}
	
	
	
	
	public boolean AddNumberToActivityTable(int getTotal_num,String getAct_name)
	{
		connection.ConnectDataBase();
		PreparedStatement pst17 = null;
		String INSERT_SQL17 = "update activity set Number = ? where Act_name = ?";
		boolean flag17 = false;
		try {
			pst17 = connection.connect.prepareStatement(INSERT_SQL17);
			pst17.setString(1, String.valueOf(getTotal_num));
			pst17.setString(2, getAct_name);
			int vary17 = pst17.executeUpdate();
			if(vary17 == 1){
				flag17 = true;
			}
			pst17.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag17;
	}
	
	
	
	
	public boolean changeVoteTypeIntoACTTable(String getAct_name,String getLastType)
	{
		connection.ConnectDataBase();
		PreparedStatement pst18 = null;
		String INSERT_SQL18 = "update activity set Type = ? where Act_name = ?";
		boolean flag18 = false;
		try {
			pst18 = connection.connect.prepareStatement(INSERT_SQL18);
			pst18.setString(1, getLastType);
			pst18.setString(2, getAct_name);
			int vary18 = pst18.executeUpdate();
			if(vary18 == 1){
				flag18 = true;
			}
			pst18.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag18;
	}
	
	
	
	
	
	public boolean GirlsSetBoysAVGMoney(float getBoy_Average_money,String getAct_name)
	{
		connection.ConnectDataBase();
		PreparedStatement pst19 = null;
		String INSERT_SQL19 = "update " + getAct_name + " set moneyShouldPay = ? where userSex = ?";
		boolean flag19 = false;
		try {
			pst19 = connection.connect.prepareStatement(INSERT_SQL19);
			pst19.setString(1, String.valueOf(getBoy_Average_money));
			pst19.setString(2, "male");
			int vary19 = pst19.executeUpdate();
			if(vary19 == 1){
				flag19 = true;
			}
			pst19.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag19;
	}
	
	
	
	
	public boolean GirlsSetGirlsAVGMoney(String getAct_name)
	{
		connection.ConnectDataBase();
		PreparedStatement pst20 = null;
		String INSERT_SQL20 = "update " + getAct_name + " set moneyShouldPay = ? where userSex = ?";
		boolean flag20 = false;
		try {
			pst20 = connection.connect.prepareStatement(INSERT_SQL20);
			pst20.setString(1, String.valueOf(0));
			pst20.setString(2, "female");
			int vary20 = pst20.executeUpdate();
			if(vary20 == 1){
				flag20 = true;
			}
			pst20.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag20;
	}
	
	
	
	
	
	public boolean LeaveSetNotLeaveAVGMoney(String getAct_name,double getNotLeave_Average_money)
	{
		connection.ConnectDataBase();
		PreparedStatement pst21 = null;
		String INSERT_SQL21 = "update " + getAct_name + " set moneyShouldPay = ? where leaveEarly = ?";
		boolean flag21 = false;
		try {
			pst21 = connection.connect.prepareStatement(INSERT_SQL21);
			pst21.setString(1, String.valueOf(getNotLeave_Average_money));
			pst21.setString(2, "No");
			int vary21 = pst21.executeUpdate();
			if(vary21 == 1){
				flag21 = true;
			}
			pst21.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag21;
	}
	
	
	
	
	
	
	public boolean LeaveSetLeaveAVGMoney(String getAct_name,double getLeave_Average_money)
	{
		connection.ConnectDataBase();
		PreparedStatement pst22 = null;
		String INSERT_SQL22 = "update " + getAct_name + " set moneyShouldPay = ? where leaveEarly = ?";
		boolean flag22 = false;
		try {
			pst22 = connection.connect.prepareStatement(INSERT_SQL22);
			pst22.setString(1, String.valueOf(getLeave_Average_money));
			pst22.setString(2, "Yes");
			int vary22 = pst22.executeUpdate();
			if(vary22 == 1){
				flag22 = true;
			}
			pst22.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag22;
	}
	
	
	
	
	
	public boolean AddPayMorePercentageToActivityTable(float getPayMorePercentage,String getAct_name)
	{
		connection.ConnectDataBase();
		PreparedStatement pst23 = null;
		String INSERT_SQL23 = "update " + getAct_name + " set payMorePercentage = ?";
		boolean flag23 = false;
		try {
			pst23 = connection.connect.prepareStatement(INSERT_SQL23);
			pst23.setString(1, String.valueOf(getPayMorePercentage));
			int vary23 = pst23.executeUpdate();
			if(vary23 == 1){
				flag23 = true;
			}
			pst23.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag23;
	}
}
