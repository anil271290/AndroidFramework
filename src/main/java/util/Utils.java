package util;


import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;


public class Utils {
    protected static final Logger logger = LogManager.getLogger(Utils.class);

    public static AppiumDriver<MobileElement> driver;
    protected WebDriverWait wait;

    public Utils(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, 200);
    }


    public void scrolldown(int startX, int startY, int endX, int endY, int scrollCount) {
        for (int i = 0; i < scrollCount; i++) {
            PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence swipe = new Sequence(input, 0);
            swipe.addAction(input.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(input.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, endY));
            //swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Collections.singletonList(swipe));

        }
    }

    public void scrolldown(MobileElement sourceElement, int scrollCount) {
        Dimension size = driver.manage().window().getSize();
        int startX = sourceElement.getLocation().x;
        int startY = sourceElement.getLocation().y;
        //int endX = sourceElement.getLocation().x + 50;
        int endX = startX;
        //  int endY = (int) (size.height * 0.7);
        int endY = sourceElement.getLocation().y + 200;
        WebDriverWait wait = new WebDriverWait(driver, 200);
        for (int i = 0; i < scrollCount; i++) {
            PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
            Sequence swipe = new Sequence(input, 0);
            swipe.addAction(input.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(input.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, endY));
            // driver.perform(Arrays.asList(swipe));
            driver.perform(Collections.singletonList(swipe));

        }
    }

    public void scrollToElementByText(String elementText) {
        JavascriptExecutor js = driver;
        String script = "arguments[0].scrollIntoView();";
        String xpathExpression = "//*[contains(@text, '" + elementText + "')]";

        // Find the element by xpath
        Object element = driver.findElement(By.xpath(xpathExpression));

        // Scroll to the element using JavaScript executor
        js.executeScript(script, element);
    }

    public void scrollToElementByActionClass(String elementText) {
        try {
            WebElement element = driver.findElement(By.xpath("//*[contains(@text, '" + elementText + "')]"));

            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            actions.perform();
        } catch (NoSuchElementException e) {
            System.out.println("Element with text '" + elementText + "' not found.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public void swipeToAGivenTextAndClick(String elementText) {
        String uiSelector = "new UiSelector().textMatches(\"" + elementText
                + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + uiSelector + ");";
        driver.findElement(MobileBy.AndroidUIAutomator(command)).click();
    }

    public void swipeToAGivenXpathAndClick(String elementText) {
        // Construct the XPath expression to locate the element with the given text
        String xpathExpression = "//*[contains(@text, ' + elementText + ')]";

        // Scroll to the element using the XPath expression
        MobileElement element = driver.findElement(By.xpath(xpathExpression));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        // Click on the element
        element.click();
    }

    public void scrollToElementInContainer(MobileElement containerXPath, MobileElement targetElementXPath) {
        // Assuming you have already initialized your AndroidDriver instance

            // Step 1: Identify the container element
        MobileElement container = driver.findElement(By.xpath(String.valueOf(containerXPath)));

            // Step 2: Identify the target element within the container
        MobileElement targetElement = container.findElement(By.xpath(String.valueOf(targetElementXPath)));

            // Step 3: Scroll within the container until the target element becomes visible
        String containerId = container.getAttribute("resourceId");
        String targetElementId = targetElement.getAttribute("resourceId");

        String scrollCommand = "new UiScrollable(new UiSelector().resourceId(\"" + containerId + "\")).scrollIntoView("
                + "new UiSelector().resourceId(\"" + targetElementId + "\"));";

        // ((AndroidDriver)driver).findElementByAndroidUIAutomator(scrollCommand);
        driver.findElement(MobileBy.AndroidUIAutomator(scrollCommand));

    }

    public void swipeToHorizontal(String elementText) {
        String uiSelector = "new UiSelector().textMatches(\"" + elementText
                + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).setAsHorizontalList().scrollIntoView("
                + uiSelector + ");";
        driver.findElement(MobileBy.AndroidUIAutomator(command)).click();
    }


    public void swipeToAGivenResourceIDAndClick(String resourceId) {
        String uiSelector = "new UiSelector().resourceIdMatches(\"" + resourceId
                + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + uiSelector + ");";
        driver.findElement(MobileBy.AndroidUIAutomator(command)).click();
    }


    public void waitForElementToBeVisible(MobileElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (NoSuchElementException ex) {
            logger.error("Element not found: {}", ex.getMessage());
        }
    }


    public void waitForElementWithFluentWait(MobileElement element) {
        FluentWait<AppiumDriver<MobileElement>> fluent = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
        fluent.until(t -> element.isDisplayed());
    }


    public String getCurrentTimeStamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");
        return dateFormat.format(new Date());
    }

   public static void dragAndDropUsingTouchAction(String sourceElementXpath, int sourceIndex, String destinationElementXpath, int destinationIndex) {
        // Locate source and destination elements
        MobileElement source = driver.findElement(By.xpath(String.format(sourceElementXpath, sourceIndex)));
        MobileElement destination = driver.findElement(By.xpath(String.format(destinationElementXpath, destinationIndex)));

        // Perform drag-and-drop
       TouchAction<?> touchAction=new TouchAction<>(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(source)))
                .moveTo(ElementOption.element(destination))
                .release()
                .perform();
    }

    public static void dragAndDrop(String sourceElementXpath, int sourceIndex, String destinationElementXpath, int destinationIndex) {
        // Locate source and destination elements
        WebElement source = driver.findElement(By.xpath(String.format(sourceElementXpath, sourceIndex)));
        WebElement target = driver.findElement(By.xpath(String.format(destinationElementXpath, destinationIndex)));

        Point sourceElementCenter = getCenterOfElement(source.getLocation(), source.getSize());
        Point targetElementCenter = getCenterOfElement(target.getLocation(), target.getSize());

        // Convert coordinates to integers
        int sourceX = (int) Math.round(sourceElementCenter.getX());
        int sourceY = (int) Math.round(sourceElementCenter.getY());
        int targetX = (int) Math.round(targetElementCenter.getX());
        int targetY = (int) Math.round(targetElementCenter.getY());

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceX, sourceY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofMillis(588)))
                .addAction(finger1.createPointerMove(Duration.ofMillis(588), PointerInput.Origin.viewport(), targetX, targetY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(sequence));
    }

    private static Point getCenterOfElement(Point location, Dimension size) {
        int centerX = (int) Math.round(location.getX() + size.getWidth() / 2);
        int centerY = (int) Math.round(location.getY() + size.getHeight() / 2);
        return new Point(centerX, centerY);
    }


    public static void tapElementMultipleTimes(MobileElement element, int times) {
        for (int i = 0; i < times; i++) {
            element.click();
        }
    }




    public void waitForElementToBeVisible(boolean enabled) {
    }
}
