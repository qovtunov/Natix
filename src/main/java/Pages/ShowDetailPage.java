package Pages;

import Driver.MainMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShowDetailPage extends MainMethods{

    @FindBy(css = "div.col-md-10>div.sd-show-title.ng-binding")
    public WebElement showDetailPageTitle;

    @FindBy(css = "#unplayed-episodes .episode-item:first-child")
    public WebElement podcastItem;

    @FindBy (xpath = "//*[@id=\"show-episodes\"]/table/tbody/tr[1]/td[3]/div")
    public WebElement iconFavorites;

    @FindBy (xpath = "//*[@id=\"show-episodes\"]/table/tbody/tr[1]/td[2]/h4")
    public WebElement podcastItemTitle;

    @FindBy (xpath = "//*[@id=\"unplayed-episodes\"]/div[1]/div[3]")
    public WebElement podcastItemDots;

    @FindBy (xpath = "/html/body/div[6]/div[2]/ion-modal-view/ion-content/div[3]")
    public WebElement addToFavorites;

    @FindBy (xpath = "//*[@id=\"show-episodes\"]/table/tbody/tr[1]/td[4]/div")
    public WebElement addToPlaylist;

    public ShowDetailPage(WebDriver driver, int type) {
        if (type == 0) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } else {
            PageFactory.initElements(driver, this);
        }
    }
}
