package Entity;

import java.util.List;
import java.util.ArrayList;

public class Author extends Entity {
    /* Atributes */
    private String name;
    private String nacionality;
    private List<Book> booksWritten;

    /* Constructor */
    Author(Integer id, String name, String nacionality){
        super(id);
        this.name = name;
        this.nacionality = nacionality;
        this.booksWritten = new ArrayList<Book>();
    }

    /* Sets and Gets */
    public void setName(String name) {
        this.name = name;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public void setBooksWritten(List<Book> booksWritten) {
        this.booksWritten = booksWritten;
    }

    public String getName() {
        return name;
    }

    public String getNacionality() {
        return nacionality;
    }

    public List<Book> getBooksWritten() {
        return booksWritten;
    }

}
