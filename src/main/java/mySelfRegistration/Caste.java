package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Caste {
    public AppiumDriver<MobileElement> driver;

    public Caste(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement CastePageQue;

    @AndroidFindBy(id = "com.commonfriend:id/txtLocationName")
    public MobileElement CastePlaceHolder;
    @AndroidFindBy(id = "com.commonfriend:id/txtTitle")
    public MobileElement CastePageHeader;
    @AndroidFindBy(id = "com.commonfriend:id/infoMessage")
    public MobileElement CastePrivacyText;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/*[1]")
    public MobileElement FirstCaste;
    @AndroidFindBy(id = "com.commonfriend:id/btnDialogContinue")
    public MobileElement BtnContinue;
    @AndroidFindBy(id = "com.commonfriend:id/btnSkip")
    public MobileElement SkipBtn;
    @AndroidFindBy(xpath = "//*[contains(@text, 'What caste')]")
    public MobileElement validationCaste;

  public String expectedPrivacyText="This information will not be\n" +
            "shown to references";

    public String expectedCasteQueTitle="What caste do you belong to?";
    public String expectedDropDownPlaceHolder="Select your caste";



}
