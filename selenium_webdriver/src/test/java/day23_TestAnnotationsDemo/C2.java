package day23_TestAnnotationsDemo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class C2 {

	@Test
	void xyz() {
		System.out.println("C2 class method xyz");
	}

	@AfterTest
	void at() {
		System.out.println("After Test method in C2 class");
	}
}
