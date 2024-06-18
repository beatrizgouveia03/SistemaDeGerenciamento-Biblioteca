package Service;

import DAO.DAO;
import Entity.User;
import Entity.Admin;
import Entity.Client;
import DAO.GenericDAO;
import Exception.DAOException;
import Exception.PermissionException;
import Exception.ServiceException;

public class UserService {
    /* Attributes */
    private DAO<User> userDao = new GenericDAO<>();

    /* Methods */
    public void createUser(User user) {
        try{
            userDao.save(user);
        } catch (DAOException e){
            System.out.println("Error creating user: " + e.getMessage());
        }
    }

    public void login(String login, String password, Integer userType){
        try{
            for(User u : userDao.findAll(u -> u.getLogin().equals(login))){
                if(u.getPassword().equals(password)){
                    if((userType == 1 && u instanceof Admin) || (userType == 2 && u instanceof Client)){
                        System.out.println("Login successful!");
                        return;
                    }
                    else {
                        throw new PermissionException("Invalid type of user");
                    }
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

}
