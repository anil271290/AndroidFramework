package mySelfRegistrationPages;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.*;

import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.Map;


public class BackgroundBday {
    public AppiumDriver<MobileElement> driver;


    @AndroidFindBy(xpath = "//*[@resource-id=\"android:id/pickers\"]/android.widget.NumberPicker[3]")
    public MobileElement year;
    @AndroidFindBy(xpath = "//*[@resource-id=\"android:id/pickers\"]/android.widget.NumberPicker[2]")
    public MobileElement date;

    @AndroidFindBy(xpath = "//*[@resource-id=\"android:id/pickers\"]/android.widget.NumberPicker[1]")
    public MobileElement month;

    @AndroidFindBy(xpath = "//android.widget.NumberPicker[3]/*[1]")
    public MobileElement TapYearXpath;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text='2006']")
    public MobileElement DefaultYearXpath;

    @AndroidFindBy(id = "com.commonfriend:id/date_Picker")
    public MobileElement container;
    @AndroidFindBy(xpath = "//*[@text=\"When's your birthday?\"]")
    public MobileElement bdayQueTitle;

    @AndroidFindBy(xpath = "//*[@text='Background']")
    public MobileElement ThirdPageHeaderTitle;
    @AndroidFindBy(xpath = "//*[@text='3/6']")
    public MobileElement ThirdPageNo;
    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public MobileElement thirdPagePrivacyText;

  //public  MobileElement container = driver.findElement(MobileBy.id("com.commonfriend:id/date_Picker"));



    public BackgroundBday(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void scrollDownToMonth(String targetMonth) {
        String monthLocator = "//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\" and @text=\"Apr\"]";
        MobileElement currentMonthElement = driver.findElement(By.xpath(monthLocator));
        String currentMonth = currentMonthElement.getText();

        while (!currentMonth.equals(targetMonth)) {
            // Identify the element to scroll to (the month picker)
            MobileElement monthElement = driver.findElement(By.xpath(monthLocator));

            // Create parameters for the mobile:scroll command
            Map<String, Object> scrollParams = new HashMap<>();
            scrollParams.put("strategy", "accessibility id"); // Specify the strategy
            scrollParams.put("selector", monthElement.getAttribute("text")); // Specify the selector
            scrollParams.put("toVisible", "true");

            // Execute the mobile:scroll command
            driver.executeScript("mobile:scroll", scrollParams);

            // Update current month after scrolling
            currentMonth = monthElement.getText();
        }
    }

}








