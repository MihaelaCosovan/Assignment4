package ServletContainer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectOption extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SelectOption() { super(); }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append(selectOption(request.getParameter("name")));
    }

/* see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
/* My metods */
	public String selectOption(String name) {
		String sOption = "<html><body><h3> Hello " + name + ", </h3>\n"
				+ "<h4> Please select the action you'd like to do: \n</h4>"
				+ "<form action=\"login\" method=\"POST\">"
				+ "<input type=\"submit\" value=\"Login\"></form>"
				+ "<form action=\"register\" method=\"POST\">"
				+ "<input type=\"submit\" value=\"Register\"></form>"
				+ "</body></html>";
		return sOption;
	}
}

