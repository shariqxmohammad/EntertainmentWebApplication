package hibernate;

public class Music {

	private String title;
	private String artist;
	private int musicKey; 
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getMusicKey() {
		return musicKey;
	}
	public void setMusicKey(int musicKey) {
		this.musicKey = musicKey;
	}
}