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
    private DAO<Loan> loanDao = new GenericDAO<>(Loan.class);
    private DAO<Book> bookDao = new GenericDAO<>(Book.class);

    /* Methods */
    public void loanBook(Client client, Integer bookId){
        LocalDate date = LocalDate.now();
        Optional<Book> aux = Optional.empty();
        try {
            aux = bookDao.findById(bookId);
        } catch (DAOException e) {
            System.out.println("Error creating loan: " + e.getMessage());
        }

        Book book;

        if(aux.isPresent()) {
            book = aux.get();
            Loan loan = new Loan(book, client, date.toString());
            try{
                loanDao.save(loan);
            } catch (DAOException e){
                System.out.println("Error creating loan: " + e.getMessage());
            }
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
            System.out.println("Error returning loan: " + e.getMessage());
        }
    }

    public void listAllLoans(){
        try{
            for(Loan loan : loanDao.findAll()){
                System.out.println(loan.toString());
            }
        } catch (DAOException e){
            System.out.println("Error listing loans: " + e.getMessage());
        }
    }

}
