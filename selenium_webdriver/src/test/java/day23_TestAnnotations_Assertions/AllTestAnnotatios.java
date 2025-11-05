package day23_TestAnnotations_Assertions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllTestAnnotatios {
	@BeforeClass
	void login1() {
		System.out.println("Login Test Case");
	}

	@Test(priority = 1)
	void search1() {
		System.out.println("Search Test Case");
	}

	@Test(priority = 2)
	void advancedSearch1() {
		System.out.println("Advanced Search Test Case");
	}

	@AfterClass
	void logout1() {
		System.out.println("Logout Test Case");
	}

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

	@Test
	void abc() {
		System.out.println("class method abc");
	}

	@BeforeTest
	void bt() {
		System.out.println("Before Test method");
	}

	@Test
	void xyz() {
		System.out.println("class method xyz");
	}

	@AfterTest
	void at() {
		System.out.println("After Test method");
	}

	@Test
	void pqr() {
		System.out.println("class method pqr");
	}

	@AfterSuite
	void as() {
		System.out.println("After Suite method");
	}

	@BeforeSuite
	void bs() {
		System.out.println("Before Suite method");
	}

}
