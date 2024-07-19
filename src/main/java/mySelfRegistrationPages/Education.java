package mySelfRegistrationPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;

public class Education {
    public AppiumDriver<MobileElement> driver;

    public Education(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
    @AndroidFindBy(xpath = "//*[@text='Should take about 30 seconds.']")
    public MobileElement TimeInfoText;
    @AndroidFindBy(id = "btnAdd")
    public MobileElement continueeducation;
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.commonfriend:id/txtTagLine\"]")
    public MobileElement educationHomeScreenTitle;
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.commonfriend:id/txtQuestion\"]")
    public MobileElement education1stScreenQueTitle;
    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public MobileElement educationPrivacyText;
    @AndroidFindBy(xpath = "//*[@text=\"Visible to your recommendations only\"]")
    public MobileElement privacyText;
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.commonfriend:id/llPrivacy\"]/../*[3]/*[1]/*")
    public MobileElement dropDownPlaceHolderText;
    @AndroidFindBy(xpath = "//*[@text=\"Add qualification\"]")
    public MobileElement qualificationHeader;

    @AndroidFindBy(xpath = "//*[@text='B.Tech']")
    public MobileElement BtechXpath;       //for scroll down and select text: @Text='B.Tech' , 'M.Tech'


    @AndroidFindBy(id = "edtSearch")
    public MobileElement addqualification;


    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Full-Time']")
    public MobileElement degreetype;
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.commonfriend:id/txtTypeQuestion\"]")
    public MobileElement DegreeScreenQueText;
    @AndroidFindBy(id = "com.commonfriend:id/txtHeaderTitle")
    public MobileElement CollageScreenHeaderText;

    @AndroidFindBy(className = "android.widget.EditText")
    public MobileElement SearchCollege;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='University of Oxford']")
    public MobileElement collegeselect;
    @AndroidFindBy(id = "com.commonfriend:id/imgDelete")
    public MobileElement deletButton;
    @AndroidFindBy(xpath = "//*[@text='Add']/../*[1]")
    public MobileElement PlusButtonImage;
    @AndroidFindBy(id = "com.commonfriend:id/btnContinue")
    public MobileElement BtnContinue;


}
