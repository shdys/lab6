package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnector {
<<<<<<< HEAD
	static String url = "jdbc:mysql://localhost:3306/aa_dutch";
=======
	static String url = "jdbc:mysql://localhost:3306/draven";
>>>>>>> adc46026a2105fee7e64b6adbf17de99ff59855b
	static String user = "root";
	static String password = "1234";

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
