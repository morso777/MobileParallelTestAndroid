package PageObjects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage extends BasePage{

    By byContinuarButtonID = AppiumBy.id("com.android.permissioncontroller:id/continue_button");
    By byContinuarButtonXPATH = AppiumBy.id("//android.widget.Button[@resource-id='com.android.permissioncontroller:id/continue_button']");

    By byCancelarButtonID = AppiumBy.id("com.android.permissioncontroller:id/cancel_button");
    By byAccessibilityID = AppiumBy.accessibilityId("Accessibility");
    By byAccessibilityXPATH = AppiumBy.xpath("//android.widget.TextView[@content-desc='Accessibility']");

    public HomePage(AndroidDriver driver) {
        super(driver);
    }


    public void checkContinueButton(){
        System.out.println("Check Continue Button");
        driver.findElement(byContinuarButtonID).isDisplayed();
    }

    public void clickAccessibilityID(){
        System.out.println("AccessibilityID");
        driver.findElement(byAccessibilityID).click();
        driver.navigate().back();
        takeScreenshot("_uno");
    }


    public void clickAccessibilityXPATH(){
        System.out.println("AccessibilityXPATH");
        driver.findElement(byAccessibilityXPATH).click();
        driver.navigate().back();
        takeScreenshot("_dos");
    }

    public void click(){
        System.out.println("AccessibilityXPATH");
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"\")")).isEnabled();
        driver.navigate().back();
        takeScreenshot("_dos");
    }

}
