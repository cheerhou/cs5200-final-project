package neu.cs5200.movieTv.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

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
//	public Movie findMovieByMovieName(String urlApi, String movieName) {
//	
//		}
	
	public static void main(String[] args) {
//		MovieJsonWebServiceClient client = new MovieJsonWebServiceClient();
//		System.out.println(client.findMovieById(157336));
	}

}
