package day23_TestAnnotations_Assertions;

import org.testng.annotations.Test;
import org.testng.Assert;

public class AssertionsDemo {
	@Test
	public void test1() {
		String actualTitle = "Home - My Store";
		String expectedTitle = "Home - My Store";

		// Hard Assertion
		Assert.assertEquals(actualTitle, expectedTitle, "Title does not match!");

		System.out.println("This line will be executed if the assertion passes.");

//		// Assert using if else
//		if (actualTitle.equals(expectedTitle)) {
//			System.out.println("Title matches as expected.");
//			Assert.assertTrue(true);
//		} else {
//			System.out.println("Title does not match!");
//			Assert.fail("Title does not match!");
//			Assert.assertTrue(false);
//		}
	}
}
