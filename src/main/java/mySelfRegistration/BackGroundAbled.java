package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class BackGroundAbled {

    public AppiumDriver<MobileElement> driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='No']")
    public MobileElement No;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Yes']")
    public MobileElement Yes;
    @AndroidFindBy(xpath = "//*[@text='Are you differently abled?']")
    public MobileElement HandicapScreenQueTitle;
    @AndroidFindBy(xpath = "//*[@text='5/6']")
    public MobileElement FifthPageNo;
    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public MobileElement HandicapPrivacyText;

    public BackGroundAbled(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public void ability(MobileElement element)
    {
        element.click();
    }

}

