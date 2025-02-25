package PageObjects;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import static PageObjects.Config.region;

public class BaseTestParallelSauceLabs {

    private static final String APP = "Android.SauceLabs.mobile.Sample.app.2.7.0.apk";
    URL url; //added
    String usernameID = "test-Username";
    String passwrodID = "test-Password";
    private ThreadLocal<AndroidDriver> driver = new ThreadLocal<AndroidDriver>();


    @BeforeMethod
    public void setupParallelSauceLabs(Method method) throws InterruptedException, MalformedURLException {

        String methodName = method.getName();
        String SL_username = System.getenv("User");
        String SL_accessKey = System.getenv("Key");
        String sauceUrl;

        if (region.equalsIgnoreCase("eu")) {
            sauceUrl = "@ondemand.eu-central-1.saucelabs.com:443";
        }else {
            sauceUrl = "@ondemand.us-west-1.saucelabs.com:443";
        }
        String SAUCE_REMOTE_URL = "https://" + SL_username + ":" + SL_accessKey + sauceUrl + "/wd/hub";
        url = new URL(SAUCE_REMOTE_URL);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:app", "storage:filename=ApiDemos-debug.apk");  // The filename of the mobile app
        capabilities.setCapability("appium:deviceName", "Google_Pixel_5_free");
        capabilities.setCapability("appium:platformVersion", "14");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "io.appium.android.apis");
        capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        capabilities.setCapability("username", SL_username);
        capabilities.setCapability("accessKey", SL_accessKey);
        capabilities.setCapability("build", "appium-build-R0OJR");
        capabilities.setCapability("name", methodName);
        capabilities.setCapability("deviceOrientation", "PORTRAIT");


        driver.set(new AndroidDriver(url, capabilities));



    }

    @AfterMethod
    public void tearDownParallelSauceLabs(ITestResult result) {
        try {
            if (driver.get() != null) {
                ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (result.isSuccess()));
            }
        } finally {
            System.out.println("Sauce_ released driver");
            driver.get().quit();
        }
    }
}



