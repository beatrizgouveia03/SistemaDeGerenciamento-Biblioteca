package Service;

import Entity.User;
import Entity.Admin;
import Entity.Book;
import Entity.Client;
import DAO.GenericDAO;
import Exception.DAOException;
import Exception.PermissionException;
import Exception.ServiceException;

public class UserService {
    /* Attributes */
    private GenericDAO<User> userDao = new GenericDAO<>();

    /* Methods */
    public void createUser(User user) {
        try{
            userDao.save(user);

        } catch (DAOException e){
            System.out.println("Error creating user: " + e.getMessage());
        }
    }

    public void login(String login, String password){
        try{
            for(User u : userDao.findAll(u -> u.getLogin().equals(login))){
                System.out.println("Found 1");
                if(u.getPassword().equals(password)){
                    System.out.println("Foudn 2");
                    System.out.println("Login successful!");
                    return;
                } else {
                    throw new PermissionException("Invalid username or password");
                }
            }
        } catch (DAOException e){
            System.out.println("Error logging in: " + e.getMessage());
        } catch (ServiceException e){
            System.out.println("Error logging in: " + e.getMessage());
        }
    }

    public void listAllUsers(){
        try{
            for (User user : userDao.findAll()){
                System.out.println(user.toString());
            }
        } catch (DAOException e){
            System.out.println("Error listing users: " + e.getMessage());
        }
    }

}
