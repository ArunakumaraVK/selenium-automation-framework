package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import drivers_factory.DriverFactory;
import utilities.ScreenshotUtils;

public class TestListener
        implements ITestListener {

    @Override
    public void onTestStart(
            ITestResult result) {

        System.out.println(
                "TEST STARTED: "
                        + result.getName());
    }

    @Override
    public void onTestSuccess(
            ITestResult result) {

        System.out.println(
                "TEST PASSED: "
                        + result.getName());
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        System.out.println(
                "TEST FAILED: "
                        + result.getName());

        try {

            ScreenshotUtils.captureScreenshot(
                    DriverFactory.getDriver(),
                    result.getName());

        } catch (Exception e) {

            System.out.println(
                    "Unable to capture screenshot: "
                            + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(
            ITestResult result) {

        System.out.println(
                "TEST SKIPPED: "
                        + result.getName());
    }
}