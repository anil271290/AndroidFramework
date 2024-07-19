package mySelfRegistrationPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class Settings {
    public AppiumDriver<MobileElement> driver;

    public Settings(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.commonfriend:id/btnSettings")
    public MobileElement settingbtn;
    @AndroidFindBy(xpath = "//*[@text='Priority']")
    public MobileElement prioritybtn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Profile']")
    public MobileElement editprofilebtn;
    @AndroidFindBy(id = "com.commonfriend:id/imgEditBirth")
    public MobileElement birtheditbtn;
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Change now']")
    public MobileElement confirmbtn;
    @AndroidFindBy(xpath = "//*[@text='Questions']")
    public MobileElement questionbtn;
    @AndroidFindBy(id = "com.commonfriend:id/btnCross")
    public MobileElement crossbtn;
    @AndroidFindBy(xpath = "//*[@text='Logout']")
    public MobileElement logoutBtn;


    public void clickonsetting() {
        settingbtn.click();
    }

    public void clickonpriority() {
        prioritybtn.click();
    }

    public void clickOnEditProfile() {
        editprofilebtn.click();
    }

    public void editBirth() {
        birtheditbtn.click();
        confirmbtn.click();
    }
    public void clickOnQuestions(){
        questionbtn.click();
    }
    public void close(){
        crossbtn.click();
    }


}
