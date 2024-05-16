package mySelfRegistration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;

import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
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
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/*")
    public List<MobileElement> allEatHabitsXpath;
    @AndroidFindByAllSet(value = {@AndroidFindAll(value = {@AndroidBy(xpath = "//androidx.recyclerview.widget.RecyclerView/*")})})
    public static List<MobileElement> allEatHabits;


    public BackgroundEatingHabit(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void eathabit() {
        ehabit.click();
    }

    public  List<String> getEatHabitTexts() {
        List<String> HabitTexts = new ArrayList<>();
        for (MobileElement element : allEatHabits) {
            HabitTexts.add(element.getText());
        }
        return HabitTexts;
    }

}
