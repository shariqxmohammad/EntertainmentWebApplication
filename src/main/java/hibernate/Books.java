package hibernate;

public class Books {
	private String title;
	private String author;
	private int booksKey;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public int getBooksKey() {
		return booksKey;
	}

	public void setBooksKey(int booksKey) {
		this.booksKey = booksKey;
	}		
}