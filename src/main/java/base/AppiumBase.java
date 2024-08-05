package base;


import com.aventstack.extentreports.MediaEntityBuilder;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;
import lombok.Getter;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class AppiumBase {

    protected static final Logger logger = LogManager.getLogger(AppiumBase.class);
    private AppiumDriver<MobileElement> driver;

   // private AndroidDriver<MobileElement> androidDriver;
    protected static ThreadLocal <HashMap<String, String>> strings = new ThreadLocal<HashMap<String, String>>();
    public AppiumBase() {
        if (strings.get() == null) {
            strings.set(loadStrings());
        }
    }

    private HashMap<String, String> loadStrings() {
        HashMap<String, String> stringMap = new HashMap<>();
        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream("String/strings.xml");
            if (is != null) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                Document doc = builder.parse(is);
                NodeList nodeList = doc.getElementsByTagName("string");
                for (int i = 0; i < nodeList.getLength(); i++) {
                    String key = nodeList.item(i).getAttributes().getNamedItem("name").getNodeValue();
                    String value = nodeList.item(i).getTextContent();
                    stringMap.put(key, value);
                }
            }
        } catch (Exception e) {
            logger.error("Error loading strings.xml", e);
        }
        return stringMap;
    }

    public HashMap<String, String> getStrings() {
        return strings.get();
    }

    DesiredCapabilities cap = new DesiredCapabilities();
    public void setup() throws MalformedURLException {
        cap.setCapability("deviceName", "Samsung SM-N960F");
        cap.setCapability("udid", "5138364c57393498");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "9");
        cap.setCapability("appPackage", "com.commonfriend");
        cap.setCapability("appActivity", "com.commonfriend.activities.intro.SplashActivity");
        cap.setCapability("automationName", "UiAutomator2");

        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AppiumDriver<MobileElement>(url, cap);
       // androidDriver = new AndroidDriver<MobileElement>(url, cap);
        driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
    }

    public void setupEmulator() throws MalformedURLException {
        cap.setCapability("app","C:\\Users\\ANIL PATEL\\Automation Library\\Appium\\cm1550.apk");
        cap.setCapability("deviceName","pixel13");
        cap.setCapability("platformName","android");
        cap.setCapability("automationName","UiAutomator2");
        URL url=new URL("http://127.0.0.1:4723");
        driver=new AppiumDriver<MobileElement>(url,cap);
      // androidDriver = new AndroidDriver<>(url, cap);
        driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);

    }

    public AppiumDriver<MobileElement> getAppiumDriver() {
        return driver;
    }
    /*public AndroidDriver<MobileElement> getAndroidDriver() {
        return androidDriver;
    }*/

    public void continueButton() {
       driver.findElement(By.id("com.commonfriend:id/btnContinue")).click();
    }


    public void skipButton() {
        driver.findElement(By.id("com.commonfriend:id/txtSkipAll")).click();
    }

  /* public void startRecord() {
        androidDriver.startRecordingScreen();
    }

    public void stopRecord(String videoName) {
        String video = androidDriver.stopRecordingScreen();
        File videoFile = new File("./TestReport/videos/" + videoName + ".mp4");
        try {
            FileUtils.writeByteArrayToFile(videoFile, OutputType.BYTES.convertFromBase64Png(video));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
    public  void takeScreenshot(String description) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            String base64Screenshot = ts.getScreenshotAs(OutputType.BASE64);

            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy-HHmmss");
            String currentDate = dateFormat.format(new Date());

            String screenshotName = currentDate + ".png";

            File screenshotFile = new File("./TestReport/screenshots/" + screenshotName);
            FileUtils.writeByteArrayToFile(screenshotFile, OutputType.BYTES.convertFromBase64Png(base64Screenshot));

            // Provide media entity for the extent report
            ExtentReport.getTest().info(description, MediaEntityBuilder.createScreenCaptureFromPath("../TestReport/screenshots/" + screenshotName).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


   /* public boolean isElementDisplayed(MobileElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }*/
   public boolean isElementDisplayed(MobileElement element, int timeoutInSeconds) {
       try {
           WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
           wait.until(ExpectedConditions.visibilityOf(element));
           return element.isDisplayed();
       } catch (NoSuchElementException e) {
           return false;
       }
   }




    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }

}
