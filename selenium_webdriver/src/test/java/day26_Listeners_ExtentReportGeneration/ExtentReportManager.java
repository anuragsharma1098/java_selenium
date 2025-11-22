package day26_Listeners_ExtentReportGeneration;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {

	public ExtentSparkReporter extentSparkReporter;
	public ExtentReports extentReports;
	public ExtentTest extentTest;

	public void onStart(ITestContext context) {
		extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");
		extentSparkReporter.config().setDocumentTitle("Automation Test Report");
		extentSparkReporter.config().setReportName("Functional Test Report");
		extentSparkReporter.config().setTheme(Theme.DARK);

		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		extentReports.setSystemInfo("Computer name", "localhost");
		extentReports.setSystemInfo("Environment", "QA");
		extentReports.setSystemInfo("Tester Name", "John Doe");
		extentReports.setSystemInfo("OS", "Windows 11");
		extentReports.setSystemInfo("Browser", "Chrome");
	}

	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.INFO, "Test Case Started is " + result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.PASS, "Test Case Passed is " + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.FAIL, "Test Case Failed is " + result.getName());
		extentTest.log(Status.FAIL, "Test Case Failed is " + result.getThrowable());
//		// capture screenshot
//		String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png";
//		extentTest.addScreenCaptureFromPath(screenshotPath);
	}

	public void onTestSkipped(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
		extentTest.log(Status.SKIP, "Test Case Skipped is " + result.getName());
	}

	public void onFinish(ITestContext context) {
		extentReports.flush();
	}
}
