package day22_TestNG_Intro;

import org.testng.annotations.Test;

/*
 * 1) open app
 * 2) login app
 * 3) logout app
*/

public class FirstTestCase {
   @Test()
    void openapp() {
        System.out.println("open app...");
    }

    @Test(priority=3)
    void login() {
        System.out.println("login app...");
    }

    @Test(priority=1)
    void logout() {
        System.out.println("logout app...");
    }
}
