package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class Loginpage {

    public AppiumDriver<MobileElement> driver;

    @AndroidFindBy(id = "edtNumber")
    public MobileElement entermobile;

    @AndroidFindBy(id = "com.commonfriend:id/imgContinue")
    public MobileElement goerrow;


    public Loginpage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void entermono(String number)

    {
        entermobile.sendKeys(number);
    }

    public void continuebutton() {
        goerrow.click();
    }


}
