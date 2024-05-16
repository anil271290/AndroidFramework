package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class Questions {

    public AppiumDriver<MobileElement> driver;

    public Questions(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//*[@text='Questions']/../*[2]")
    public MobileElement quexpath;
    @AndroidFindBy(id = "com.commonfriend:id/imgCross")
    public MobileElement closeQuestions;
}
