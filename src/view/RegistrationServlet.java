
package termproj;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import freemarker.template.*;
import java.util.*;


@WebServlet("/registration")
public class RegistrationServlet extends BaseServlet {
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

		//testing session and setting a useful prompt
		HttpSession test = request.getSession(false);
		if(test != null && (test.getAttribute("ROP").toString()) != null){
			map.put("regOUTPUT", test.getAttribute("ROP").toString());
		}
		else{
			map.put("regOUTPUT", " ");
			if(test != null)
				test.invalidate();//invalid any session prior
		}

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String street = request.getParameter("address");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String cc_name = request.getParameter("cc-name");
		String cc_num = request.getParameter("cc-number");
		String cc_exp = request.getParameter("cc-expiration");
		String cc_cvv = request.getParameter("cc-cvv");
		String phoneNum = request.getParameter("phone");	
		String city = request.getParameter("city");
		
		if(firstName != null && !firstName.isEmpty()) {
		    if(email != null && !email.isEmpty()) {
			HttpSession session = request.getSession();
			System.out.println("first name and email filled out");
			System.out.println("EMAIL USED IN RegistrationServlet.java: " + email);
			System.out.println("THIS IS ZIP: " + zip);
			Address addr = new Address(street, zip, state, city);
			PaymentInfo pay = new PaymentInfo(cc_num, cc_name, cc_exp, cc_cvv);
			Customer newUser = new Customer(firstName, lastName, email, password, addr, pay, phoneNum);
			
			File f = new File("util/regSuccess.py");
    	    		String tmpPath = f.getCanonicalPath();
			System.out.println("tmpPath = " + tmpPath);
			String regSuccessPath = tmpPath.replaceAll("wildfly-14.0.1.Final/bin", "SoftEng_Cinema_E-Booking/util/");
			System.out.println("regSucess.py path: " + regSuccessPath);
			
			// later on replace "" with password2 in the following line
			int returnValue = Validate.registerCheck(newUser, password2);

			String returnValStr = Integer.toString(returnValue); //session stuff
			session.setAttribute("regEmail", email); //session stuff
			session.setAttribute("retVal", returnValStr); //session stuff	
			switch(returnValue) {
			case 1: {
			    session.setAttribute("ROP", "User already exists. Try again.");
			    System.out.println("User already exists");
			    response.sendRedirect("registration");
			    break;
			}
			case 2: {
                            session.setAttribute("ROP", "Passwords do not match. Try again.");
			    System.out.println("Passwords do not match, try again");
			    response.sendRedirect("registration");
			    break;
			}
			case 4: {
                            session.setAttribute("regOUTPUT", "Invalid Email. Try again.");
			    System.out.println("Invalid email");
			    response.sendRedirect("registration");
			    break;
			}
			default: {
			    Process process = Runtime.getRuntime().exec("python " + regSuccessPath  + " "  + email + " " + returnValue);
			    System.out.println("Registration successful");
			    response.sendRedirect("signupConfirm");
			    break;
			}
			}
		    }
		}
		// do more shit here
		// we have the params
		// try { controller.login(params) }
		// catch(validation errors) from ^
		// login(params)     // if ^^ succeeded

		Template template = cfg.getTemplate("registration.ftl");
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
