package Driver;

import Data.UserData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Set;
import java.util.logging.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class MainMethods extends UserData {

    public WebDriver driver;
    public WebDriverWait wait;

    public static final Logger logger = Logger.getLogger(MainMethods.class.getName());
    /*
        /Library/Java/JavaVirtualMachines/jdk1.8.0_05.jdk/Contents/Home/jre/lib/logging.properties - global file
        -Djava.util.logging.config.file=/Users/kovtunov/Dropbox/Learning/IT/Projects/natixisApp/src/log.properties - add to Edit Configuration > VM
        System.out.println(System.getProperty("java.util.logging.config.file")); - check local file
        LogManager.getLogManager().readConfiguration(); - read configuration from local file
    */
    static public void setLogger() throws IOException {
        // Create Logger
        //Logger logger = Logger.getLogger("");
        logger.setLevel(Level.INFO);
        int limit = 1000000; // 1 Mb

        FileHandler logFile = new FileHandler("Logs.log", limit, 1);

        // Create txt Formatter
        SimpleFormatter formatterTxt = new SimpleFormatter();
        logFile.setFormatter(formatterTxt);

        /*Handler ch = new ConsoleHandler();
        ch.setFormatter(formatterTxt);
        logger.addHandler(ch);*/

        logger.addHandler(logFile);
    }


    //Main driver methods

    public void waitForElement(WebElement element, WebDriver driver) {
        wait = new WebDriverWait(driver, 30);
        //logger.info("Waiting for visibility of element... 30 sec");
        wait.until(ExpectedConditions.visibilityOf(element));
        //logger.info("Element is found.");
    }

    public boolean isElementVisible(WebElement element, WebDriver driver) {
        try {
            waitForElement(element, driver);
            /*if (element.isEnabled()) {
                return true;
            } else {
                return false;
            }*/
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isElementNotVisible(WebElement element, WebDriver driver) {
        try {
            wait.until(stalenessOf(element));
            /*if (element.isEnabled()) {
                return true;
            } else {
                return false;
            }*/
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isRedirectTo(String url, WebDriver driver) {
        wait = new WebDriverWait(driver, 30);
        try {
            wait.until(ExpectedConditions.urlContains(url));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void clickElement(WebElement button, WebDriver driver) {
        waitForElement(button, driver);
        button.click();
    }

    public void inputDataField(WebElement element, String text, WebDriver driver) {
        waitForElement(element, driver);
        element.clear();
        element.sendKeys(text);
    }

    public void inputDataFieldMobile(MobileElement element, String text, WebDriver driver) {
        waitForElement(element, driver);
        //element.setValue(text);
    }

    public void hoverOverElement(WebElement element, WebDriver driver) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void dragToClick(WebElement drag, WebElement click, WebDriver driver) {
        Actions builder = new Actions(driver);
        Action dragAndDrop = builder.clickAndHold(drag)
                .moveToElement(click)
                .release(click)
                .build();
        dragAndDrop.perform();
        click.click();
    }

    public void switchToWeb (WebDriver driver) {
        Set<String> contextNames = ((AndroidDriver) driver).getContextHandles();
        logger.info("Ready to switch to WebView...");
        for (String contextName : contextNames) {
            logger.info(contextName);
            if (contextName.contains("WEBVIEW_io")) {
                ((AndroidDriver) driver).context(contextName);
            }
            logger.info("Switched to WebView.");
        }
    }
}
