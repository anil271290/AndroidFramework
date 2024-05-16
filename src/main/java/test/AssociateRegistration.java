package test;

import base.AppiumBase;
import base.ExtentReport;
import base.TestListener;
import familyRegistration.AboutAssociate;
import mySelfRegistration.IntroName;
import mySelfRegistration.Loginpage;
import mySelfRegistration.StartPage;
import mySelfRegistration.WelcomePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import util.OTPService;
import util.Utils;

import java.net.MalformedURLException;
import java.util.Random;

public class AssociateRegistration extends AppiumBase {

    protected static final Logger logger = LogManager.getLogger(MySelfRegistration.class);


    @BeforeTest
    public void launchApp() throws MalformedURLException {
        setup();
        // setupEmulator();
    }

    @Test(priority = 1, description = "StartPage")
    public void StartPage() throws InterruptedException {
        StartPage sp = new StartPage(getAppiumDriver());
        Loginpage log = new Loginpage(getAppiumDriver());

        OTPService ot = new OTPService(getAppiumDriver());
        Utils ut = new Utils(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Who is it for?", sp.startPageScreenTitle.getText());
        TestListener.logToExtentReport("StartPage Screen Title is :" + sp.startPageScreenTitle.getText());

        ut.waitForElementWithFluentWait(sp.firstButton);
        Thread.sleep(2000);
        sp.clickButton();
        softAssert.assertEquals("If required, I shall use this number\n" +
                "to get in touch.", sp.startPageMiniTitle.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("Text below title is : " + sp.startPageMiniTitle.getText());
        softAssert.assertEquals("I will send you a text with a verification code.", sp.verificationText.getText());
        TestListener.handleSoftAssertions(softAssert);
        TestListener.logToExtentReport("VerificationCode Text below Enter Mobile Field is " + sp.verificationText.getText());

        /*Random Number Generator*/

        Random random = new Random();
        int randomSuffix = 10000000 + random.nextInt(90000000); // Generate a random 8-digit suffix
        String mobileNumber = "61" + String.valueOf(randomSuffix);
        log.entermono(mobileNumber);
        TestListener.logToExtentReport("RandomMobile Number is : +91-" + mobileNumber);
        takeScreenshot("mobileNo");
        Thread.sleep(2000);
        log.continuebutton();
        Thread.sleep(4000);
        try {
            softAssert.assertEquals("By login in you agree to my 'Terms' and 'Privacy Policy'", sp.privacyPolicyText.getText());
            TestListener.handleSoftAssertions(softAssert);
            TestListener.logToExtentReport("Assertion Passed");
        } catch (AssertionError e) {
            ExtentReport.getTest().fail("Assertion failed: " + e.getMessage());
        }

        TestListener.logToExtentReport("PrivacyPolicy Text is " + sp.privacyPolicyText.getText());


        // Get OTP from server
        String countryCode = "+91";
        String phonNumber = mobileNumber;
        String otp = OTPService.getOTPFromServer(countryCode, phonNumber);
        TestListener.logToExtentReport("OTP received from server is: " + otp);

        // Enter OTP
        ot.enterOTP(otp);


        softAssert.assertAll();


    }
    @Test(priority = 2, description = "IntroductionName")
    public void introduction() {
        StartPage sp = new StartPage(getAppiumDriver());
        IntroName name = new IntroName(getAppiumDriver());
        Utils ut = new Utils(getAppiumDriver());
        WelcomePage wp = new WelcomePage(getAppiumDriver());
        SoftAssert softAssert = new SoftAssert();


        sp.SomeOneButton.click();
        wp.permission1();


    }
    @Test
    public void associateDetails(){
        AboutAssociate ab=new AboutAssociate(getAppiumDriver());

        ab.FirstNamePlaceHolder.sendKeys("");
        ab.LastNamePlaceHolder.sendKeys("");
        continueButton();
        ab.maleBtn.click();
        ab.ScreenBreakerContinueBtn.click();
        ab.permissionBtn.click();
        continueButton();
        ab.ProfessionPlaceHolder.click();
        ab.SelectedProfession.click();
        ab.DesignationPlaceHolder.click();
        ab.EditDesignation.sendKeys("Software");
        ab.SelectSoftwareDeveloper.click();
        ab.IndustryPlaceHolder.click();
        ab.SelectIndustry.click();




    }


}
