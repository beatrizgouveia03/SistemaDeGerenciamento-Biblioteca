package View;

import java.util.Scanner;

import Entity.User;
import Service.UserService;

public class RegisterView implements View {
    /* Attributes */
    private Scanner scanner = new Scanner(System.in);
    private UserService service = new UserService();
    private User user;

    RegisterView(User user){
        this.user = user;
    }

    /* Methods */
    public void startView() {   
        System.out.println("Signing up new user");
        System.out.println("Enter your name:");
        String username = scanner.nextLine();
        System.out.println("Enter your username:");
        String login = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();

        user = new User(username, login, password);

        service.createUser(user);
        service.login(login, password);
    }
}
