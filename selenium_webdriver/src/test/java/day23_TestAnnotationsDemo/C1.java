package day23_TestAnnotationsDemo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C1 {
	@Test
	void abc() {
		System.out.println("C1 class method abc");
	}

	@BeforeTest
	void bt() {
		System.out.println("Before Test method in C1 class");
	}
}
