package mySelfRegistrationPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class CheckList {

    public AppiumDriver<MobileElement> driver;

    @AndroidFindBy(id = "btnSave")
    public MobileElement savechecklistbutton;
    @AndroidFindBy(xpath = "//*[contains(@text,'exclude')]")
    public MobileElement scrolllling;
    @AndroidFindBy(xpath = "(//*[contains(@text,'include')])/../../*[2]/*[2]")
    public MobileElement Specific1;
    @AndroidFindBy(xpath = "(//*[contains(@text,'exclude')])/../../*[2]/*[2]")
    public MobileElement Specific2;
    @AndroidFindBy(xpath = "(//*[contains(@text,'include')])/../../*[2]/*[1]")
    public MobileElement None1;
    @AndroidFindBy(xpath = "(//*[contains(@text,'exclude')])/../../*[2]/*[1]")
    public MobileElement None2;
    @AndroidFindBy(id = "com.commonfriend:id/edtIncludeSurname")
    public MobileElement AddSurNameInclude;
    @AndroidFindBy(id = "com.commonfriend:id/edtExcludeSurname")
    public MobileElement AddSurNameExclude;
    @AndroidFindBy(id = "com.commonfriend:id/btnIncludeAdd")
    public MobileElement IncludeAddBtn;
    @AndroidFindBy(id = "com.commonfriend:id/btnExcludeAdd")
    public MobileElement ExcludeAddBtn;
    @AndroidFindBy(id = "com.commonfriend:id/txtMsg")
    public MobileElement DialogBoxHeader;

    @AndroidFindBy(id = "com.commonfriend:id/txtMsgDesc")
    public MobileElement DialogBoxText;

    @AndroidFindBy(xpath = "//*[@text='Okay']")
    public MobileElement OkBtn;


    public CheckList(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }




}
