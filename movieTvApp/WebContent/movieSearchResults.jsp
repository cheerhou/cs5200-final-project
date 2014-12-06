<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" import="neu.cs5200.movieTv.user.*, neu.cs5200.movieTv.movie.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Movie Search Results</title>
<link href="css/bootstrap.css" rel="stylesheet"/>
</head>
<body>
<h1>Here is your movie results:</h1>
<%	String movieName = (String) request.getAttribute("movieName");
	MovieJsonWebServiceClient client = new MovieJsonWebServiceClient();
	List<Movie> movies = client.findMovieByMovieName(movieName);
%>

	<table class="table">
		<thead>
			<tr>
				<th>Title</th>
				<th>Release Date</th>
				<th>Overview</th>
			</tr>
		</thead>
	<%for(Movie movie : movies) { %>
		<tbody>
			<tr>
				<td><%= movie.getTitle()%></td>
				<td><%= movie.getReleaseDate()%></td>
				<td><%= movie.getOverview()%></td>
			</tr>
		</tbody>
		<%} %>
	</table>
	
</body>
</html>