package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BackgroundCulture {
    public AppiumDriver<MobileElement> driver;
    public BackgroundCulture(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
    protected static final Logger logger = LogManager.getLogger(BackgroundCulture.class);

    @AndroidFindBy(xpath = "//*[@text='Background']")
    public MobileElement CulturePageHeaderTitle;

    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public MobileElement CulturePagePrivacyText;
    @AndroidFindBy(xpath = "//*[@resource-id=\"com.commonfriend:id/txtQuestion\"]")
    public MobileElement CulturePageQueTitle;
    @AndroidFindBy(xpath = "//*[@text='Add cultures']")
    public MobileElement dropDownPlaceHolderText;
    @AndroidFindBy(xpath = "//*[@text='Choose culture to add here']")
    public MobileElement belowAddCultureText;

    @AndroidFindBy(id = "com.commonfriend:id/txtLocationName")
    public MobileElement addculture;
    @AndroidFindBy(id = "com.commonfriend:id/btnDialogContinue")
    public MobileElement coninuecl;

    @AndroidFindByAllSet(value = {@AndroidFindAll(value = {@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.commonfriend:id/txtCulture']")})})
    public static List<MobileElement> cultures;

    public static List<String> getCultureTexts() {
        List<String> CultureTexts = new ArrayList<>();
        for (MobileElement element : cultures) {
            CultureTexts.add(element.getText());
        }
        return CultureTexts;
    }

    public static void clickCulture(int index) {
        if (index >= 0 && index < cultures.size()) {
            cultures.get(index).click();
        } else {
            logger.info("Invalid index.");
        }
    }

    public void tickculture() {
        // Interacting with elements
        for (MobileElement element : cultures) {
           logger.info(element.getText());
            // Perform other actions if needed
        }

        // Using page object methods
        List<String> CultureTexts = getCultureTexts();
        for (String culturetext : CultureTexts) {
           logger.info(culturetext);


        }

        BackgroundCulture.clickCulture(0);// Click on the first location
        BackgroundCulture.clickCulture(1);
        BackgroundCulture.clickCulture(2);

    }

    public void cltrcontinu() {
        coninuecl.click();
    }

    public void AddCulture() {
        addculture.click();
    }

    public String expectedCultureQueText="Which cultures do you identify with?";

    public String expectedCulturePlaceHolderText="Add cultures";
}
