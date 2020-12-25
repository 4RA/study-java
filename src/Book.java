import java.awt.Image;

public class Book extends Item {
	private String authors;		//저자
	private String publisher;	//출판사
	
	public String getAuthors() {
		return authors;
	}

	public void setAuthors(String authors) {
		this.authors = authors;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Book(String name, int star, String summary,String comments,
			int openYear,String authors, String publisher) {
		super(name, star, summary,comments, openYear);
		this.authors = authors;
		this.publisher = publisher;
		// TODO Auto-generated constructor stub
	}

	
}
