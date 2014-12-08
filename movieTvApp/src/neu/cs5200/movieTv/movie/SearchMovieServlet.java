package neu.cs5200.movieTv.movie;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchMovieServlet", urlPatterns = { "/search" })
public class SearchMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String movieName = request.getParameter("movieName");
		
		//pass user obj to next page
		request.setAttribute("movieName", movieName);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/movieSearchResults.jsp");
		dispatcher.forward(request, response);
		
		
		//test
//		System.out.println("Search " + movieName);
	}

}
