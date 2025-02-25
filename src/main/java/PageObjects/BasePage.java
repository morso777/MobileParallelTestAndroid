package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasePage {

    protected AndroidDriver driver;
    public String projectPath = System.getProperty("user.dir");

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(String fileName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(projectPath + "\\src\\Screenshoots\\" + fileName + "_"+ timestamp+  ".png");
        try {
            FileHandler.copy(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
