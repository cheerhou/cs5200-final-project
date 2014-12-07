<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" import="neu.cs5200.movieTv.user.*, neu.cs5200.movieTv.movie.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Favorite Movies</title>
<link href="css/bootstrap.css" rel="stylesheet"/>

</head>
<body>
<ul class="nav nav-tabs">
	<li role="presentation" class="active"><a href="#">Home</a></li>
  	<li role="presentation"><a href="/movieTvApp/popularMovies.jsp">Movie</a></li>
  	<li role="presentation"><a href="/movieTvApp/popularTvs.jsp">TV</a></li>
  	<li role="presentation"><a href="/movieTvApp/people.jsp">People</a></li>
</ul>
<%
	User user = (User) request.getAttribute("user");
	User2MovieDao umDao = new User2MovieDao();
	List<Integer> movieIdList = umDao.findMovieIdByUserId(user.getId());
	
	MovieJsonWebServiceClient movieJsonClient = new MovieJsonWebServiceClient();
	ArrayList<Movie> movieList = new ArrayList<Movie>();
	
	for(int movieId : movieIdList) {
		movieList.add(movieJsonClient.findMovieById(movieId));
	} 
	
	System.out.println(user.getId());
%>    


<div class="container">
  <div class="row">
  <%for(Movie movie : movieList) { %>
    <div class="col-xs-6 col-md-3">
	    <div class="thumbnail">   
     	  <img src="<%= movie.getPosterPath()%>">   	
     	  <div class="caption">
     	    Release Date: <%= movie.getReleaseDate() %>
        	<h3><%= movie.getTitle()%></h3>
        	<p><%= movie.getOverview() %></p>
        	<a href="/movieTvApp/movieInfo.jsp?movieId=<%= movie.getId() %>" class="btn btn-primary">Detail</a>
        	
      	  </div>       
        </div>  
    </div>
   <%} %>	
  </div>
</div>
</body>
</html>