package Pages;

import Driver.MainMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShowDetailPage extends MainMethods{

    @FindBy(css = "div.col-md-10>div.sd-show-title.ng-binding")
    public WebElement showDetailPageTitle;

    @FindBy(css = "#unplayed-episodes .episode-item:first-child")
    public WebElement podcastItem;

    @FindBy (xpath = "//*[@id=\"show-episodes\"]/table/tbody/tr[1]/td[3]/div")
    public WebElement iconFavorites;

    @FindBy (css = "#show-episodes tr:first-child .p-0.ng-binding")
    public WebElement podcastItemTitle;

    @FindBy (xpath = "//*[@id=\"unplayed-episodes\"]/div[1]/div[3]")
    public WebElement podcastItemDots;

    @FindBy (css = "#show-episodes tr:first-child .icon-favorites")
    public WebElement addToFavorites;

    @FindBy (css = "#show-episodes tr:first-child .icon-playlist")
    public WebElement addToPlaylist;

    @FindBy (id = "subscribe-button")
    public WebElement subscribeButton;

    @FindBy(id = "subscribe-info-button")
    public WebElement subscribeInfoButton;

    @FindBy(xpath = ".//*[@id='subscribe-info-button']/div")
    public WebElement subscribeInfoHover;

    @FindAll(@FindBy(css= ".p-0.ng-binding"))
    public List<WebElement> podcastTitles;


    public ShowDetailPage(WebDriver driver, int type) {
        if (type == 0) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } else {
            PageFactory.initElements(driver, this);
        }
    }
}
