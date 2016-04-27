package hibernate;

public class Movies {
	
	private String title;
	private String rating;
	private int movieKey;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRating() {
		return rating;
	} 
	public void setRating(String rating) {
		this.rating = rating;
	}
	public int getMovieKey() {
		return movieKey;
	}
	public void setMovieKey(int movieKey) {
		this.movieKey = movieKey;
	}
}