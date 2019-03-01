package ServletContainer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomePage extends HttpServlet {
	private static final long serialVersionUID = 2L;
    public WelcomePage() { super(); }
	
//doGet    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append(welcomeForm());
    }

    
//doGet     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
/* My metods */
	public String welcomeForm() {
		String welcomeForm = "<html><body>"
				+ "<form action=\"select\" method=\"GET\">"
				+ "<h3>Welcome to your online DB! <br><br> </h3>"
				+ "<h4>\n\nPleade insert your name below: <br><br></h4>"
				+ "<input type=\"text\" name=\"name\" /><br/><br> "
				+ "<input type=\"submit\" value=\"Submit\"/> </form> "
				+ "</body></html>";
		return welcomeForm;
	}
}
