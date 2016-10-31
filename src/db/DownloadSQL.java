package db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Author;
import model.Book;


public class DownloadSQL {
	static DataBaseConnector connection = new DataBaseConnector();
	/*public String getAuthorID(String authorname){
		 connection.ConnectDataBase();
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 String SEARCH_SQL = "SELECT authorid  from author WHERE name = ?";

		try {
			String authorid="";
			pst = connection.connect.prepareStatement(SEARCH_SQL);

			pst.setString(1, authorname);

			rs = pst.executeQuery();

			while (rs.next()) {
				authorid = rs.getString("authorid");
			}
			pst.close();
			return authorid;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}*/
	
	public boolean deleteBook(String ISBN){
		 connection.ConnectDataBase();
		 PreparedStatement pst = null;
		 int amount=0; 
		 String SEARCH_SQL = "DELETE FROM book WHERE isbn = ?";
		try {
			pst = connection.connect.prepareStatement(SEARCH_SQL);
			pst.setString(1, ISBN);
			amount = pst.executeUpdate();
			if(amount==1){
				pst.close();
				return true;
			}
			else{
				return  false;
			}
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
		    }
		return false;
	}
	
	
	public Author getAuthorByID(int AuthorID){
		 connection.ConnectDataBase();
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 String SEARCH_SQL = "SELECT country,age,name FROM author  WHERE authorid = ?";

		try {
			Author au = new Author();
			pst = connection.connect.prepareStatement(SEARCH_SQL);

			pst.setLong(1, AuthorID);

			rs = pst.executeQuery();

			while (rs.next()) {
				
				au.setAuthorID(AuthorID);
				au.setAge(rs.getString("age"));
				au.setCountry(rs.getString("country"));
				au.setName(rs.getString("name"));
				
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
		 String SEARCH_SQL = "SELECT country,age,authorid FROM author  WHERE name = ?";

		try {
			Author au = new Author();
			pst = connection.connect.prepareStatement(SEARCH_SQL);

			pst.setString(1, name);

			rs = pst.executeQuery();

			while (rs.next()) {
				
				au.setAuthorID(rs.getInt("authorid"));
				au.setAge(rs.getString("age"));
				au.setCountry(rs.getString("country"));
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
		 String SEARCH_SQL = "SELECT price,publishdate,publisher,authorid,title  FROM book WHERE isbn=?";

		try {
			Book com  = new Book();
			pst = connection.connect.prepareStatement(SEARCH_SQL);
			pst.setString(1, ISBN);
			rs = pst.executeQuery();
			while (rs.next()) {
				com.setISBN(ISBN);
				com.setPrice(rs.getString("price"));
				com.setPublishDate(rs.getString("publishdate"));
				com.setPublisher(rs.getString("publisher"));
				com.setAuthorID(rs.getInt("authorid"));
				com.setTitle(rs.getString("title"));
			}
			pst.close();	
			return com;
		    } 
		    catch (SQLException e) {
			e.printStackTrace();
			return null;
		    }
	}
	
	public ArrayList<Book> getAllBook() {
		 connection.ConnectDataBase();
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 String SEARCH_SQL = "SELECT price,publishdate,publisher,authorid,title,isbn  FROM book";

		try {
			ArrayList<Book> booklist = new ArrayList<Book>();
			pst = connection.connect.prepareStatement(SEARCH_SQL);
			rs = pst.executeQuery();
			while (rs.next()) {
				Book com  = new Book();
				com.setISBN(rs.getString("isbn"));
				com.setPrice(rs.getString("price"));
				com.setPublishDate(rs.getString("publishdate"));
				com.setPublisher(rs.getString("publisher"));
				com.setAuthorID(rs.getInt("authorid"));
				com.setTitle(rs.getString("title"));
				com.setAuthorName(getAuthorByID(rs.getInt("authorid")).getName());
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
	
	public ArrayList<Book> getBooksByAuthor(int AuthorID) {
		 connection.ConnectDataBase();
		 PreparedStatement pst = null;
		 ResultSet rs = null;
		 String SEARCH_SQL = "SELECT price,publishdate,publisher,title,isbn FROM book WHERE authorid = ?";

		try {
			ArrayList<Book> booklist = new ArrayList<Book>();
			pst = connection.connect.prepareStatement(SEARCH_SQL);
			pst.setLong(1, AuthorID);
			rs = pst.executeQuery();
			while (rs.next()) {
				Book com  = new Book();
				com.setISBN(rs.getString("isbn"));
				com.setPrice(rs.getString("price"));
				com.setPublishDate(rs.getString("publishdate"));
				com.setPublisher(rs.getString("publisher"));
				com.setTitle(rs.getString("title"));
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
	
}
