package day23_TestAnnotationsDemo;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C3 {
	@Test
	void pqr() {
		System.out.println("C3 class method pqr");
	}

	@AfterSuite
	void as() {
		System.out.println("After Suite method in C3 class");
	}

	@BeforeSuite
	void bs() {
		System.out.println("Before Suite method in C3 class");
	}

}
