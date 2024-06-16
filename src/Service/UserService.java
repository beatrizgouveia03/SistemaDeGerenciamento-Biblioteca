package Service;

import DAO.DAO;
import DAO.GenericDAO;
import Entity.User;
import Exception.DAOException;

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

    public boolean login(String login, String password){
        try{
            for(User u : userDao.findAll(u -> u.getLogin().equals(login))){
                if(u.getPassword().equals(password)){
                    System.out.println("Login successful!");
                    return true;
                }
            }
        } catch (DAOException e){
            System.out.println("Error logging in: " + e.getMessage());
        }

        return false;

    }

}
