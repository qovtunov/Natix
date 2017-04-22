package Pages;

import Driver.MainMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PlaylistPage extends MainMethods {

    @FindBy(xpath = "//*[@id=\"playlist-episodes\"]/table/tbody/tr/td[4]/div" )
    public WebElement deleteFromPlaylist;

    @FindBy(xpath = "//*[@id=\"playlist-episodes\"]/table/tbody/tr/td[3]/h4")
    public WebElement podcastItemTitle;

    public PlaylistPage(WebDriver driver, int type) {
        if (type == 0) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } else {
            PageFactory.initElements(driver, this);
        }
    }
}
