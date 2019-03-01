package ServletContainer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginStatus extends HttpServlet {
	private static final long serialVersionUID = 2L;
    public LoginStatus() { super(); }
	
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //	DBConnection(request, response);
  		//response.setContentType("text/html");
    	  	
    	response.setContentType("text/html");
  		// Post Parameters From The request
  		String param1 = request.getParameter("Email");
  		String param2 = request.getParameter("Password");

  		if(param1 == null || param2 == null) { System.out.println("The 2 parameters were not present in the query string!"); } 
  		else 
  			if ("".equals(param1) || "".equals(param2)) { System.out.println("Parameters were present in the query string but has no value!"); } 
  			else 
  			 { System.out.println("Email= " + param1 + ", Password= " + param2);

  			// Print Tthe response
  			PrintWriter out = response.getWriter();
  			out.write("<html> <body>");

  			// Authentication Logic & HTML creation
  			if((param1.equalsIgnoreCase("MMacovei")) && (param2.equals("MMacove1"))) {				
  				out.write("<p style='color: green; font-size: medium;'>Welcome " + param1 + ", you are an authorised login!</p>"
  						+ "<form action=\"querryDB\" method=\"POST\">"
  						+ "<input type=\"submit\" value=\"Querry DB\"/> </form> <br>" 
  						+ "<form action=\"register\" method=\"POST\">"
  						+ "<input type=\"submit\" value=\"Add user\"/> </form> " );			
  			} else {
  				out.write("<p style='color: red; font-size: medium;'> " + "Please check your email/password!\n\n</p>"
  						+ "<form action=\"login\" method=\"POST\">"
  						+ "<input type=\"submit\" value=\"Go to Login Page\"/> </form> " );
  			}
  			out.write("</body></html>");
  			out.close();
  			System.out.println("User+Psq: ");
  		} 
  	}

/* see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//DBConnection(request, response);
	}
	
/* My metods 
	
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

		} catch (Exception e) {
        	e.printStackTrace();
            System.err.println("Error with connection: " + e);
            // Again, for debug purpose
            out.println("Error with connection: " + e); }
		
		out.println("</tr> </table> </body> </html>"); }
	        finally { 
	            out.close();
	        }
	} */
}


/*package ServletContainer;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

//@WebServlet("/Endpoint1")

public class LoginStatus extends HttpServlet {
	private static final long serialVersionUID = 2L;
    public LoginStatus() { super(); }
	
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //	DBConnection(request, response);
  		//response.setContentType("text/html");
    	  	
    	response.setContentType("text/html");
  		// Post Parameters From The request
  		String param1 = request.getParameter("Email");
  		String param2 = request.getParameter("Password");
  		String url = "jdbc:mysql://localhost:3306/c5webapp";
  		String fin = 
  		
			System.out.println("Param1: "+param1);
			System.out.println("Param2: "+param2);
  		
  		try {
  		Class.forName("com.mysql.jdbc.Driver");
  		Connection conn = DriverManager.getConnection(url, "MMacovei", "MMacove1");
  		String querry = "SELECT Email, Password from USERS WHERE Email=?" + param1 +" and Password= " + param2;
  		
  		
  		PreparedStatement ps = conn.prepareStatement(querry);
  	//	Connection conn = DriverManager.getConnection(url, user, password);
		
		ResultSet rs = ps.executeQuery();

  		if(param1 == null || param2 == null) { System.out.println("The 2 parameters were not present in the query string!"); } 
  		else 
  			if ("".equals(param1) || "".equals(param2)) { System.out.println("Parameters were present in the query string but has no value!"); } 
  			else 
  			 { System.out.println("Email= " + param1 + ", Password= " + param2);

  			 
  			 
  			// Print Tthe response
  			PrintWriter out = response.getWriter();
  			out.write("<html> <body>");

  			System.out.println("Email: "+rs.getString("Email"));
  			System.out.println("Password: "+rs.getString("Password"));
  			// Authentication Logic & HTML creation
  		//	if((param1.equalsIgnoreCase("MMacovei")) && (param2.equals("MMacove1"))) {
 			if((param1.equalsIgnoreCase(rs.getString("Email"))) && (param2.equals(rs.getString("Password")))) {	
  				out.write("<p style='color: green; font-size: medium;'>Welcome " + param1 + ", you are an authorised login!</p>"
  						+ "<form action=\"querryDB\" method=\"POST\">"
  						+ "<input type=\"submit\" value=\"Querry DB\"/> </form> <br>" 
  						+ "<form action=\"register\" method=\"POST\">"
  						+ "<input type=\"submit\" value=\"Add user\"/> </form> " );			
  			} 
  			
  			
  			else {
  				out.write("<p style='color: red; font-size: medium;'> " + "Please check your email/password!\n\n</p>"
  						+ "<form action=\"login\" method=\"POST\">"
  						+ "<input type=\"submit\" value=\"Go to Login Page\"/> </form> " );
  			}
  			
  			
  			
  			out.write("</body></html>");
  			out.close();
  			System.out.println("User+Psq: ");
  			
  			
  			
  			
  			 }}
  		catch(Exception e) {}
  	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//DBConnection(request, response);
	}
}
*/