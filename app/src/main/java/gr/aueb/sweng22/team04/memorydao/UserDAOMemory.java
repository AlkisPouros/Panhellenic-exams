package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.dao.UserDAO;
import gr.aueb.sweng22.team04.model.User;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Implementation of interface user DAO
 */

public class UserDAOMemory implements UserDAO {
    protected static ArrayList<User> userEntities = new ArrayList<User>();

    /**
     * adds a user to list
     * @param user
     */
    @Override
    public void addUser(User user) {
        userEntities.add(user);
    }

    /**
     * finds a user bases on the given email and password
     * @param email
     * @param password
     * @return a user based on the given email and password or null
     */
    @Override
    public User findUser(String email, String password) {
        for(User user : userEntities){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    /**
     * returns all the users
     * @return users
     */
    @Override
    public List<User> findAll() {
        ArrayList<User> result = new ArrayList<User>();
        result.addAll(userEntities);
        return result;
    }

    /**
     * deletes one user
     * @param user
     */
    @Override
    public void delete(User user) {
        userEntities.remove(user);
    }
}
