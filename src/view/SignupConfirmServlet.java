package termproj;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import freemarker.template.*;
import java.util.*;

@WebServlet("/signupConfirm")
public class SignupConfirmServlet extends BaseServlet {
	Configuration cfg;
	HashMap map;

	public void init() throws ServletException {
	    
		cfg = new Configuration(Configuration.VERSION_2_3_25);
		cfg.setServletContextForTemplateLoading(getServletContext(), 
			"WEB-INF/templates");
		map = new HashMap<>();
	} 

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
			       
	    try {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String conCode = request.getParameter("confirmCode");

		if(conCode != null){
			HttpSession session = request.getSession(false);
			System.out.println("Confirmation Code From User: " + conCode);

			if(session != null){
				String email = (String)session.getAttribute("regEmail");
				String returnValue = (String)session.getAttribute("retVal");
				while(true){
					if(conCode.equals(returnValue)){
						JDBC.changeCustomerStatus(email);
						session.invalidate();
						response.sendRedirect("login");
						break;
					}
					else{
						System.out.println("Confirmation Code Wrong");
						response.sendRedirect("signupConfirm");
					}
				}

			}
			else{
				System.out.println("Regristration failed");
				session.invalidate();
			}
		}//end of concode test
		Template template = cfg.getTemplate("signupConfirmation.ftl");
		template.process(map, out); // do this line last
	    }
	    catch(Exception e) {
		e.printStackTrace();
	    }	
	}
    
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	    
	    doGet(request, response);
	    
	}
    
}
