package webapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RSSParser rss = new RSSParser("http://www.dnevnik.bg/rss/");
		List<HashMap<String, String>> feed = new ArrayList<HashMap<String, String>>();
		try {
			feed = rss.getContent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		
		// HTML inside this document - it's a little ugly, but I'm leaving it that way
		response.getWriter().println("<!DOCTYPE html>");
		response.getWriter().println("<head>");
		response.getWriter().println("<title>News</title>");
		response.getWriter().println("</head>");
		response.getWriter().println("<body>");
		response.getWriter().println("<h2>THE News</h2>");
		
		for (HashMap<String, String> hashMap : feed) {
			response.getWriter().println("<div>");
			response.getWriter().println("<a href=\"" + hashMap.get("Link") + "\">" + hashMap.get("Title") + "</a>");
			response.getWriter().println("</div>");
			response.getWriter().println(hashMap.get("Author"));
			response.getWriter().println("<div>");
			response.getWriter().println(hashMap.get("PublishDate"));
			response.getWriter().println("</div>");
			response.getWriter().println(hashMap.get("Description"));
			response.getWriter().println("<br/>");
			response.getWriter().println("<br/>");
		}
		response.getWriter().println("</body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
