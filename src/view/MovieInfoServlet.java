//Movie Info
//

package termproj;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import freemarker.template.*;
import java.util.*;

@WebServlet("/movieInfo")
public class MovieInfoServlet extends BaseServlet {
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

		String movieName = request.getParameter("movieName");
		System.out.println("In MovieInfo with movieName = " + movieName);
		Movie movie = MovieJDBC.getMovie(movieName);
		map.put("name_of_movie", movie.getName());
		map.put("readonly", "readonly");
		map.put("runtime", movie.getRuntime());
		map.put("rating", movie.getRating());
		map.put("genre", movie.getGenre());
		map.put("cast", movie.getCast());
		map.put("review", movie.getReview());
		map.put("trailer", movie.getTrailer());
		
		Template template = cfg.getTemplate("movieInfo.ftl");
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
