package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Gotra {
    public AppiumDriver<MobileElement> driver;

    public Gotra(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement GotraPageQue;

    @AndroidFindBy(id = "com.commonfriend:id/edtFirstName")
    public MobileElement GotraPlaceHolder;
    @AndroidFindBy(id = "com.commonfriend:id/txtTitle")
    public MobileElement GotraPageHeader;
    @AndroidFindBy(id = "com.commonfriend:id/infoMessage")
    public MobileElement GotraPrivacyText;

    @AndroidFindBy(id = "com.commonfriend:id/btnDialogContinue")
    public MobileElement BtnContinue;
    @AndroidFindBy(id = "com.commonfriend:id/btnSkip")
    public MobileElement SkipBtn;
    @AndroidFindBy(xpath = "//*[contains(@text, 'What gotra')]")
    public MobileElement validationgotra;




    public String expectedGotraQueTitle="What gotra do you belong to??";
    public String expectedDropDownPlaceHolder="Write your gotra here";

    public String expectedGotraPagePrivacyText="This information will not be\n" +
            "shown to references";




}
