package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BackgroundBdayTime {
    public AppiumDriver<MobileElement> driver;

    public BackgroundBdayTime(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//*[@text=\"AM\"]")
    public MobileElement AmXpath;

    @AndroidFindBy(xpath = "//*[@text=\"PM\"]")
    public MobileElement PmXpath;


}
