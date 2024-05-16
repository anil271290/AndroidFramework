package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;


public class EditProfile {

    public AppiumDriver<MobileElement> driver;


    @AndroidFindBy(id = "btnSave")
    public MobileElement savebutton;
    @AndroidFindBy(xpath = "//*[@resource-id='com.commonfriend:id/imgEditRelationShip']")
    public MobileElement relationshipeditbtn;
    @AndroidFindBy(xpath = "//*[@text='Divorced']")
    public MobileElement divorcebtn;
    @AndroidFindBy(xpath = "//*[@text='Yes']")
    public MobileElement yesbtn;
    @AndroidFindBy(id = "com.commonfriend:id/btnCross")
    public MobileElement crossbtn;
    @AndroidFindBy(xpath = "//*[@text='Gender']")
    public MobileElement textGender;
    @AndroidFindBy(xpath = "//*[@text='Line of work']")
    public MobileElement WorkHeaderText;


    public EditProfile(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void clicksavebtn() {
        savebutton.click();
    }

    public void clickOnEditRelationship(){
        relationshipeditbtn.click();
        divorcebtn.click();
        yesbtn.click();
        crossbtn.click();
    }
}

