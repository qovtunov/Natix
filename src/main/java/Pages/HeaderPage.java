package Pages;


import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage {

    @FindBy(id = "show-nav")
    public WebElement showsTab;

    @FindBy (id = "favorites-nav")
    public WebElement favoritesTab;

    @FindBy(id = "playlist-nav")
    public WebElement playlistTab;

    @FindBy(id="search-field")
    public WebElement searchField;

    @FindBy(id="episodes-nav")
    public WebElement episodesTab;

    public HeaderPage(WebDriver driver, int type) {
        if (type == 0) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } else {
            PageFactory.initElements(driver, this);
        }
    }
}
