package day24_DependencyMethods_GroupingTests;

import org.testng.annotations.Test;

public class PaymentTests {
	@Test(priority = 1, groups = { "sanity", "regression", "functional" })
	void paymentInRupee() {
		System.out.println("Payment by rupee");
		// Assert.assertTrue(true);
	}

	@Test(priority = 2, groups = { "sanity", "regression", "functional" })
	void paymentInDollar() {
		System.out.println("Payment by dollar");
		// Assert.assertTrue(true);
	}
}
