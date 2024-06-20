package View;

import java.util.Scanner;

import Entity.Admin;
import Entity.User;
import Service.UserService;

public class LoginView implements View {
    /* Attributes */
    private UserService service = new UserService();
    private Scanner scanner = new Scanner(System.in);
    private User user;

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
