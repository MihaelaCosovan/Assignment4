package ServletContainer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 2L;
    public RegisterUser() { super(); }
	
//doGet    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append(registerUser());
    }

    
//doGet     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
/* My metods */
	public String registerUser() {
		String reg_user = "<html><body>"
				+ "<form action=\"insert\" method=\"POST\">"
				+ "<h3>Add a new user. <br><br> </h3>"
				+ "<h4>\n\nPleade insert the details below: <br><br></h4>"
				+ "Id: <input type=\"text\" name=\"Id\" /><br><br> "
				+ "First Name: <input type=\"text\" name=\"FirstName\" /> <br><br> "
				+ "Last Name: <input type=\"text\" name=\"LastName\" /> <br><br> "
				+ "Email: <input type=\"text\" name=\"Email\" /> <br><br> "
				+ "Password: <input type=\"text\" name=\"Password\" /><br/><br><br> "
				+ "<input type=\"submit\" value=\"Add User\"/> </form> "
				+ "</body></html>";
		return reg_user;
	}
}
