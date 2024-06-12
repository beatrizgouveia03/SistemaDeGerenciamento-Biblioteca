package Entity;

public class Loan extends Entity {
    /* Atributes */
    private Book bookLoaned;
    private Client loanedTo;
    private String dateLoaned;
    private String dateReturned;

    /* Constructor */
    Loan(Integer id, Book bookLoaned, Client loanedTo, String dateLoaned){
        super(id);
        this.bookLoaned = bookLoaned;
        this.loanedTo = loanedTo;
        this.dateLoaned = dateLoaned;
    }

    /* Methods */
    public void setBookLoaned(Book bookLoaned) {
        this.bookLoaned = bookLoaned;
    }

    public void setLoanedTo(Client loanedTo) {
        this.loanedTo = loanedTo;
    }

    public void setDateLoaned(String dateLoaned) {
        this.dateLoaned = dateLoaned;
    }

    public void setDateReturned(String dateReturned) {
        this.dateReturned = dateReturned;
    }

    public Book getBookLoaned() {
        return bookLoaned;
    }

    public Client getLoanedTo() {
        return loanedTo;
    }

    public String getDateLoaned() {
        return dateLoaned;
    }

    public String getDateReturned() {
        return dateReturned;
    }
    
    @Override
    public Integer getId() {
        return super.getId();
    }
}
