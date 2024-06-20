package View;

import java.util.Scanner;

import Entity.Admin;
import Entity.User;
import Service.UserService;

public class MainView implements View {
	private User user;
	private Scanner scanner = new Scanner(System.in);
	private UserService service = new UserService();

	public MainView(User user){
		this.user = user;
	}
	
	@Override
	public void startView() {
		if(this.user == null){
			entryPage();
		} else {
			if(this.user instanceof Admin) {
				adminPage();
			} else {
				userPage();
			}
		}

	}

	private void entryPage(){
		scanner = new Scanner(System.in);
		while (true) {
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

				if(option >= 1 && option <= 3) break;
				else System.out.println("Invalid option. Please try again.");
			}

			if(option == 3){
				scanner.close();
				break;
			}

			view = (option == 2)? new RegisterView(user): new LoginView(user);
			
			view.startView();
		}

		scanner.close();

	}

	private void adminPage(){

		System.out.println("\nWelcome, Admin!");
		System.out.println("Please choose an option:");
		System.out.println("1. List Users");
		System.out.println("2. Manage Books");
		System.out.println("3. List Borrowings");
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
					adminPage();
					break;
			case 2: view = new BookView(user);
					view.startView();
					break;
			case 3: view = new LoanView(user);
					view.startView();
					break;
			default:
				break;
		}

		scanner.close();
	}

	private void userPage(){
		System.out.println("\nWelcome, " + user.getName());
		System.out.println("1. Go to the books area");
		System.out.println("2. Go to the loans area");
		System.out.println("3. Logout");

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

			if(option >=1 && option <=3) break;
			else System.out.println("Invalid option. Please try again.");
		}

		if(option == 3){
			this.user = null;
			this.startView();

			scanner.close();
			return;
		}

		switch (
			option
		) {
			case 1: view = new BookView(user);
					view.startView();
					break;
			case 2: view = new LoanView(user);
					view.startView();
					break;
			default:
				break;
		}

		scanner.close();

	}

}
