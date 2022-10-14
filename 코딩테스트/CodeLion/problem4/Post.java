package problem4;

import java.time.LocalDate;

public class Post {
	
	private String title;
	private String author;
	private LocalDate date;
	
	public Post() {}
	
	public Post(String title, String author) {
		this.title = title;
		this.author = author;
		this.date = LocalDate.now();
	}

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
	
	public LocalDate getDate() {
		return date;
	}

}
