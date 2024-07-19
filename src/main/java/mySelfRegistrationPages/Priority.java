package mySelfRegistrationPages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class Priority {

    public AppiumDriver<MobileElement> driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Age']")
    public MobileElement age;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Height']")
    public MobileElement hight;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Education']")
    public MobileElement education;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Profession']")
    public MobileElement profession;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Income']")
    public MobileElement income;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Looks']")
    public MobileElement looks;

   public String start= "//*[@resource-id='com.commonfriend:id/llPriority'][%s]";
   public String end="//*[@resource-id='com.commonfriend:id/llPriority'][%s]";




    public String priorityDownBtn1 = "//*[@text='%s']/..//android.widget.ImageView[1]";
    public String priorityUpBtn1 = "//*[@text='%s']/..//android.widget.ImageView[2]";

    public Priority(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void tickpriority() {
        age.click();
        income.click();
        profession.click();
        hight.click();
        education.click();
        looks.click();
    }


    public void changePriorityToUp(String name, int count) {
        for (int i = 0; i < count; i++) {
            driver.findElement(By.xpath(String.format(priorityUpBtn1, name))).click();
        }
    }

    public void changePriorityToDown(String name, int count) {
        for (int i = 0; i < count; i++) {
            driver.findElement(By.xpath(String.format(priorityDownBtn1, name))).click();
        }

    }


}

