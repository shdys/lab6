package DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Activity;

//import model.Author;
//import model.Book;


public class DownloadSQL {
	static DataBaseConnector connection = new DataBaseConnector();


	public Activity getActivitySandN(String Owner){
		 connection.ConnectDataBase();
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 String SEARCH_SQL = "SELECT Number,Sum,Type from activity WHERE Owner = ?";

		try {
			Activity acty=new Activity();
			pst = connection.connect.prepareStatement(SEARCH_SQL);

			pst.setString(1, Owner);

			rs = pst.executeQuery();
			

			while (rs.next()) {
				acty.setUserEmail(Owner);
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
	
	
	
/*	public Author getAuthorByID(int AuthorID){
		 connection.ConnectDataBase();
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 String SEARCH_SQL = "SELECT Country,Age,Name FROM author  WHERE AuthorID = ?";

		try {
			Author au = new Author();
			pst = connection.connect.prepareStatement(SEARCH_SQL);

			pst.setLong(1, AuthorID);

			rs = pst.executeQuery();

			while (rs.next()) {
				
				au.setAuthorID(AuthorID);
				au.setAge(rs.getString("Age"));
				au.setCountry(rs.getString("Country"));
				au.setName(rs.getString("Name"));
				
			}
			pst.close();
			return au;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
	
	public Author getAuthorByName(String name){

		connection.ConnectDataBase();
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 String SEARCH_SQL = "SELECT Country,Age,AuthorID FROM author  WHERE Name = ?";

		try {
			Author au = new Author();
			pst = connection.connect.prepareStatement(SEARCH_SQL);

			pst.setString(1, name);

			rs = pst.executeQuery();

			while (rs.next()) {
				
				au.setAuthorID(rs.getInt("AuthorID"));
				au.setAge(rs.getString("Age"));
				au.setCountry(rs.getString("Country"));
				au.setName(name);
				
			}
			pst.close();
			return au;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
	
	public Book getBookByISBN(String ISBN){
		 connection.ConnectDataBase();
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 String SEARCH_SQL = "SELECT Price,PublishDate,Publisher,AuthorID,Title  FROM book WHERE ISBN=?";

		try {
			Book com  = new Book();
			pst = connection.connect.prepareStatement(SEARCH_SQL);
			pst.setString(1, ISBN);
			rs = pst.executeQuery();
			while (rs.next()) {
				com.setISBN(ISBN);
				com.setPrice(rs.getString("Price"));
				com.setPublishDate(rs.getString("PublishDate"));
				com.setPublisher(rs.getString("Publisher"));
				com.setAuthorID(rs.getInt("AuthorID"));
				com.setTitle(rs.getString("Title"));
			}
			pst.close();	
			return com;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
	
	
	public ArrayList<Book> getBooksByAuthor(int AuthorID) {
		 connection.ConnectDataBase();
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 String SEARCH_SQL = "SELECT Price,PublishDate,Publisher,Title,ISBN FROM book WHERE AuthorID = ?";

		try {
			ArrayList<Book> booklist = new ArrayList<Book>();
			pst = connection.connect.prepareStatement(SEARCH_SQL);
			pst.setLong(1, AuthorID);
			rs = pst.executeQuery();
			while (rs.next()) {
				Book com  = new Book();
				com.setISBN(rs.getString("ISBN"));
				com.setPrice(rs.getString("Price"));
				com.setPublishDate(rs.getString("PublishDate"));
				com.setPublisher(rs.getString("Publisher"));
				com.setTitle(rs.getString("Title"));
				com.setAuthorID(AuthorID);
				com.setAuthorName(getAuthorByID(AuthorID).getName());
				booklist.add(com);
			}
			pst.close();	
			return booklist;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	

	
	*/
	
}
