/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import com.mycompany.chatapp.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {
    

    @Test
    public void testUsernameCorrectlyFormatted() {
        Login User = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(User.checkUserName());
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login User = new Login("Kyle", "Smith", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(User.checkUserName());
    }

    @Test
    public void testUsernameCorrectMessage() {
        Login User = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Welcome Kyle Smith it is great to see you again.", User.registerUser());
    }

    @Test
    public void testUsernameIncorrectMessage() {
        Login User = new Login("Kyle", "Smith", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Username is not correctly formatted; please ensure that your "
                   + "username contains an underscore and is no more than five "
                   + "characters in length.", User.registerUser());
    }

  

    @Test
    public void testPasswordMeetsComplexity() {
        Login User = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(User.checkPasswordComplexity());
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        Login User = new Login("Kyle", "Smith", "kyl_1", "password", "+27838968976");
        assertFalse(User.checkPasswordComplexity());
    }

    @Test
    public void testPasswordIncorrectMessage() {
        Login User = new Login("Kyle", "Smith", "kyl_1", "password", "+27838968976");
        assertEquals("Password is not correctly formatted; please ensure that the "
                   + "password contains at least eight characters, a capital letter, "
                   + "a number, and a special character.", User.registerUser());
    }


    @Test
    public void testCellPhoneCorrectlyFormatted() {
        Login User = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(User.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        Login User = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "08966553");
        assertFalse(User.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneIncorrectMessage() {
        Login User = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "08966553");
        assertEquals("Cell number is incorrectly formatted or does not contain an "
                   + "international code; please correct the number and try again.",
                   User.registerUser());
    }

    

    @Test
    public void testLoginSuccessful() {
        Login User = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(User.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        Login User = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(User.loginUser("kyl_1", "wrongPassword"));
    }

    @Test
    public void testLoginStatusSuccessMessage() {
        Login User = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Welcome Kyle Smith it is great to see you again.",
                     User.returnLoginStatus(true));
    }

    @Test
    public void testLoginStatusFailedMessage() {
        Login User = new Login("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertEquals("Username or password incorrect, please try again.",
                     User.returnLoginStatus(false));
    }
}
