package gr.aueb.sweng22.team04.dao;

import java.util.List;

import gr.aueb.sweng22.team04.model.User;

/**
 * @author Petovits Petros
 * @author Pouros Alkiviadis
 * @author Rousas Christos
 *
 * Interface for user DAO Memory and methods to access it
 */

public interface UserDAO {

    /**
     * adds a user to list
     * @param user
     */
    void addUser(User user);

    /**
     * finds a user bases on the given email and password
     * @param email
     * @param password
     * @return a user based on the given email and password
     */
    User findUser(String email, String password);

    /**
     * returns all the users
     * @return users
     */
    List<User> findAll();

    /**
     * deletes one user
     * @param user
     */
    void delete(User user);
}
