package neu.cs5200.movieTv.movie;

import java.util.List;


public class Movie {
	private long id;
	private int budget;	
	private List<Genre> genres;	
	private String homepage;
	private String title;
	private String overview;
	private String posterPath;	
	private List<Company> productionCompanies;
	private List<Country> productionCountries;	
	private String releaseDate;
	private int runtime;	
	private List<Lan> spokenLanguages;
	private String status;
	private String tagline;
	private double voteAverage;
	private int voteCount;
	
	public Movie() {
		super();
	}

	public Movie(String title) {
		super();
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

	public List<Company> getProductionCompanies() {
		return productionCompanies;
	}

	public void setProductionCompanies(List<Company> productionCompanies) {
		this.productionCompanies = productionCompanies;
	}

	public List<Country> getProductionCountries() {
		return productionCountries;
	}

	public void setProductionCountries(List<Country> productionCountries) {
		this.productionCountries = productionCountries;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public List<Lan> getSpokenLanguages() {
		return spokenLanguages;
	}

	public void setSpokenLanguages(List<Lan> spokenLanguages) {
		this.spokenLanguages = spokenLanguages;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public double getVoteAverage() {
		return voteAverage;
	}

	public void setVoteAverage(double voteAverage) {
		this.voteAverage = voteAverage;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	
	
	
	
}
