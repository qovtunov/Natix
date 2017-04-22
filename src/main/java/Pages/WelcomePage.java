package Pages;

import Driver.MainMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class WelcomePage extends MainMethods {

    @FindBy(id = "header-settings-button")
    public WebElement settingsButton;

    @FindBy(id = "change-password-option")
    public WebElement settingsChangePasswordOption;

    @FindBy (id = "durable-portfolio-construction")
    public WebElement podcastItem;

    @FindBy(id="view-all")
    public WebElement viewAllButton;


    //Latest Episodes

    @FindBy(css = "#latest-episodes-welcome li:first-child .list-item-play-lg")
    public WebElement playButton;

    @FindBy(xpath = "/html/body/div[1]/div[5]/div")
    public WebElement playerFooter;



    public WelcomePage(WebDriver driver, int type) {
        if (type == 0) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } else {
            PageFactory.initElements(driver, this);
        }
    }
}
