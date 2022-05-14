package gr.aueb.sweng22.team04.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

    User user;
    @Before
    public void setUp() throws Exception {
        user = new User("1234", "hello@gmail.com", "Candidate");
    }

    @Test
    public void loginUser() {
        assertTrue(user.loginUser("hello@gmail.com", "1234"));
        assertFalse(user.loginUser("hi@gmail.com", "1234"));
        assertFalse(user.loginUser("hello@gmail.com", "123456"));
    }

    @Test
    public void signUp() {
        assertEquals("1234", user.getPassword());
        assertEquals("hello@gmail.com", user.getEmail());
        assertEquals("Candidate", user.getUserMode());
        assertNotEquals("123456", user.getPassword());

    }
}