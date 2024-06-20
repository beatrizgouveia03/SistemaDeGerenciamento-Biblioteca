package View;

import java.util.Scanner;

import Entity.Admin;
import Entity.User;
import Service.UserService;

public class MainView implements View {
	private User user;
	private Scanner scanner;
	private UserService service;
	
	public static void main(String[] args) {
        MainView mainView = new MainView();

        mainView.startView();
    }
	
	@Override
	public void startView() {
		if(this.user == null){
			entryPage();
		} else {
			if(this.user instanceof Admin) {
				adminPage();
			}
		}

	}

	private void entryPage(){
		this.scanner = new Scanner(System.in);

		System.out.println("Welcome to the Library System!");
		System.out.println("Please choose an option:");
		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.println("3. Exit");
		
		int option;
		View view;
		
		while(true){
			try{
				option = scanner.nextInt();
			} catch (Exception e) {
				scanner.next();
				System.out.println("Invalid input. Please try again.");
				continue;
			}

			if(option == 1 || option == 2) break;
			else System.out.println("Invalid option. Please try again.");
		}

		if(option == 3){
			scanner.close();
			return;
		}

		view = (option == 2)? new RegisterView(user): new LoginView(user);
		
		view.startView();

		scanner.close();

	}

	private void adminPage(){
		this.scanner = new Scanner(System.in);

		System.out.println("Welcome, Admin!");
		System.out.println("Please choose an option:");
		System.out.println("1. Manage Users");
		System.out.println("2. Manage Books");
		System.out.println("3. Manage Borrowings");
		System.out.println("4. Logout");

		int option;
		View view;
		
		while(true){
			try{
				option = scanner.nextInt();
			} catch (Exception e) {
				scanner.next();
				System.out.println("Invalid input. Please try again.");
				continue;
			}

			if(option >=1 && option <=4) break;
			else System.out.println("Invalid option. Please try again.");
		}

		if(option == 4){
			this.user = null;
			this.startView();

			scanner.close();
			return;
		}

		switch (
			option
		) {
			case 1: service.listAllUsers();				
				break;
			case 2: view = new BookView(user);
					view.startView();
					break;
			case 3: view = new LoanView();
					view.startView();
					break;
			default:
				break;
		}

		scanner.close();
	}

}
