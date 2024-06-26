package View;

import java.util.Scanner;

import Entity.Admin;
import Entity.Book;
import Entity.User;
import Service.BookService;

public class BookView implements View {
    /* Attributes */
    private User user;
    private Scanner scanner = new Scanner(System.in);
    private BookService service = new BookService();

    public BookView(User user){
        this.user = user;
    }

    /* Methods */
    @Override
    public void startView() {
        System.out.println("\nWelcome to Book Management System!");
        
        if(user instanceof Admin){
            adminMenu();
        } else {
            userMenu();
        }

        MainView main = new MainView(user);
        main.startView();
    }

    private void userMenu(){
        System.out.println("Please choose an option:");
        System.out.println("1. View all books");
        System.out.println("2. Search for books by Author");
        System.out.println("3. Search for books by Genre");
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
            case 1: service.listAllBooks();                
                break;
            case 2: searchByAuthor();
                break;
            case 3: searchByGenre();
                    break;
            case 4: System.out.println("Exiting Book Management System.");
                break;
        
            default:
                break;
        }
    }

    private void searchByAuthor(){
        System.out.println("Enter author name:");
        String author = scanner.next();
       
        service.listBooksByAuthor(author);
    }

    private void searchByGenre(){
        System.out.println("Enter genre:");
        String genre = scanner.next();

        service.listBooksByGenre(genre);
    }

    private void adminMenu(){
        System.out.println("Please choose an option:");
        System.out.println("1. Add a book");
        System.out.println("2. Remove a book");
        System.out.println("3. List all books");
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
            case 1: addBook();                
                break;
            case 2: removeBook();
                break;
            case 3: service.listAllBooks();
                break;
            case 4: System.out.println("Exiting Book Management System.");
                break;
        
            default:
                break;
        }
    }

    private void addBook(){
        scanner = new Scanner(System.in);

        System.out.println("Enter book title:");
        String title = scanner.nextLine();
        System.out.println("Enter book author:");
        String author = scanner.nextLine();
        System.out.println("Enter book genre:");
        String genre = scanner.nextLine();
        
        Book book = new Book(title,author, genre);

        service.createBook(book);
    }

    private void removeBook(){
        if(service.listAllBooks()){
            System.out.println("Enter book ID to remove:");
            int id = -1;

            while(true){
                try{
                    id = scanner.nextInt();
                } catch (Exception e) {
                    scanner.next();    
                    System.out.println("Invalid input. Please try again.");
                    continue;
                }
                break;
            }

            if(id != -1) service.removeBook(id);
        }
    }
}
