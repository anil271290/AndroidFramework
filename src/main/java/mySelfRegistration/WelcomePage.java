package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

    public AppiumDriver<MobileElement> driver;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    public MobileElement allow;



    public WelcomePage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void permission1() {
        allow.click();
    }


}
