package mySelfRegistrationPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;

import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BackgroundEatingHabit {

    public AppiumDriver<MobileElement> driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Vegeterian']")
    public MobileElement ehabit;
    @AndroidFindBy(xpath = "//*[@text='What are your eating habits?']")
    public MobileElement EatScreenQueTitle;
    @AndroidFindBy(xpath = "//*[@text='6/6']")
    public MobileElement SixthPageNo;
    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public MobileElement EatingPrivacyText;



    public BackgroundEatingHabit(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void eathabit() {
        ehabit.click();
    }

    @AndroidFindBy(id = "com.commonfriend:id/txtOption")
    List<MobileElement> eatingHabitOptions;

    public void getEatHabitTexts() {
        for (MobileElement option : eatingHabitOptions) {
            System.out.println(option.getText());
        }
    }

}
