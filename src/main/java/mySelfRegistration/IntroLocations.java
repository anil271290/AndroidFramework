package mySelfRegistration;

import base.TestListener;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @AndroidFindBy(id = "com.commonfriend:id/txtChooseReligion")
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

    @AndroidFindBy(id = "com.commonfriend:id/txtHomeTown")
    private List<MobileElement> suggestionTextViews;

    public void printSuggestedSettleLocations() {
        for (MobileElement suggestion : suggestionTextViews) {
            System.out.println(suggestion.getText());
            TestListener.logToExtentReport("Suggested Localities : "+suggestion.getText());
        }
    }
    @AndroidFindBy(id = "com.commonfriend:id/rlMain")
    private List<MobileElement> locationElements;

    public void clickFirstSixLocations() {
        for (int i = 0; i < 6 && i < locationElements.size(); i++) {
            locationElements.get(i).click();
        }
    }

    public Set<String> getAllLocations() {
        Set<String> locationSet = new HashSet<>();
        boolean isEndOfList = false;

        while (!isEndOfList) {
            List<MobileElement> currentLocations = driver.findElements(By.id("com.commonfriend:id/txtCulture"));

            // Add current visible locations to the set
            for (MobileElement location : currentLocations) {
                locationSet.add(location.getText());
            }

            // Remember the last location text
            String lastLocationText = currentLocations.get(currentLocations.size() - 1).getText();

            // Scroll down
            scrollDown();

            // Check if we are at the end of the list
            currentLocations = driver.findElements(By.id("com.commonfriend:id/txtCulture"));
            String newLastLocationText = currentLocations.get(currentLocations.size() - 1).getText();

            if (lastLocationText.equals(newLastLocationText)) {
                isEndOfList = true;
            }
        }
        return locationSet;
    }

    private void scrollDown() {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(startX, endY))
                .release()
                .perform();
    }

}




