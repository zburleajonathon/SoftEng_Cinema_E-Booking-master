package termproj;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import freemarker.template.*;
import java.util.*;

@WebServlet("/secondEdit")
public class SecondEdit extends BaseServlet {
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

		HttpSession session = request.getSession(false);
		
		if(session == null){
			response.sendRedirect("login");
		}
		else{
			String sessEmail = session.getAttribute("userEmail").toString();
			Customer custData = JDBC.getCustomer(sessEmail);

			String email = session.getAttribute("userInputEmail").toString();

			//pull displayed data
		        String first = session.getAttribute("userFirst").toString();
			System.out.println("HOLY SHIT THIS IS :" + first); //TESTING Line
			
		        String last = session.getAttribute("userLast").toString();
		        String password = session.getAttribute("userPass").toString();

		        //Get Phone Number
		        String phoneNum = session.getAttribute("userPhone").toString();

		        //Get Address
		        String address  = session.getAttribute("userAdr").toString();
		        String city = session.getAttribute("userCity").toString();
		        String zip = session.getAttribute("userZip").toString();
		        String state = session.getAttribute("userState").toString();

		        //Get Credit Info
		        String credit = session.getAttribute("userCredit").toString();
		        String ccName = session.getAttribute("userCC").toString();
		        String ccExp = session.getAttribute("userExp").toString();
		        String ccCvv = session.getAttribute("userCVV").toString();


	 		if(Validate.oneNotNull(first, last, password, email, phoneNum, address, city, zip,
						state, credit, ccName, ccExp, ccCvv)){
				

				System.out.println("Entered submit if");
				if(first == null || first.isEmpty()){
					first = custData.getFirstName();
					System.out.println("Got first name from edit profile");
				}
				if(last == null || last.isEmpty()){
					last = custData.getLastName();
				}
				if(password == null || password.isEmpty()){
					password = custData.getPassword();
				}
				if(email == null || email.isEmpty()){
					email = custData.getEmail();
				}
				else if(!email.contains("@") && (!email.contains(".com") ||
					!email.contains(".net") || !email.contains(".org"))){
					email = custData.getEmail();
					map.put("editPass", "Invalid Email");
				}
				else{
					email = sessEmail;
				}


				Address newAdr = new Address(address, zip, state, city);
				PaymentInfo newPay = new PaymentInfo(credit, ccName, ccExp, ccCvv, "Visa", address, state, "USA", zip);
				Customer newCust = new Customer(first, last, email, password, newAdr, newPay, phoneNum, true);

				JDBC.editProfile(newCust, email);				
			
				
				session.setAttribute("outString", "Data Saved. You can cancel to go to Home or submit again");
				response.sendRedirect("editProfile");
				

			}//end of submit test
			else{
				System.out.println("FAILED TO ENTER secondEdit do stuff()");
				response.sendRedirect("secondEdit");
			}
		}//end of session else
		Template template = cfg.getTemplate("secondEdit.ftl");
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
