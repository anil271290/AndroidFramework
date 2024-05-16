package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class Recommendations {
    public AppiumDriver<MobileElement> driver;

    public Recommendations(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//*[@resource-id='com.commonfriend:id/llNoProfiles']/*[1]")
    public MobileElement crossImageLogo;
    @AndroidFindBy(id = "com.commonfriend:id/btnAction")
    public MobileElement okbtn;
    @AndroidFindBy(xpath = "//*[@text='Send Request']")
    public MobileElement sendrequest;


}
