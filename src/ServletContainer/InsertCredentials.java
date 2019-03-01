package ServletContainer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class InsertCredentials extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public InsertCredentials() { super(); }
	
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append(login());
    }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
/* My metods */
	public String login() {
		String userLogin = "<html><body>"
				+ "<h3>Please insert your credentials below: </h3>\n"
				+ "<form method=\"POST\" action=\"loginStatus\"><br>"
				+ "Email:  <input type=\"text\" name=\"Email\" /><br/><br> "
				+ "Password: <input type=\"password\" name=\"Password\" /><br/><br> "
			    + "<input type=\"submit\" value=\"Submit\"></form></center></body></html>";
		return userLogin;
	}
}

