package Entity;

import java.util.List;
import java.util.ArrayList;

public class Client extends User {
    /* Attributes */
    List<Loan> loans;

    /* Constructor */
    public Client(String name, String login, String password){
        super(name, login, password);
        loans = new ArrayList<Loan>();
    }

    /* Methods */
    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void addLoan(Loan loan){
        loans.add(loan);
    }
}
