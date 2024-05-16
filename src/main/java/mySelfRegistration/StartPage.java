package mySelfRegistration;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.PageFactory;

public class    StartPage {
    public AppiumDriver<MobileElement> driver;

    @AndroidFindBy(id = "com.commonfriend:id/imgPlayButton")
    public MobileElement clickImoji;
    @AndroidFindBy(xpath = "//*[@text='Usual turnaround time is 72 hours.']/../*[7]")
    public MobileElement secondImoji;

    @AndroidFindBy(id = "com.commonfriend:id/btnCancel")
    public MobileElement crossBtn;

    @AndroidFindBy(xpath = "//*[@text='People looking to get married.']")
    public MobileElement ringTextXpath;
    @AndroidFindBy(xpath = "//*[@text='Usual turnaround time is 72 hours.']")
    public MobileElement timeMeterXpath;
    @AndroidFindBy(xpath = "//*[@text='To maintain a balanced gender ratio\n" +
            "and ensure genuine profiles.']")
    public MobileElement dollorTextXpath;
    @AndroidFindBy(xpath = "//*[@text='We are new! We want your support\n" +
            "and patience. ']")
    public MobileElement namasteTextXpath;
    @AndroidFindBy(xpath = "//*[@text='Who is it for?']")
    public MobileElement startPageScreenTitle;
    @AndroidFindBy(xpath = "//*[@text='If required, I shall use this number\n" +
            "to get in touch.']")
    public MobileElement startPageMiniTitle;
    @AndroidFindBy(xpath = "//*[@text='I will send you a text with a verification code.']")
    public MobileElement verificationText;
    @AndroidFindBy(xpath = "//*[@text=\"By login in you agree to my 'Terms' and 'Privacy Policy'\"]")
    public MobileElement privacyPolicyText;

    @AndroidFindBy(id = "btnNext")
    public MobileElement firstButton;
    @AndroidFindBy(id = "com.commonfriend:id/txtMsg")
    public MobileElement profileSelectionText;
    @AndroidFindBy(xpath = "//*[@text='Me']")
    public MobileElement MyselfButton;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Someone')]")
    public MobileElement SomeOneButton;
    @AndroidFindBy(xpath = "//*[@text='%s' and @resource-id='com.commonfriend:id/txtCulture']/../android.widget.ImageView")
    public MobileElement selectCity;

    public StartPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickButton() {
        firstButton.click();
    }
}
