package ServletContainer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Servlet implementation class Endpoint1 */
//@WebServlet("/Endpoint1")

public class Endpoint1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Endpoint1() { super(); }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	// !!! getParameter -> Returneaza valoarea parametrului pe care eu il accesez
    	//Output = text: response.getWriter().append(servletResp(request.getParameter("name")));
		
		//Output = HTML
	//	response.getWriter().append(servletRespHtml(request.getParameter("name")));
		response.getWriter().append(welcomeForm());
    }

/* see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
/* My metods */
	public String servletResp(String name) {
		String sresponse = "";
		sresponse += "Congrats, "+name+"\n for your first servlet!";
		return sresponse;
	}
	
	public String servletRespHtml(String name) {
		String htmlresponse = "<html><body>"
        		+ "<h4><Hello " + name + "!\n</h4>"
        		+ "<h3> Congrats for your first servlet!"
        		+ "</body></html>";
		
		return htmlresponse;
	}
	
	public String welcomeForm() {
		String welcomeForm = "<html><body>"
				+ "<h3><Hello there!\n</h4>"
				+ "Pleade insert your name below: <br><br> "
				+ "<input type=\"text\" name=\"name\" /><br/><br> "
				+ "<input type=\"submit\" value=\"Submit\"/> </form> "
				+ "</body></html>";
		return welcomeForm;
	}
	
	

}
