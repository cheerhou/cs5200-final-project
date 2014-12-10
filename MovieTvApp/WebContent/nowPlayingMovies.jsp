<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" import="neu.cs5200.movieTv.user.*, neu.cs5200.movieTv.movie.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Now Playing Movies</title>
<link href="css/bootstrap.css" rel="stylesheet"/>
</head>

<%	
	MovieJsonWebServiceClient client = new MovieJsonWebServiceClient();
	String urlApi ="http://api.themoviedb.org/3/movie/now_playing?api_key=cb308fc308a03542532cff9b7c2ed4d9";	
	String json = client.findJson(urlApi, "", "");
	List<Movie> movies = client.parserMovieJsonList(json);
	String userId = request.getParameter("userId");
%>

<div class="container">
  <div class="row">
  <%for(Movie movie : movies) { %>
    <div class="col-xs-6 col-md-3">
	   <div class="thumbnail"> 
	      <a href="/MovieTvApp/movieInfo.jsp?movieId=<%= movie.getId()%>&userId=<%= userId%>">  
     	    <img src="<%= movie.getPosterPath()%>">  
     	  </a> 	
     	  <div class="caption">
     	    Release Date: <%= movie.getReleaseDate() %>
        	<h3><%= movie.getTitle()%></h3>
        	<p>Rate: <%= movie.getVoteAverage() %></p> 	
      	  </div>       
        </div>  
    </div>
   <%} %>	
  </div>
</div>

<body>

</body>
</html>