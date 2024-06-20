package View;

import java.util.Scanner;

import Entity.Admin;
import Entity.User;
import Service.UserService;

public class LoginView implements View {
    /* Attributes */
    private UserService service = new UserService();
    private User user;

    public LoginView(User user){
        this.user = user;       
    }

    /* Methods */
    public void startView() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Login area");
        System.out.println("Enter username:");
        String username = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        
        user = service.login(username, password);     
        
        scanner.close();
    }
}
