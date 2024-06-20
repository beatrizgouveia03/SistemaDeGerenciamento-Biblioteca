package Service;

import Entity.User;
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

    public User login(String login, String password){
        try{
            for(User u : userDao.findAll(u -> u.getLogin().equals(login))){
                if(u.getPassword().equals(password)){
                    System.out.println("Login successful!");
                    return u;
                } else {
                    throw new PermissionException("Invalid username or password");
                }
            }
        } catch (DAOException e){
            System.out.println("Error logging in: " + e.getMessage());
        } catch (ServiceException e){
            System.out.println("Error logging in: " + e.getMessage());
        }

        return null;
    }

    public void listAllUsers(){
        try{
            for (User user : userDao.findAll()){
                System.out.println(user.toString());
            }
        } catch (Exception e){
            System.out.println("Error listing users: " + e.getMessage());
        }
    }

}
