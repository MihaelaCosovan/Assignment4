package ServletContainer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;

public class DBconnection {
	
/*	public void DBConnection() throws ServletException, IOException {

		String url = "jdbc:mysql://localhost:3306/c5webapp";
	//	String user = "MMacovei";
	//	String password = "MMacove1";
	String dbTable = "users";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
	//		Connection connect = DriverManager.getConnection(url, user, password);
			
		//	Statement stt = connect.createStatement();
			
		//	ResultSet rs = stt.executeQuery("SELECT * FROM " + dbTable);
			
		

		} catch (Exception e) { e.printStackTrace(); }
		
		 } */
	
	//public void DBconnection() {   
		static {
		     try {
		        Class.forName("com.mysql.jdbc.Driver");
		    } catch (ClassNotFoundException e) {
		        throw new IllegalArgumentException("MySQL db driver isnot on classpath");
		    }
		
}
		public Connection getConnection(String dbTable,String user,String password) throws SQLException
		{
		    return DriverManager.getConnection("jdbc:mysql://localhost/"+dbTable+"?user="+user+"&password="+password);    
		}
		public PreparedStatement prepareStatement(String string) {
			// TODO Auto-generated method stub
			return null;
		}
	
	      
		
}
