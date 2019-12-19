package termproj;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import freemarker.template.*;
import java.util.*;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends BaseServlet {
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
		
		JDBC val = new JDBC();

		//If a session exists before
		map.put("loginOUTPUT", " ");
		HttpSession test = request.getSession(false);
		if(test != null && (test.getAttribute("LOP").toString()) != null){
			map.put("loginOUTPUT", test.getAttribute("LOP").toString());
		}
		else{
			map.put("loginOUTPUT", " ");
			if(test != null)
				test.invalidate();//invalid any session prior
		}
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		if(email != null && !email.isEmpty()){
			if(pass != null && !pass.isEmpty()){
				//System.out.println("its works");

				HttpSession sessTest = request.getSession(false);
				if(sessTest != null){
					sessTest.invalidate();
				}else{
				switch(val.login(email,pass)){
					case 0: {
						HttpSession session = request.getSession();
						session.setAttribute("type", "admin");
						session.setAttribute("adminEmail", email);
						response.sendRedirect("home_admin");
						System.out.println("Successful Admin Login");
						break;
					}
					case 1: {
						HttpSession session = request.getSession();
                                                session.setAttribute("type", "user");
						session.setAttribute("userEmail", email);
						session.setAttribute("outString", " ");
						response.sendRedirect("home_LoggedIn");
						System.out.println("Successful Customer Login");
						break;
					}
					case 2:{
						HttpSession session = request.getSession();
						session.setAttribute("LOP", "Admin Password is Incorrect");			
						response.sendRedirect("login");
						System.out.println("Admin Password Incorrect");
						break;
					}
					case 3:{
						HttpSession session = request.getSession();
                                                session.setAttribute("LOP", "Your Password is Incorrect. Try Again"); 
						response.sendRedirect("login");
						System.out.println("Customer password Incorrect");
						break;
					}
					default:{
						HttpSession session = request.getSession();
                                                session.setAttribute("LOP", "Username or password is incorrect. Try Again."); 
						response.sendRedirect("login");
						System.out.println("Username incorrect");
						break;
					}
				

				}
				}//end of session test

			/*	//change this around when registerCheck is changed
				boolean a = true;
				//Validate.loginCheck(email, pass))
				if(a == true){
					//change when HomeLoggedInServlet is done	
					response.sendRedirect("home_LoggedIn");
				}
				else{
					out.println("Email or Password is incorrect");
					response.sendRedirect("login");
				}*/
			}
		}
		// do more shit here
		// we have the params
		// try { controller.login(params) }
		// catch(validation errors) from ^
		// login(params)     // if ^^ succeeded

		Template template = cfg.getTemplate("login.ftl");
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
