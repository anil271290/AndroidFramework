package mySelfRegistrationPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class YourProgress {

    public AppiumDriver<MobileElement> driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Profile']")
    public MobileElement editprofile;
    @AndroidFindBy(id = "com.commonfriend:id/btnAdd")
    public MobileElement continuebtn;
    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    public MobileElement permissionbtn;
    @AndroidFindBy(xpath = "//*[@text='Background']")
    public MobileElement backgroundBtn;

    public YourProgress(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void editprofilebutton() {
        editprofile.click();
    }

    public void continuBtn() {
        continuebtn.click();
           }
    public void backGroundClick(){
        backgroundBtn.click();
    }

}
