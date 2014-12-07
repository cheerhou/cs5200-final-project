<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" import="neu.cs5200.movieTv.movie.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Movie Details</title>
</head>
<body>
<%
  String mId = request.getParameter("movieId");
  int movieId = Integer.parseInt(mId);
  MovieJsonWebServiceClient client = new MovieJsonWebServiceClient();
  Movie movie = client.findMovieById(movieId);
%>

<div class="jumbotron">
  <h1><%= movie.getTitle() %></h1>
  <h2><%= movieId%></h2>
  <img src="<%= movie.getPosterPath()%>" class="img-rounded" height="400" width="300">
  <p><%= movie.getOverview() %></p>
</div>
</body>
</html>