package Entity;

import java.util.List;
import java.util.ArrayList;

public class Client extends User {
    /* Atributes */
    List<Loan> loans;

    /* Constructor */
    Client(Integer id, String name, String login, String password){
        super(id, name, login, password);
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

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setLogin(String Login) {
        super.setLogin(Login);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public Integer getId() {
        return super.getId();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getLogin() {
        return super.getLogin();
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }
}
