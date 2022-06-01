package gr.aueb.sweng22.team04.memorydao;

import java.util.ArrayList;
import java.util.List;

import gr.aueb.sweng22.team04.dao.UserDAO;
import gr.aueb.sweng22.team04.model.User;

public class UserDAOMemory implements UserDAO {
    protected static ArrayList<User> userEntities = new ArrayList<User>();

    @Override
    public void addUser(User user) {
        userEntities.add(user);
    }

    @Override
    public User findUser(String email, String password) {
        for(User user : userEntities){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        ArrayList<User> result = new ArrayList<User>();
        result.addAll(userEntities);
        return result;
    }

    @Override
    public void delete(User user) {
        userEntities.remove(user);
    }
}
