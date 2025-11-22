package day26_Listeners_ExtentReportGeneration;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

	public void onStart(ITestContext context) {
		System.out.println("Execution started for the test suite: " + context.getName());
	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test started: " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed: " + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed: " + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped: " + result.getName());
	}

	public void onFinish(ITestContext context) {
		System.out.println("Execution finished for the test suite: " + context.getName());
	}
}
