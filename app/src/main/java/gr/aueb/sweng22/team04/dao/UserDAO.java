package gr.aueb.sweng22.team04.dao;

import java.util.List;

import gr.aueb.sweng22.team04.model.User;

public interface UserDAO {

    void addUser(User user);

    User findUser(String email, String password);

    List<User> findAll();

    void delete(User user);
}
