package termproj;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import freemarker.template.*;
import java.util.*;

@WebServlet("/addPromotion")
public class AddPromoServlet extends BaseServlet {
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

		// String email = request.getParameter("email");
		// do more shit here
		// we have the params
		// try { controller.login(params) }
		// catch(validation errors) from ^
		// login(params)     // if ^^ succeeded

		//gets parameters
		String movie = request.getParameter("Movie");
		String expiration = request.getParameter("expirationDate");
		String promotionCode = request.getParameter("promotionCode");
		String promotionName = request.getParameter("promotionName");
		String percentage = request.getParameter("percentage");
		String email = "jyg25523@gmail.com";
		File f = new File("util/sendPromo.py");
                String tmpPath = f.getCanonicalPath();
		System.out.println("tmpPath = " + tmpPath);
		String sendPromoPath = tmpPath.replaceAll("wildfly-14.0.1.Final/bin", "SoftEng_Cinema_E-Booking/util/");

		//checks for empty values
		if (Validate.noNulls(movie, expiration, promotionCode, promotionName)) {
		    System.out.println("sendPromoPath = " + sendPromoPath);
		    Process process = Runtime.getRuntime().exec("python " + sendPromoPath  + " "  + email + " " + promotionCode + " " + movie + " " + percentage + " " + expiration);
		    System.out.println("Passed noNulls");
		    response.sendRedirect("home_admin");
		}
		else {
                        System.out.println("hahahahah");
                }


		Template template = cfg.getTemplate("addPromotion.ftl");
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
