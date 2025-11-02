package day22_TestNG;

import org.testng.annotations.Test;

/*
 * 1) open app
 * 2) login app
 * 3) logout app
 */

public class FirstTestCase {
   @Test(priority=1)
    void openapp() {
        System.out.println("open app...");
    }

    @Test(priority=2)
    void login() {
        System.out.println("login app...");
    }

    @Test(priority=3)
    void logout() {
        System.out.println("logout app...");
    }
}
