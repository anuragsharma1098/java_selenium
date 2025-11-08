package day24_DependencyMethods_GroupingTests;

import org.testng.annotations.Test;

public class SignUpTests {
	@Test(priority = 1, groups = { "regression" })
	void singupByEmail() {
		System.out.println("SignUp by Email");
		// Assert.assertTrue(true);
	}

	@Test(priority = 2, groups = { "regression" })
	void singupByFacebook() {
		System.out.println("SignUp by Facebook");
		// Assert.assertTrue(true);
	}

	@Test(priority = 3, groups = { "regression" })
	void singupByX() {
		System.out.println("SignUp by X");
		// Assert.assertTrue(true);
	}
}
