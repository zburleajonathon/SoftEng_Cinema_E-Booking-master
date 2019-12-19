package termproj;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import freemarker.template.*;
import java.util.*;

@WebServlet("/browse")
public class BrowseServlet extends BaseServlet {
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

		HttpSession session = request.getSession();

		// check for search criteria
		String appliedSearch = "";
		if(session.getAttribute("searchName") != null) {
		    appliedSearch = session.getAttribute("searchName").toString();
		}
		
		
		String searchName = request.getParameter("searchName");
		if(Validate.noNulls(searchName)) {
		    System.out.println("Search name query: " + searchName);
		    session.setAttribute("searchName", searchName);
		    response.sendRedirect("browse_loggedIn");
		}

		// coming soon section. all but last 3 movies
		ArrayList<Movie> movieList = MovieJDBC.getAllMovies();
		int numMovies = movieList.size();
		String nowPlaying = "<div class=\"container\">";
		for(int i = 0; i < numMovies-3; i++) {
		    Movie movie = movieList.get(i);
		    String currentName = movie.getName();
		    String name = currentName.replace(" ", "");
		    name = name.replace("'", "");
		    if(Validate.noNulls(appliedSearch))  {
			String formatSearch = appliedSearch.replace(" ", "");
			formatSearch = formatSearch.replace("'", "");
			if(!formatSearch.equalsIgnoreCase(name)) {
			    continue;
			}
		    }
		    nowPlaying += "<div class=\"col-md-4 p-3\">" +
			"<div class=\"card box-shadow\">" +
			"<img class=\"card-img-top\" src=\"resources/images/" +
			movie.getName() + ".jpg\">" + 
			"<div class=\"card-body\">" +
			"<p class=\"card-text\">" + movie.getName() + "</p>" +
			"<div class=\"d-flex justify-content-between align-items-center\">" +
			"<div class=\"btn-group\">" +
			"<button onclick=\"view" + name + "()\"" +
		       	"type=\"button\" class=\"btn btn-sm btn-outline-secondary\">" +
			"View</button>" +
			"<button onclick=\"get" + name + "()\"" + 
			"type=\"button\" class=\"btn btn-sm btn-outline-secondary\">" +
			"Book Ticket</button>" +
			"</div> <small class=\"text-muted\">" +
			movie.getRuntime() + " mins</small>" +
			//"140 mins</small>" +
			"</div>" +
			"</div>" +
			"</div>" +
			"</div>";
		    
		} // end now playing
		map.put("nowPlaying", nowPlaying);

		// start coming soon section
		String comingSoon = "<div class=\"container\">";
                for(int i = numMovies-3; i < numMovies; i++) {
                    Movie movie = movieList.get(i);
                    String currentName = movie.getName();
                    String name = currentName.replace(" ", "");
                    name = name.replace("'", "");
                    if(Validate.noNulls(appliedSearch))  {
                        String formatSearch = appliedSearch.replace(" ", "");
                        formatSearch = formatSearch.replace("'", "");
                        if(!formatSearch.equalsIgnoreCase(name)) {
                            continue;
                        }
                    }
                    comingSoon += "<div class=\"col-md-4 p-3\">" +
                        "<div class=\"card box-shadow\">" +
                        "<img class=\"card-img-top\" src=\"resources/images/" +
                        movie.getName() + ".jpg\">" +
                        "<div class=\"card-body\">" +
                        "<p class=\"card-text\">" + movie.getName() + "</p>" +
                        "<div class=\"d-flex justify-content-between align-items-center\">" +
                        "<div class=\"btn-group\">" +
                        "<button onclick=\"view" + name + "()\"" +
                        "type=\"button\" class=\"btn btn-sm btn-outline-secondary\">" +
                        "View</button>" +
                        "<button onclick=\"get" + name + "()\"" +
                        "type=\"button\" class=\"btn btn-sm btn-outline-secondary\">" +
                        "Book Ticket</button>" +
                        "</div> <small class=\"text-muted\">" +
                        movie.getRuntime() + " mins</small>" +
                        //"140 mins</small>" +
                        "</div>" +
                        "</div>" +
                        "</div>" +
                        "</div>";

                } // end now playing

		map.put("comingSoon", comingSoon);
		
		
		//For the script
		//String addMovie = "<script> ";
		/*
		String name2 = movieList.get(1).getName();
		name2 = name2.replace(" ", "");
		name2 = name2.replace("'", "");
		System.out.println("name2 = " + name2);
		//String name2 = "Venom";
		String addMovie ="function view" + name2 + "(){" +
		    "var movie = document.getElementById(\"movieName\");" +
		    "movie.value = \"" + name2 + "\";" +
		    "movie.innerHTML = movie.value;" +
		    "window.location.href = \"bookMovie?movieName=" + name2 + "\";" +
		    "} ";
		*/

		// the scripts
		String addMovie="";
		for (int i = 0; i < numMovies; i++){
		    Movie movie = movieList.get(i);
		    String currentName = movie.getName();
		    String name = currentName.replace(" ", "");
		    name = name.replace("'", "");
		    name = name.replace(".", "");
		    System.out.println("Movie " + i + " = " + name);
		    addMovie += "function get" + name + "(){ " +
			"var movie = document.getElementById(\"movieName\"); " +
			"movie.value = \"" + name + "\"; " +
			"movie.innerHTML = movie.value; " +
			"window.location.href = \"bookMovie?movieName=" + name + "\"; " +
			"} " +
			"function view" + name + "(){ " +
			"var movie = document.getElementById(\"movieName\"); " +
			"movie.value = \"" + name + "\"; " +
			"movie.innerHTML = movie.value; " +
			"window.location.href = \"movieInfo?movieName=" + name + "\"; " +
			"} ";
		}
		//addMovie += " </script>";
		map.put("addMovie", addMovie);
		session.invalidate();		
		Template template = cfg.getTemplate("browse.ftl");
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
