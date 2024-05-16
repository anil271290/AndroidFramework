package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class IntroLocations {

    public AppiumDriver<MobileElement> driver;
    protected static final Logger logger = LogManager.getLogger(IntroLocations.class);

    @AndroidFindBy(id = "com.commonfriend:id/rlSpinner")
    public MobileElement locat;

    @AndroidFindBy(id = "com.commonfriend:id/btnDialogContinue")
    public MobileElement conbutton;
    @AndroidFindBy(xpath = "//*[@text='4/6']")
    public MobileElement FourthPageNo;
    @AndroidFindBy(id = "com.commonfriend:id/txtQuestion")
    public MobileElement SettleLocQueTitle;
    @AndroidFindBy(xpath = "//*[@text='Add locations']")
    public MobileElement dropDownPlaceHolderText;
    @AndroidFindBy(xpath = "//*[@text='Choose location to add here']")
    public MobileElement belowAddLocationsText;
    @AndroidFindByAllSet(value = {@AndroidFindAll(value = {@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.commonfriend:id/txtCulture']")})})
    public static List<MobileElement> locations;
    @AndroidFindAll(@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.commonfriend:id/txtCulture']"))
    public static List<MobileElement> Locationss;

    public static List<String> getLocationTexts() {
        List<String> locationTexts = new ArrayList<>();
        for (MobileElement location : locations) {
            locationTexts.add(location.getText());
        }
        return locationTexts;
    }

    public static void clickLocation(int index) {
        if (index >= 0 && index < locations.size()) {
            locations.get(index).click();
        } else {
            System.out.println("Invalid index.");
        }
    }




    public IntroLocations(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void selectlocat() {

        // Interacting with elements
        for (MobileElement location : locations) {
           // System.out.println(location.getText());
            logger.info(location.getText());
            // Perform other actions if needed
        }

        // Using page object methods
        List<String> locationTexts = IntroLocations.getLocationTexts();
        for (String locationText : locationTexts) {
            logger.info(locationText);


        }

        IntroLocations.clickLocation(0);// Click on the first location
        IntroLocations.clickLocation(1);
        IntroLocations.clickLocation(2);
        IntroLocations.clickLocation(3);
        IntroLocations.clickLocation(5);
        IntroLocations.clickLocation(7);


    }

    public String expectedSettleLocQueText="Where do you plan to settle?";

    public String expectedSettleLocPlaceHolderText="Add locations";
    public String expectedSettleLocPrivacyText="Visible to your recommendations only";




}




