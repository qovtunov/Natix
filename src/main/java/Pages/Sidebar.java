package Pages;


import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sidebar {
    @FindBy(id = "side-bar-button")
    public WebElement sidebarToggle;

    @FindBy(id = "side-bar-show")
    public WebElement sideBarShow;

    @FindBy(id="side-bar-playlist-button")
    public WebElement sideBarPlaylistButton;

    @FindBy(css = "body > div > div.slider-bar.opened > div > div.episode-pub-date.ng-binding")
    public WebElement sidebarShowTitle;

    public Sidebar(WebDriver driver, int type) {
        if (type == 0) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } else {
            PageFactory.initElements(driver, this);
        }
    }
}
