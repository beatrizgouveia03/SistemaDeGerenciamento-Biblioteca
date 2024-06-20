package View;

import java.util.Scanner;

import Entity.User;
import Service.UserService;

public class LoginView implements View {
    /* Attributes */
    private User user;
    private Scanner scanner = new Scanner(System.in);
    private UserService service = new UserService();

    public LoginView(User user){
        this.user = user;       
    }

    /* Methods */
    public void startView() {
        System.out.println("\nWelcome to the Login area");
        System.out.println("Enter username:");
        String username = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        
        user = service.login(username, password);     
        
        MainView main = new MainView(user);
        main.startView();

        scanner.close();
    }
}
