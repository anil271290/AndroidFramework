package mySelfRegistrationPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class BackgroundHeight {
    public AppiumDriver<MobileElement> driver;

    public BackgroundHeight(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath = "//*[@text='How tall are you?']")
    public MobileElement HeightScreenQueTitle;
    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public MobileElement heightPrivacyText;
    @AndroidFindBy(xpath = "//*[@text='4/6']")
    public MobileElement FourthPageNo;
    @AndroidFindBy(xpath = "//*[@text='Inches']")
    public MobileElement HeightContainerText;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='0\"']")
    public MobileElement DefaultInchXpath;
    @AndroidFindBy(xpath = "//android.widget.NumberPicker[2]/*[2]")
    public MobileElement InchCentreXpath;
    @AndroidFindBy(xpath = "//android.widget.NumberPicker[2]/*[3]")
    public MobileElement InchXpath;

    public String expectedHeightQue="How tall are you?";

}
