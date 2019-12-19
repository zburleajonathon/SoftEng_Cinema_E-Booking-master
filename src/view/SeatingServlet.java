
package termproj;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import freemarker.template.*;
import java.util.*;

@WebServlet("/seating")
public class SeatingServlet extends BaseServlet {
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

	    System.out.println("In seating page");
	    HttpSession session = request.getSession(false);

	    String numSeats = request.getParameter("numSeats");
	    String childTickets = request.getParameter("childs");
	    String adultTickets = request.getParameter("adults");
	    String seniorTickets = request.getParameter("seniors");

	    if(Validate.noNulls(numSeats, childTickets, adultTickets, seniorTickets)) {
		if(BookMaster.verifySeating(session, request)) {
		    // Save seating info to the Session
		    int numSelected = BookMaster.saveSeatSelection(session, request);
		    System.out.println("Seat num check passed");
		    session.setAttribute("childTickets", childTickets);
		    session.setAttribute("adultTickets", adultTickets);
		    session.setAttribute("seniorTickets", seniorTickets);
		    session.setAttribute("numSeats", numSeats);
		    // Proceed to checkout
		    response.sendRedirect("checkout");
		}
		else {
		    System.out.println("Seating verification failed, try again");
		}
	    }
	    
	    Template template = cfg.getTemplate("seating.ftl");
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
