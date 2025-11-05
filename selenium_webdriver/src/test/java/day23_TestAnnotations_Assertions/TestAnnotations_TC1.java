package day23_TestAnnotations_Assertions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestAnnotations_TC1 {
	@BeforeMethod
	void login() {
		System.out.println("Login Test Case");
	}

	@Test(priority = 1)
	void search() {
		System.out.println("Search Test Case");
	}

	@Test(priority = 2)
	void advancedSearch() {
		System.out.println("Advanced Search Test Case");
	}

	@AfterMethod
	void logout() {
		System.out.println("Logout Test Case");
	}

}
