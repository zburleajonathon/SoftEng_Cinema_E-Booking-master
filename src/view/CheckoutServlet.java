package termproj;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import freemarker.template.*;
import java.util.*;

@WebServlet("/checkout")
public class CheckoutServlet extends BaseServlet {
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

		System.out.println("In Checkout Servlet");
		HttpSession session = request.getSession(false);

		String appliedPromo = "";
		double promoRate = 0;
		// check if a promo has already been applied
		if(session.getAttribute("promo") != null) {
		    appliedPromo = session.getAttribute("promo").toString();
		    System.out.println("Applied promo is: " + appliedPromo);
		    promoRate = BookMaster.getPromoRate(appliedPromo);
		}
		
		// map stuff to ftl
		String childTickets = session.getAttribute("childTickets").toString();
		String adultTickets = session.getAttribute("adultTickets").toString();
		String seniorTickets = session.getAttribute("seniorTickets").toString();
		String showtimeStr = session.getAttribute("showtime").toString();
		int childs = Integer.parseInt(childTickets);
		int adults = Integer.parseInt(adultTickets);
		int seniors = Integer.parseInt(seniorTickets);
		int totalSeats = childs + adults + seniors;
		int time = Utilities.getTimeFromShowtime(showtimeStr);
		double childCost = BookMaster.childCost(childs);
		double adultCost = BookMaster.adultCost(adults, time);
		double seniorCost = BookMaster.seniorCost(seniors);
		double convFee = BookMaster.getConvFee(totalSeats);
		double tax = BookMaster.getTax(childCost + adultCost + seniorCost, promoRate);
		double total = BookMaster.computeCost(childs, adults, seniors, promoRate, time);
		// later change these to actual cost
		map.put("adultCost", adultTickets);
		map.put("childCost", childTickets);
		map.put("seniorCost", seniorTickets);
		map.put("numAdults", adults);
		map.put("numChilds", childs);
		map.put("numSeniors", seniors);
		map.put("tax", String.valueOf(tax));
		map.put("convFee", String.valueOf(convFee));
		map.put("promoRate", promoRate);
		map.put("total", String.valueOf(total));
		
		// redeem promo
		String promo = request.getParameter("promo");
		if(Validate.noNulls(promo)) {
		    System.out.println("Promo typed in was: " + promo);
		    session.setAttribute("promo", promo);
		    response.sendRedirect("checkout");
		}
		
		// we can remove this stuff later
		String movieName = session.getAttribute("movieName").toString();
		//String showtimeStr = session.getAttribute("showtime").toString();
		String numSeatsStr = session.getAttribute("numSeats").toString();
		System.out.println("In checkout servlet with movieName = " + movieName);
		System.out.println("showtime = " + showtimeStr);
		System.out.println("Number of seats = " + numSeatsStr);
				
		// Getting information for validating
		String street = request.getParameter("billingAddress");
		String zip = request.getParameter("billingZip");
		String state = request.getParameter("billingState");
		String country = request.getParameter("billingCountry");

		String cc_name = request.getParameter("cc-name");
		String cc_num = request.getParameter("cc-num");
		String cc_exp = request.getParameter("cc-exp");
		String cc_cvv = request.getParameter("cc-cvv");
		
		if(Validate.noNulls(street, zip, state, country, cc_name, cc_num, cc_exp, cc_cvv)) {
		    Address address = new Address(street, zip, state, country);
		    PaymentInfo payment = new PaymentInfo(cc_num, cc_name, cc_exp, cc_cvv, zip);
		    // Just validating input fields
                    switch(Validate.checkoutValidation(address, payment)) {
                    case 0:    // successful - continue past switch statement
                        System.out.println("Passed Checkout Validation");
                        break;
                    case 1:
                        System.out.println("Not a valid street address");
			response.sendRedirect("checkout");
                        break;
		    case 2:
			System.out.println("Not a valid zip code");
			response.sendRedirect("checkout");
			break;
		    }
		    // Continue booking logic
		    switch(BookMaster.checkout(address, payment, session)) {
		    case 0:
			System.out.println("Checkout successful!");
			response.sendRedirect("orderConfirmation");
			break;
		    default:
			System.out.println("Checkout failed somewhere go investigate");
			break;
		    }
	       
                }
		
		Template template = cfg.getTemplate("checkout.ftl");
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
