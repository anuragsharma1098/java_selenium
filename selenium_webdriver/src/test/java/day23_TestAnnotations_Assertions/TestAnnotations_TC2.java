package day23_TestAnnotations_Assertions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAnnotations_TC2 {
	@BeforeClass
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

	@AfterClass
	void logout() {
		System.out.println("Logout Test Case");
	}
}
