package neu.cs5200.movieTv.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class MovieJsonWebServiceClient {

//	private String urlApi;
	
//	public Movie findMovieById(int movieId) {
//		
//		urlApi = "http://api.themoviedb.org/3/movie/{id}?api_key=cb308fc308a03542532cff9b7c2ed4d9";
//		
//		String mId = String.valueOf(movieId);
//		String urlString = urlApi.replace("{id}", mId);
//
//		Movie movie = new Movie();
//		
//		try {
//			URL url = new URL(urlString);	
//			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//			connection.setRequestMethod("GET");
//			InputStream stream = connection.getInputStream();
//			InputStreamReader reader = new InputStreamReader(stream);
//			BufferedReader buffer = new BufferedReader(reader);
//			
//			String line;
//			String json = "";
//			
//			while((line = buffer.readLine()) != null){
//				json += line;
//			}
////			System.out.println(json);
//			
//			JSONParser parser = new JSONParser();
//			
//			JSONObject JsonObject = (JSONObject) parser.parse(json);
//			
//			long id = (Long) JsonObject.get("id");
////			boolean adult = (Boolean) JsonObject.get("adult");
////			int budget = (Integer) JsonObject.get("budget");
////			String homepage = (String) JsonObject.get("homepage");				
//			String title = (String) JsonObject.get("original_title");
//			String overview = (String) JsonObject.get("overview");
////			String posterPath = (String) JsonObject.get("backdrop_path");
//			String releaseDate = (String) JsonObject.get("release_date");
////			int runtime = (Integer) JsonObject.get("runtime");			
////			String status = (String) JsonObject.get("status");
//			String tagline = (String) JsonObject.get("tagline");
////			double voteAverage = (Double) JsonObject.get("vote_average");
////			int voteCount = (Integer) JsonObject.get("vote_count");				
////			
////			JSONArray genres = (JSONArray) JsonObject.get("genres");
////			JSONArray productionCompanies = (JSONArray) JsonObject.get("production_companies");
////			JSONArray productionCountries = (JSONArray) JsonObject.get("production_countries");
////			JSONArray spokenLanguages = (JSONArray) JsonObject.get("spoken_languages");				
//
//			movie.setId(id);
//			movie.setOverview(overview);
//			movie.setReleaseDate(releaseDate);
//			movie.setTitle(title);
//			movie.setTagline(tagline);
//			
////			System.out.println(genres);
//			
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}		
//		return movie;
//	}
	
	public String findJson(String urlApi, String target, String parameter) {
		String urlString = urlApi.replace(target, parameter);	
		String line;
		String json = "";
		try {
			URL url = new URL(urlString);	
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			InputStream stream = connection.getInputStream();
			InputStreamReader reader = new InputStreamReader(stream);
			BufferedReader buffer = new BufferedReader(reader);
			
			while((line = buffer.readLine()) != null) {
				json += line;
				}
			
			}  catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 	
		
		return json; 
	}
	
	public Movie findMovieById(int movieId) {
		Movie movie = new Movie();
		String json = "";
		
		String urlApi = "http://api.themoviedb.org/3/movie/{id}?api_key=cb308fc308a03542532cff9b7c2ed4d9";
		String target = "{id}";
		String mId = String.valueOf(movieId);
				
		json = findJson(urlApi, target, mId);
		
		JSONParser parser = new JSONParser();	
		JSONObject jsonObject;
		
		try {
			jsonObject = (JSONObject) parser.parse(json);

			long id = (Long) jsonObject.get("id");
//			boolean adult = (Boolean) jsonObject.get("adult");
//			int budget = (Integer) jsonObject.get("budget");
//			String homepage = (String) jsonObject.get("homepage");				
			String title = (String) jsonObject.get("original_title");
			String overview = (String) jsonObject.get("overview");
//			String posterPath = (String) jsonObject.get("backdrop_path");
			String releaseDate = (String) jsonObject.get("release_date");
//			int runtime = (Integer) jsonObject.get("runtime");			
//			String status = (String) jsonObject.get("status");
			String tagline = (String) jsonObject.get("tagline");
//			double voteAverage = (Double) jsonObject.get("vote_average");
//			int voteCount = (Integer) jsonObject.get("vote_count");				
//			
//			JSONArray genres = (JSONArray) jsonObject.get("genres");
//			JSONArray productionCompanies = (JSONArray) jsonObject.get("production_companies");
//			JSONArray productionCountries = (JSONArray) jsonObject.get("production_countries");
//			JSONArray spokenLanguages = (JSONArray) jsonObject.get("spoken_languages");				

			movie.setId(id);
			movie.setOverview(overview);
			movie.setReleaseDate(releaseDate);
			movie.setTitle(title);
			movie.setTagline(tagline);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return movie;
	}
	
	
	public List<Movie> findMovieByMovieName(String movieName) {
		List<Movie> movies = new ArrayList<Movie>();
		String urlApi = "http://api.themoviedb.org/3/search/movie?api_key=cb308fc308a03542532cff9b7c2ed4d9&query={movieName}";
		String target = "{movieName}";
		String json = "";
		
		String mName = movieName.replaceAll(" ", "%20");
		json = findJson(urlApi, target, mName);
		JSONParser parser = new JSONParser();	
		JSONObject jsonObject;
		
		try {
			jsonObject = (JSONObject) parser.parse(json);			
	
			JSONArray results = (JSONArray) jsonObject.get("results");
			
			for(Object o : results) {
				JSONObject result = (JSONObject) o;
				long id = (Long) result.get("id");
				String title = (String) result.get("original_title");
				String overview = (String) result.get("overview");
				String tagline = (String) result.get("tagline");
				String releaseDate = (String) result.get("release_date");
				
				Movie movie = new Movie();
				movie.setId(id);
				movie.setOverview(overview);
				movie.setReleaseDate(releaseDate);
				movie.setTitle(title);
				movie.setTagline(tagline);
				
				movies.add(movie);
			}			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		return movies;	
		}
	
	public static void main(String[] args) {
		MovieJsonWebServiceClient client = new MovieJsonWebServiceClient();
//		System.out.println(client.findMovieById(157336).getTitle());
		
		System.out.println(client.findMovieByMovieName("iron man").get(1).getId());
//		System.out.println(client.findMovieByMovieName("Interstellar").get(1).getId());
		
//		String movieName = "A B";
//		String mName = movieName.replaceAll(" ", "%20");
//		System.out.println(mName);
	}

}
