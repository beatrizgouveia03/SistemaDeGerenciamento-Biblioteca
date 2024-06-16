package Entity;

public class Book extends Entity {
	/* Attributes */
	private String title;
	private Author author;
	private String genre;
	private boolean disponible;


	/* Constructor */
	Book(Integer id, String title, Author author, String genre){
		super(id);
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.disponible = true;
	}

	/* Sets and Gets */
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getTitle() {
		return title;
	}

	public Author getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	public boolean isDisponible() {
		return disponible;
	}

}
