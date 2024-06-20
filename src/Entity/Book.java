package Entity;

public class Book extends Entity {
	/* Attributes */
	private String title;
	private String author;
	private String genre;
	private boolean disponible;


	/* Constructor */
	public Book(String title, String author, String genre){
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.disponible = true;
	}

	/* Sets and Gets */
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
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

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	public boolean isDisponible() {
		return disponible;
	}

	@Override
	public String toString() {
		String str = this.getId() + " - Title: " + this.title;
		str += "\nAuthor: " + this.author + "\nGenre: " + this.genre;
		str += "Disponibility: ";
		str +=  (isDisponible())? "Yes\n":"No \n";
		
		return str;
	}
}
