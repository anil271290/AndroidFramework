package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

import java.security.PublicKey;

public class IntroName {
    public AppiumDriver<MobileElement> driver;
    @AndroidFindBy(id = "com.commonfriend:id/btnAdd")
    public MobileElement continue1;
    @AndroidFindBy(id = "com.commonfriend:id/txtTagLine")
    public MobileElement IntroHomeTitleText;

    @AndroidFindBy(id = "com.commonfriend:id/edtFirstName")
    public MobileElement fname;

    @AndroidFindBy(id = "com.commonfriend:id/edtLastName")
    public MobileElement lname;

    @AndroidFindBy(id = "com.commonfriend:id/btnContinue")
    public MobileElement cntn;

    @AndroidFindBy(xpath = "//*[@text='Sharma']")
    public MobileElement lastNameText;
    @AndroidFindBy(xpath = "//*[@text='Visible to your matches only']")
    public MobileElement privacyText;
    @AndroidFindBy(xpath = "//*[@text='Introduction']")
    public MobileElement headerTitle;
    @AndroidFindBy(id = "com.commonfriend:id/btnLeft")
    public MobileElement backArrow;
    @AndroidFindBy(xpath = "//*[@text='1/6']")
    public MobileElement FirstPageNo;
    @AndroidFindBy(xpath = "//*[@text=\"What's your name?\"]")
    public MobileElement firstPageQueTitle;

    public IntroName(AppiumDriver<MobileElement> driver) {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterfirstname(String startname) {
        fname.sendKeys(startname);
    }

    public void enterlastname(String endname) {

        lname.sendKeys(endname);
    }

    public void clkcont() {
        cntn.click();
    }

    public String expectedHomeTitleText="Let's start with an introduction.";
    public String expectedFirstPageQueTitle="What's your name?";
    public String expectedPrivacyText="Visible to your matches only";

}
