//Book Movie
//

package termproj;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import freemarker.template.*;
import java.util.*;

@WebServlet("/bookMovie")
public class BookMovieServlet extends BaseServlet {
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
		//needs to be false or it will change the current logged in session 

		if(session == null){
		    response.sendRedirect("login");
		    System.out.println("Tried to enter bookMovie without being logged in");
		}
		else if(session.getAttribute("type") == null){
			response.sendRedirect("login");
		}
		else{
		    // Session to pass info to other servlets
		    String movieName = request.getParameter("movieName");
		    if(Validate.noNulls(movieName)) {
		        session.setAttribute("movieName", movieName);
		    }
		    System.out.println("Movie name in BookMovie is: " + movieName);

		    // map items to bookMovie ftl page
		    map.put("movieName", movieName);
		    map.put("movieName2", movieName);
		    ArrayList<Showtime> showtimeList = MovieJDBC.getAllShowtimes(movieName);
		    int numShowtimes = showtimeList.size();
		    String showtimes = "";
		    for(int i = 0; i < numShowtimes; i++) {
			Showtime showtime = showtimeList.get(i);
			String date = showtime.getDate();
			String time = showtime.getTime();
			String timeFormatted = Utilities.unConvertTime(time);
			String hallName = "H" + showtime.getHallID();
			// add the showtimes in
			String showtimeLine = date + " " + timeFormatted + " " + hallName;
			String addShowtime = "<option value=\"" + showtimeLine + "\">" +
			    showtimeLine + "</option>";
			showtimes += addShowtime;
		    }
		    map.put("showtimes", showtimes);
		    
		    // get params
		    String showtimeStr = request.getParameter("showtime");
		    session.setAttribute("showtime", showtimeStr);
		    
		    // if params not null
		    if(Validate.noNulls(movieName, showtimeStr)) {
			System.out.println("Successful movie booking. Continuing to Seat Selection.");
			response.sendRedirect("seating");
		    }
		}
				
		
		Template template = cfg.getTemplate("bookMovie.ftl");
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
