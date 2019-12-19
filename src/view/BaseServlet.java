package termproj;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import freemarker.template.*;
import java.util.*;

abstract public class BaseServlet extends HttpServlet {

    Configuration cfg;
    HashMap map;
    
    public void init() throws ServletException {
	cfg = new Configuration(Configuration.VERSION_2_3_25);
	cfg.setServletContextForTemplateLoading(getServletContext(),
						"WEB-INF/templates");
	map = new HashMap<>();
    }

    abstract public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException;

    abstract public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException;

}
