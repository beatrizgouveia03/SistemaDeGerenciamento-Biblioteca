package View;

import java.util.Scanner;

public class MainView implements View {
	
	public static void main(String[] args) {
        MainView mainView = new MainView();

        mainView.startView();
    }
	
	@Override
	public void startView() {
		View view;
		int option = -1;
		boolean choose = false;
		Scanner scan = new Scanner(System.in);

		System.out.println("Welcome to the Library System!");
		System.out.println("Please choose an option:");
		System.out.println("1. Login as Librarian");
		System.out.println("2. Login as Member");
		System.out.println("3. Register as user");
		System.out.println("4. Exit");

		while(!choose){
			try{
				option = scan.nextInt();
			} catch (Exception e) {
				scan.next();
				System.out.println("Invalid input. Please try again.");
				continue;
			}

			if(option == 1 || option == 2 || option == 3) choose = true;
			else System.out.println("Invalid option. Please try again.");
		}

		if(option == 4) return;

		view = (option == 3)? new RegisterView(): new LoginView(option);
		
		view.startView();
	}

}
