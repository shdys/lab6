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
	
}
