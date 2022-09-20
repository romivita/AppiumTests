package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests {

    public static AppiumDriver driver;

    public static void Android_setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "Android Emulator");
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/ToDo.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    //A06AD6A3-9237-426E-B7A6-E0DA965ED715
    //567342D8-0E3B-46DB-8660-819013D1F371
    public static void iOS_setUp(String port, String deviceName, String platformVersion, String udid, String wdaLocalPort) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/DailyCheck.zip");
        caps.setCapability("udid", udid);
        caps.setCapability("wdaLocalPort", wdaLocalPort);
        driver = new IOSDriver(new URL("http://localhost:" + port + "/wd/hub"), caps);
    }

    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}