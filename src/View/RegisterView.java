package View;

import java.util.Scanner;

import Entity.Admin;
import Entity.Client;
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
        System.out.println("Welcome to the signing area");
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your username:");
        String login = scanner.nextLine();
        System.out.println("Enter your password:");
        String password = scanner.nextLine();
        System.out.println("Are you a admin?(Y/N)");
        String isAdmin = scanner.nextLine();
        isAdmin.toLowerCase();

        if(isAdmin.contains("y")) user = new Admin(name, login, password);
        else user = new Client(name, login, password);

        service.createUser(user);
        user = service.login(login, password);

        MainView main = new MainView(user);

        main.startView();
    }
}
