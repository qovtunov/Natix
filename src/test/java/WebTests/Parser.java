package WebTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kovtunov on 18/04/2017.
 */
public class Parser  {

    public static WebDriver driver;

    String operationSystem = System.getProperty("os.name").toLowerCase();

    File dir = new File("src");
    File driverChromeWin = new File(dir, "chromedriver.exe");
    File driverChromeLinux = new File(dir, "chromedriverLinux64");
    File driverChromeMac = new File(dir, "chromedriverMac");

    @BeforeTest(groups = {"signuptestweb", "changePassword", "changePasswordError"})                       // РАЗОБРАТЬСЯ - ЗАПУСК ДЛЯ ВСЕХ ГРУП
    public void DriverChrome() throws IOException {
        System.out.println("OS: " + operationSystem);
        if (operationSystem.contains("win")) {
            System.setProperty("webdriver.chrome.driver", String.valueOf(driverChromeWin));
        } else if (operationSystem.contains("nux") || operationSystem.contains("nix")) {
            System.setProperty("webdriver.chrome.driver", String.valueOf(driverChromeLinux));
        } else if (operationSystem.contains("mac")) {
            System.setProperty("webdriver.chrome.driver", String.valueOf(driverChromeMac));
        }

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
    }

    @Test
    public void pars(){
        driver.navigate().to("https://origin-stg-auth-www-hpe-com.ext.hpe.com/cf#/content/hpe/country/us/en/about.html");

        List<WebElement> elements = driver.findElements(By.cssSelector(".xtb-text"));

        ArrayList list = new ArrayList();

        for (int i = 0; i<elements.size(); i++ ){
            list.add(elements.get(i).getText());
        }

        System.out.println(list);
    }
}
