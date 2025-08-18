package Testng;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("==== Test Suite Started: " + context.getName() + " ====");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("==== Test Suite Finished: " + context.getName() + " ====");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("[START] Test Method: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("[PASS] Test Method: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("[FAIL] Test Method: " + result.getName());
        System.out.println("Reason: " + result.getThrowable());
        // Optionally capture screenshot here
        Object testClass = result.getInstance();
        WebDriver driver = ((ParaTesting) testClass).driver; // ensure ParaTesting has public WebDriver driver;
        ScreenshotUtil.capture(driver, result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("[SKIP] Test Method: " + result.getName());
    }
}
