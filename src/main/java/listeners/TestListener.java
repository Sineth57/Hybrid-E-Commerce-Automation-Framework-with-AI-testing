package listeners;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ExtentManager;
import utils.ScreenshotUtils;

import java.io.IOException;

public class TestListener implements ITestListener {

    private static ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        ExtentManager.getExtentReports();
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = ExtentManager.getExtentReports().createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failed");

        WebDriver driver = ((BaseTest) result.getInstance()).driver;
        String screenshotPath = ScreenshotUtils.captureScreenshot(driver, result.getMethod().getMethodName());

        test.fail("Failure screenshot",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getExtentReports().flush();
    }
}
