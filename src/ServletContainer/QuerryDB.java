package ServletContainer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


public class QuerryDB extends HttpServlet {
	private static final long serialVersionUID = 2L;
    public QuerryDB() { super(); }
	
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
  	}

/* see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnection(request, response);
	}
	
/* My metods */
	
	public void DBConnection(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		response.setContentType("text/html;charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        try {
	        	out.println("<html> <head> <style> table, th, td { border: 1px solid black; border-collapse: collapse; }"
	    				+ "th, td { padding: 5px; text-align: left; } </style> </head>"
	    				+ "<body><h3>Available Users\n</h3>" 
	    				+ "<div><table style=\"width:50%\">"
	    				+ "<tr>"
	    					+ "<th>Id</th> "
	    					+ "<th>FirstName</th> "
	    					+ "<th>LastName</th> "
	    					+ "<th>Email</th> "
	    					+ "<th>Password</th> "
	    				+ "</tr>");
	    			//	+ "</tr> </table>"
		
		String url = "jdbc:mysql://localhost:3306/c5webapp";
		String user = "MMacovei";
		String password = "MMacove1";
		String dbTable = "users";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url, user, password);
			
			Statement stt = connect.createStatement();
			
			ResultSet rs = stt.executeQuery("SELECT * FROM " + dbTable);
			
			while (rs.next())
			{  
			out.println("<tr> <td> " + rs.getString("id") + " </td>"
						  + " <td> " + rs.getString("FirstName") + " </td>" 
						  + " <td> " + rs.getString("LastName") + " </td>" 
						  + " <td> " + rs.getString("Email") + " </td>" 
						  + " <td> " + rs.getString("Password") + " </td>"); }

		} catch (Exception e) { e.printStackTrace();}
		
		out.println("</tr> </table> <br><br> "
				+ "<form action=\"register\" method=\"POST\">"
					+ "<input type=\"submit\" value=\"Add user\"/> </form> <br> "
				+ "</body> </html>"); }
	        finally { 
	            out.close();
	        }
	}
}