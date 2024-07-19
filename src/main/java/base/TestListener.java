package base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.asserts.SoftAssert;

import java.util.Objects;

import static base.ExtentReport.getTest;

public class TestListener extends AppiumBase implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " test case started");
        ExtentReport.startTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("The name of the test case passed is: " + result.getMethod().getMethodName());
        ExtentTest test = getTest();
        if (test != null) {
            test.log(Status.PASS, "Test passed");
            test.log(Status.INFO, "Additional log message here");
        } else {
            System.err.println("ExtentTest object is null in onTestSuccess.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("The name of the test case skipped is: " + result.getMethod().getMethodName());
        ExtentTest test = getTest();
        if (test != null) {
            test.log(Status.SKIP, "Test Skipped");
        } else {
            System.err.println("ExtentTest object is null in onTestSkipped.");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test case '" + result.getMethod().getMethodName() + "' failed");

        Throwable throwable = result.getThrowable();
        String failureMessage = "Test failed";

        if (throwable instanceof AssertionError) {
            failureMessage = "Assertion failed: " + throwable.getMessage();
        } else {
            failureMessage = "Exception: " + throwable.getMessage();
        }

        ExtentTest test = getTest();
        if (test != null) {
            test.log(Status.FAIL, failureMessage);

            Object ob = result.getInstance();
            AppiumDriver<MobileElement> driver = ((AppiumBase) ob).getAppiumDriver();

            if (driver != null) {
                try {
                    String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
                    test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
                } catch (Exception e) {
                    e.printStackTrace();
                    test.log(Status.FAIL, "Screenshot capture failed due to: " + e.getMessage());
                }
            } else {
                System.err.println("AppiumDriver is null in onTestFailure.");
                test.log(Status.FAIL, "AppiumDriver is null, could not capture screenshot.");
            }

            if (throwable instanceof AssertionError) {
                String assertionMessage = "Assertion failed: " + throwable.getMessage();
                test.log(Status.FAIL, assertionMessage);
            }
        } else {
            System.err.println("ExtentTest object is null in onTestFailure.");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("The " + context.getName() + " is Finished");
        ExtentReport.endTest();
        ExtentReport.getInstance().flush();
    }

    public static void logToExtentReport(String logMessage) {
        ExtentTest test = getTest();
        if (test != null) {
            test.log(Status.INFO, logMessage);
        } else {
            System.err.println("ExtentTest object is null in logToExtentReport.");
        }
    }

    public static void handleSoftAssertions(SoftAssert softAssert) {
        try {
            softAssert.assertAll();
        } catch (AssertionError e) {
            String assertionMessage = "Soft Assertion failed: " + e.getMessage();
            ExtentTest test = getTest();
            if (test != null) {
                test.log(Status.FAIL, assertionMessage);
            } else {
                System.err.println("ExtentTest object is null in handleSoftAssertions.");
            }
        }
    }



}
