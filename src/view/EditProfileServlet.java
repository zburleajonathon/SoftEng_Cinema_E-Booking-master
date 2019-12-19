package termproj;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import freemarker.template.*;
import java.util.*;

@WebServlet("/editProfile")
public class EditProfileServlet extends BaseServlet {
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
		
			/*
			*/
		HttpSession session = request.getSession(false);

		if(session == null){
			response.sendRedirect("login");
			System.out.println("Tried to enter profile without being logged in");
		}
		else{

			String sessEmail = session.getAttribute("userEmail").toString();
		        map.put("editEmail", sessEmail);
		        Customer custData = JDBC.getCustomer(sessEmail);
			
			String sessOut = session.getAttribute("outString").toString();
			if(sessOut != null || !sessOut.isEmpty()){
				map.put("OUTPUT", sessOut);
			}
			else{
				map.put("OUTPUT", " ");
			}

			PaymentInfo pay = custData.getPaymentInfo();
			Address adr = custData.getAddress();
			
			//mapping customer info into boxes
			map.put("editFirst", custData.getFirstName());
			map.put("editLast", custData.getLastName());
			map.put("editPass", " ********** ");
			
			//the next few may be null
			if(custData.getPhoneNumber() != null){
				map.put("editPhone", custData.getPhoneNumber());
			}
			else{
				map.put("editPhone", " ");
			}
			if(adr.getStreet() != null){
				map.put("editAddress", adr.getStreet());
			}
			else{
				map.put("editAddress", " ");
			}
			if(adr.getCity() != null){
				map.put("editCity", adr.getCity());
			}
			else{
				map.put("editCity", " ");
			}
			if(adr.getZip() != null){
				map.put("editZip", adr.getZip());
			}
			else{
				map.put("editZip", " ");
			}
			if(adr.getState() != null){
				map.put("editState", adr.getState());
			}
			else{
				map.put("editState", " ");
			}

			//paymentInfo
			if(pay.getName() != null){
				map.put("editCCName", pay.getName());
			}
			else{
				map.put("editCCName", " ");
			}
			if(pay.getCardNumber() != null){
				map.put("editCredit", pay.getCardNumber());
			}
			else{
				map.put("editCredit", " ");
			}
			if(pay.getExpiration() != null){
				map.put("editExp", pay.getExpiration());
			}
			else{
				map.put("editExp", " ");
			}
			if(pay.getCcv() != null){
				map.put("editCVV", pay.getCcv());
			}
			else{
				map.put("editCVV", " ");
			}
		}//end of session	

		//pull displayed data
		String inputFirst = request.getParameter("FirstName");
		String inputLast = request.getParameter("LastName");
		String inputPassword = request.getParameter("Password");
		//Error checking so that a invalid email won't mess with us
	      	String inputEmail = request.getParameter("Email");

		//Get Phone Number
	       	String inputPhoneNum = request.getParameter("Phone");

		//Get Address
		String inputAdr  = request.getParameter("Address");
		String inputCity = request.getParameter("City");
		String inputZip = request.getParameter("Zip");
		String inputState = request.getParameter("State");
	
		//Get Credit Info
		String inputCredit = request.getParameter("CreditCard");
		String inputCcName = request.getParameter("cc-name");
		String inputCcExp = request.getParameter("cc-expiration");
		String inputCcCvv = request.getParameter("cc-cvv");

		if(Validate.oneNotNull(inputFirst, inputLast, inputPassword, inputEmail, inputPhoneNum, inputAdr, inputCity, inputZip,
						inputState, inputCredit, inputCcName, inputCcExp, inputCcCvv)){
			//set all attributes
			session.setAttribute("userFirst", inputFirst);
			session.setAttribute("userLast", inputLast);
			session.setAttribute("userPass", inputPassword);
			session.setAttribute("userInputEmail", inputEmail);
			session.setAttribute("userPhone", inputPhoneNum);
			session.setAttribute("userAdr", inputAdr);
			session.setAttribute("userCity", inputCity);
			session.setAttribute("userZip", inputZip);
			session.setAttribute("userState", inputState);
			session.setAttribute("userCredit", inputCredit);
			session.setAttribute("userCC", inputCcName);
			session.setAttribute("userExp", inputCcExp);
			session.setAttribute("userCVV", inputCcCvv);

			System.out.println("IT TESTED FOR FIRST NAME");

			

			response.sendRedirect("secondEdit");
		}
		Template template = cfg.getTemplate("editProfile.ftl");
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
