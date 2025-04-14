/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {

    private Login login;

    @BeforeEach
    public void setUp() {
        // Initialize the Login object before each test
        login = new Login("kyl_1", "ch&&sec@ke99", "+27838968976");
    }

    @Test
    public void testCheckUserName_Valid() {
        login = new Login("kyl_1", "ch&&sec@ke99", "+27838968976");
        assertTrue(login.checkUserName(), "Welcome kyl_1 it is great to see you.");
    }

    @Test
    public void testCheckUserName_Invalid() {
        login = new Login("kyle!!!", "ch&&sec@ke99", "+27838968976");
        assertFalse(login.checkUserName(), "Username is not correctly formatted,please ensure your username contains an underscore and is no more than five characters in length.");
    }

    @Test
    public void testCheckPasswordComplex_Valid() {
        login = new Login("kyl_1", "ch&&sec@ke99", "+27838968976");
        assertTrue(login.checkPasswordComplex("ch&&sec@ke99"), "Password successfully captured.");
    }

    @Test
    public void testCheckPasswordComplex_Invalid() {
        login = new Login("kyl_1", "password", "+27838968976");
        assertFalse(login.checkPasswordComplex("password"), "Password is not correctly formatted,please ensure that the password contains atleast eight characters,a capital letter,a number and a special character.");
    }

    @Test
    public void testCheckCellPhoneNumber_Valid() {
        login = new Login("kyl_1", "ch&&sec@ke99", "+27838968976");
        assertTrue(login.checkCellPhoneNumber(), "Cell number successfully captured.");
    }

    @Test
    public void testCheckCellPhoneNumber_Invalid() {
        login = new Login("kyl_1", "ch&&sec@ke99", "08966553");
        assertFalse(login.checkCellPhoneNumber(), "Cell number is incorectly formatted or does not contain an international code,please correct the number and try again.");
    }
}
