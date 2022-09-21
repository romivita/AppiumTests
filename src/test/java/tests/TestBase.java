package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests {

    public static AppiumDriver driver;

    public static void Android_setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        caps.setCapability("uiautomator2ServerInstallTimeout", 60000);
        caps.setCapability(MobileCapabilityType.APP,System.getProperty("user.dir")+"/apps/ToDo.apk");
        driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
    }

    //A06AD6A3-9237-426E-B7A6-E0DA965ED715
    //567342D8-0E3B-46DB-8660-819013D1F371
/*    public static void iOS_setUp(String port, String deviceName, String platformVersion, String udid, String wdaLocalPort) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("deviceName", deviceName);
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/DailyCheck.zip");
        caps.setCapability("udid", udid);
        caps.setCapability("wdaLocalPort", wdaLocalPort);
        driver = new IOSDriver(new URL("http://localhost:" + port + "/wd/hub"), caps);
    }*/

    public void iOS_setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability("isHeadless",true);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone 13 Pro");
        capabilities.setCapability("showXcodeLog",true);
        capabilities.setCapability(MobileCapabilityType.APP,
                System.getProperty("user.dir")+"/apps/DailyCheck.zip");
        driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    public static void tearDown() {
        if (null != driver) {
            driver.quit();
        }
    }
}
