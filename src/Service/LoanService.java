package Service;

import java.util.Optional;
import java.time.LocalDate;

import DAO.DAO;
import Entity.Loan;
import Exception.DAOException;
import Entity.Book;
import Entity.Client;
import DAO.GenericDAO;

public class LoanService {
    /* Attributes */
    private DAO<Loan> loanDao = new GenericDAO<>();

    /* Methods */
    public void loanBook(Client client, Book book){
        LocalDate date = LocalDate.now();
        Loan loan = new Loan(book, client, date.toString());

        try{
            loanDao.save(loan);
        } catch (DAOException e){
            System.out.println("Erro ao realizar empréstimo: " + e.getMessage());
        }
    }

    public void returnLoan(int loanId){
        try{
            Optional<Loan> loan = loanDao.findById(loanId);
            if(loan.isPresent()){
                LocalDate date = LocalDate.now();
                loan.get().setDateLoaned(date.toString());
                loan.get().getBookLoaned().setDisponible(true);
            }
        } catch (DAOException e){
            System.out.println("Erro ao realizar devolução: " + e.getMessage());
        }
    }

}
