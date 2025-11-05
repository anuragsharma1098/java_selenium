package day23_TestAnnotations_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardVsSoftAssertions {
	@Test
	public void hardAssertionExample() {
		System.out.println("Starting hard assertion example...");

		// Hard assertion using TestNG
		Assert.assertEquals("Hello", "Hello");
		System.out.println("First hard assertion passed.");

		// This assertion will fail and stop the test execution
		Assert.assertEquals("Hello", "Hi");
		System.out.println("This line will not be executed due to hard assertion failure.");
	}

	@Test
	public void softAssertionExample() {
		System.out.println("Starting soft assertion example...");

		// Soft assertion using TestNG
		org.testng.asserts.SoftAssert softAssert = new org.testng.asserts.SoftAssert();

		softAssert.assertEquals("Hello", "Hello");
		System.out.println("First soft assertion passed.");

		softAssert.assertEquals("Hello", "Hi");
		System.out.println("This line will be executed despite the soft assertion failure.");

		// Collate all soft assertion results
		softAssert.assertAll(); //mandatory to call at the end
	}
}
