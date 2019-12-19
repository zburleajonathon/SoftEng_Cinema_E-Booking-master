//Order Confirmation

package termproj;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import freemarker.template.*;
import java.util.*;

@WebServlet("/orderConfirmation")
public class OrderConfirmationServlet extends BaseServlet {
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
		    System.out.println("Tried to enter profile without being logged in");
		}
		else {
		    String childTickets = session.getAttribute("childTickets").toString();
		    String adultTickets = session.getAttribute("adultTickets").toString();
		    String seniorTickets = session.getAttribute("seniorTickets").toString();
		    String totalSeats = session.getAttribute("numSeats").toString();
		    String email = session.getAttribute("userEmail").toString();
		    int numSeats = Integer.parseInt(totalSeats);
		    int numChild = Integer.parseInt(childTickets);
		    int numAdult = Integer.parseInt(adultTickets);
		    int numSenior = Integer.parseInt(seniorTickets);
		    String[] seats = BookMaster.getSessionSeats(session, numSeats);
		    String price = session.getAttribute("price").toString();
		    String bookingNumStr = session.getAttribute("promo").toString();
		    map.put("childTickets", childTickets);
		    map.put("adultTickets", adultTickets);
		    map.put("seniorTickets", seniorTickets);
		    map.put("totalTickets", totalSeats);
		    map.put("cost", price);
		    
		    String seatID = "";
		    for (int i = 0; i < numSeats; i++){
			seatID += seats[i] + " ";
		    }
		    map.put("seatID", seatID);
		
		    File f = new File("util/sendConfirmation.py");
                    String tmpPath = f.getCanonicalPath();
		    String sendConfirmationPath = tmpPath.replaceAll("wildfly-14.0.1.Final/bin", "SoftEng_Cinema_E-Booking/util/");
		    Process process = Runtime.getRuntime().exec("python " + sendConfirmationPath  + " "  + email + " " + totalSeats + " " + seatID + " " + price);
		    System.out.println("tmpPath = " + tmpPath);
		    System.out.println("sendConfirmationPath = " + sendConfirmationPath);
		    if(Validate.noNulls(email)) {
			System.out.println("send confirmation email to " + email);
		    }
		    else {
			System.out.println("email is null in orderConfirmation servlet");
		    }
		    

		}
		
		Template template = cfg.getTemplate("orderConfirmation.ftl");
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
