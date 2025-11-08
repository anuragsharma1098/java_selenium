package day24_DependencyMethods_GroupingTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {
	@Test(priority = 1, groups = { "sanity" })
	void loginByEmail() {
		System.out.println("Login by Email");
		// Assert.assertTrue(true);
	}

	@Test(priority = 2, groups = { "sanity" })
	void loginByFacebook() {
		System.out.println("Login by Facebook");
		// Assert.assertTrue(true);
	}

	@Test(priority = 3, groups = { "sanity" })
	void loginByX() {
		System.out.println("Login by X");
		// Assert.assertTrue(true);
	}
}
