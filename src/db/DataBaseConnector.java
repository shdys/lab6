package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnector {
	static String url = "jdbc:mysql://localhost:3306/draven";
	static String user = "root";
	static String password = "4217";

	public Connection connect;
	public Statement sta;
	public PreparedStatement pst;

	public void ConnectDataBase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			connect = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
