package View;

import java.util.Scanner;

import Entity.Admin;
import Entity.User;
import Service.UserService;

public class LoginView implements View {
    /* Attributes */
    private UserService service = new UserService();
    private Integer sessionType;

    public LoginView(int type){
        this.sessionType = type;        
    }

    /* Methods */
    public void startView() {
       switch (sessionType) {
        case 1: loginAdmin();           
                break;
        case 2: loginUser();
                break;      
        default:
            break;
       }
    }

    private void loginAdmin(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Login as Admin");
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        
        service.login(username, password, sessionType);       
    }

    private void loginUser(){
        System.out.println("Login as User");
    }
}
