package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import drivers_factory.DriverFactory;
import utilities.ExtentReportManager;
import utilities.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static ExtentReports extentReports =
            ExtentReportManager.getExtentReports();

    private static ThreadLocal<ExtentTest> extentTest =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test =
                extentReports.createTest(
                        result.getMethod().getMethodName());

        extentTest.set(test);

        System.out.println(
                "TEST STARTED: " +
                result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.get().pass("Test Passed");

        System.out.println(
                "TEST PASSED: " +
                result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println(
                "TEST FAILED: " +
                result.getMethod().getMethodName());

        extentTest.get().fail(result.getThrowable());

        try {

            String screenshotPath =
                    ScreenshotUtils.captureScreenshot(
                            DriverFactory.getDriver(),
                            result.getMethod().getMethodName());

            extentTest.get().fail(
                    "Screenshot on Failure",
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(screenshotPath)
                            .build());

        } catch (Exception e) {

            extentTest.get().fail(
                    "Unable to capture screenshot: "
                            + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extentTest.get().skip("Test Skipped");

        System.out.println(
                "TEST SKIPPED: " +
                result.getMethod().getMethodName());
    }

    @Override
    public void onFinish(ITestContext context) {

        extentReports.flush();

        System.out.println(
                "Extent Report generated successfully.");
    }
}