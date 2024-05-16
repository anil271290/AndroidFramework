package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class CheckList {

    public AppiumDriver<MobileElement> driver;

    @AndroidFindBy(id = "btnSave")
    public MobileElement savechecklistbutton;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Vegan\")")
    public MobileElement scrolllling;



    public CheckList(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void checklistsave() {
        savechecklistbutton.click();
    }

    public void scroll() {
        scrolllling.getText();
    }


}
