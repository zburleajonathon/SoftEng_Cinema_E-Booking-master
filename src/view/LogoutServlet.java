package termproj;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import freemarker.template.*;
import java.util.*;
import java.sql.*;

@WebServlet("/logout")
public class LogoutServlet extends BaseServlet {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//request.getRequestDispatcher("home_LoggedIn").include(request,response);
		HttpSession sess = request.getSession(false);
		if(sess != null){
			sess.invalidate();
		}
		response.sendRedirect("home");
	
		Template template = cfg.getTemplate("home_LoggedIn.ftl");
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


}//end of servlet
