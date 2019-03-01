package ServletContainer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InsertUser() { super(); }

    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		 		
  		Connection connect = null;
  		String url = "jdbc:mysql://localhost:3306/c5webapp?";
  		String user = "MMacovei";
		String password = "MMacove1";
  		String dbTable = "USERS";
  		PreparedStatement ps = null;
  		 PrintWriter out = response.getWriter();
  		
  		try {
			Class.forName("com.mysql.jdbc.Driver");
		//	connect = DriverManager.getConnection(url);
			//nsert User as Power Admin by default
			connect = DriverManager.getConnection(url + "user=" + user +"&password=" + password);
			ps = connect.prepareStatement("INSERT INTO " + dbTable + " VALUES(?, ?, ?, ?, ?)");
						
			String Id = request.getParameter("Id");
	  		String FirstName = request.getParameter("FirstName");
	  		String LastName = request.getParameter("LastName");
	  		String Email = request.getParameter("Email");
	  		String Password = request.getParameter("Password");
	  		
	  		ps.setString(1, Id);
	  		ps.setString(2, FirstName);
	  		ps.setString(3, LastName);
	  		ps.setString(4, Email);
	  		ps.setString(5, Password);
	  		ps.executeUpdate();
	  		
	  		System.out.println("A new used was added");
	  		out.println("<html><body><p style='color: green; font-size: medium;'>The used was added to " + dbTable + " table!</p>"
	  				+ "<form action=\"querryDB\" method=\"POST\">"
					+ "<input type=\"submit\" value=\"Querry DB\"/> </form> <br>" 
					+ "<form action=\"register\" method=\"POST\">"
					+ "<input type=\"submit\" value=\"Add user\"/> </form> <br> "
					+ "<form action=\"login\" method=\"POST\">"
					+ "<input type=\"submit\" value=\"Go to Login Page\"/> </form> "
	  				+ "</body></html>");
	  		
		} catch (Exception e) {
        	e.printStackTrace();
            System.err.println("Error with connection: " + e);
            // Again, for debug purpose
            out.println("Error with connection: " + e); }
 	}
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		//DBConnection(request, response);
	}
}