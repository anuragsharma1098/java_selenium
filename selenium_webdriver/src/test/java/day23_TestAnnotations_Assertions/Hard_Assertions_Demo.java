package day23_TestAnnotations_Assertions;

import org.testng.annotations.Test;
import org.testng.Assert;

public class Hard_Assertions_Demo {
	@Test
	public void testMethod1() {
		System.out.println("Starting testMethod1");

		// First assertion
		Assert.assertEquals(5, 5);
		System.out.println("First assertion passed");

		// Second assertion
		Assert.assertTrue(true);
		System.out.println("Second assertion passed");

		// Third assertion
		Assert.assertNotNull("Hello");
		System.out.println("Third assertion passed");

		System.out.println("Ending testMethod1");
	}
}
