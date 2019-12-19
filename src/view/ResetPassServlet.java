package termproj;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import freemarker.template.*;
import java.util.*;
import java.io.File;

@WebServlet("/ResetPass")
public class ResetPassServlet extends BaseServlet {
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
		
		String email = request.getParameter("email");//get the email from the web page
		if (email != null && !email.isEmpty()){
		System.out.println("EMAIL FROM WEBPAGE RESETPASSSERVLET: " + email);
		
		String newPass = JDBC.resetPassword(email);
		System.out.println("THIS IS NEWPASS IN RESETPASSSERVLET: " + newPass);
		File resetpy = new File("resetPass.py");
		String tmpPath = resetpy.getAbsolutePath();
		System.out.println("tmpPath is " + tmpPath);
		String hardPath = "../SoftEng_Cinema_E-Booking/util/resetPass.py";
		String resetpyPath = tmpPath.replaceAll("wildfly-14.0.1.Final/bin", "SoftEng_Cinema_E-Booking/util");
		System.out.println("THIS IS hardPath: " + hardPath);
		if(newPass.length() > 0){
			Process process = Runtime.getRuntime().exec("python " + hardPath  + " "  + email + " "  + newPass);
			response.sendRedirect("login");
		}
		}
		Template template = cfg.getTemplate("ResetPass.ftl");
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
