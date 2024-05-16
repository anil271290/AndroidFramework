package mySelfRegistration;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.support.PageFactory;

public class MultiLocations {

    public AppiumDriver<MobileElement> driver;
    private static final Logger logger = LogManager.getLogger(IntroLocations.class);


    public MultiLocations(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.commonfriend:id/rlSpinner")
    public MobileElement locat;

    @AndroidFindBy(id = "com.commonfriend:id/btnDialogContinue")
    public MobileElement conbutton;
    @AndroidFindBy(xpath = "//*[@text='4/6']")
    public MobileElement FourthPageNo;
    @AndroidFindBy(xpath = "//*[@text='Where do you plan to settle?']")
    public MobileElement fourthPageQueTitle;
    @AndroidFindBy(xpath = "//*[@text='Add locations']")
    public MobileElement dropDownPlaceHolderText;
    @AndroidFindBy(xpath = "//*[@text='Choose location to add here']")
    public MobileElement belowAddLocationsText;

}
