package mySelfRegistrationPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class IntroGender {

    public AppiumDriver<MobileElement> driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Male']")
    public MobileElement Male;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Female']")
    public MobileElement Female;
    @AndroidFindBy(xpath = "//*[@text='Introduction']")
    public MobileElement headerTitle;
    @AndroidFindBy(id = "com.commonfriend:id/btnLeft")
    public MobileElement backArrow;
    @AndroidFindBy(xpath = "//*[@text='2/6']")
    public MobileElement SecondPageNo;
    @AndroidFindBy(xpath = "//*[@text=\"What's your gender?\"]")
    public MobileElement secondPageQueTitle;
    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public MobileElement privacyText;






    public IntroGender(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectgender(MobileElement element) {
        element.click();
    }

    public String expectedgenderTitle="What's your gender?";

    public String expectedPrivacyText="Visible to your recommendations only";


}






