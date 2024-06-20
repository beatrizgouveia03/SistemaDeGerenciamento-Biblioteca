package View;

import java.util.Scanner;

import Entity.Admin;
import Entity.Client;
import Entity.Loan;
import Entity.User;
import Service.BookService;
import Service.LoanService;

public class LoanView implements View {
    /* Attributes */
    private User user;
    private Scanner scanner = new Scanner(System.in);
    private LoanService service = new LoanService();
    private BookService books = new BookService();

    public LoanView(User user){
        this.user = user;
    }

    /* Methods */
    public void startView() {
        System.out.println("Welcome to Loan Management System!");
        
        if(user instanceof Admin){
            adminMenu();
        } else {
            userMenu();
        }
    }

    private void adminMenu(){
        System.out.println("Listing all loans");
        service.listAllLoans();
    }

    private void userMenu(){
        System.out.println("Please choose an option:");
        System.out.println("1. Loan a book");
        System.out.println("2. Return a book");
        System.out.println("3. List all your loans");
        System.out.println("4. Exit");

        int option;

        while(true){
			try{
				option = scanner.nextInt();
			} catch (Exception e) {
				scanner.next();
				System.out.println("Invalid input. Please try again.");
				continue;
			}

			if(option >= 1 && option <= 4) break;
			else System.out.println("Invalid option. Please try again.");
		}

        switch (option) {
            case 1: loanBook();                
                break;
            case 2: returnBook();
                break;
            case 3: listLoans();
                    break;
            case 4: System.out.println("Exiting Book Management System.");
                break;
        
            default:
                break;
        }
    }

    private void loanBook(){
        books.listAllBooks();
        System.out.println("Enter the book ID:");
        int bookId;

        while (true) {
            try{
                bookId = scanner.nextInt();
            } catch (Exception e) {
                scanner.next();
                System.out.println("Invalid input. Please try again.");
                continue;
            }
            break;
        }

        if(user instanceof Client) {
            Client client = (Client) user;
            service.loanBook(client, bookId);
        }
    }

    private void returnBook(){
        if(user instanceof Client) {
            Client client = (Client) user;
            for(Loan l: client.getLoans()){
                System.out.println(l);
            }
            System.out.println("Enter the loan ID:");
            int loanId;

            while (true) {
                try{
                    loanId = scanner.nextInt();
                } catch (Exception e) {
                    scanner.next();
                    System.out.println("Invalid input. Please try again.");
                    continue;
                }
                break;
            }
            service.returnLoan(loanId);
        }
    }

    private void listLoans(){
        if(user instanceof Client) {
            Client client = (Client) user;
            for(Loan l: client.getLoans()){
                System.out.println(l);
            }
        }
    }

}
