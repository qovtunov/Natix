package MobileTests;

import Data.ConfigProperties;
import Driver.MainMethods;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MainTestMobile extends MainMethods {

    public static WebDriver driver;


    @BeforeTest (groups = {"androidtest", "changePassword", "changePasswordError"})
    public void setUpAndroid() throws Exception {
        /*try {
            Appium appium = new Appium();
            appium.appiumStart();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        File appDir = new File("src");
        File app = new File(appDir, "natixis.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", ConfigProperties.getProperty("deviceNameAndroid"));
        //capabilities.setCapability("platformVersion", ConfigProperties.getProperty("platformVersionAndroid"));
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", ConfigProperties.getProperty("appPackageAndroid"));
        capabilities.setCapability("appActivity", ConfigProperties.getProperty("appActivityAndroid"));
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    /*@BeforeTest(groups = {"iostest"})
    public void setUpiOS() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "iPhone 5S");
        capabilities.setCapability("deviceName", "10");
        capabilities.setCapability("udid", "ad55e9edb3f3d361e71389621ed8d17c41da095c");
        capabilities.setCapability("app", "");

        driver = new IOSDriver(new URL("http://127.0.0.1:4724/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //Thread.sleep(10000);
    }*/

    @AfterTest(groups = {"androidtest", "changePassword", "changePasswordError"})
    public void tearDown() throws InterruptedException, IOException {
        //Thread.sleep(2000);
        driver.quit();
        /*Appium appium = new Appium();
        appium.appiumDown();*/
        logger.info("[TEST FINISHED]");
    }
}
