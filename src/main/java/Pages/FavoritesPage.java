package Pages;

import Driver.MainMethods;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FavoritesPage extends MainMethods {

    @FindAll({
            @FindBy(xpath = "(.//*[@id='favorite-episodes']/table/tbody/tr)[1]/td[3]"),
            @FindBy(xpath = "//*[@id=\"favourite-episodes\"]/table/tbody/tr/td[3]/h4"),
            @FindBy(xpath = "//*[@id=\"favourite-episodes\"]/div/h3")
    })
    public WebElement podcastItemTitle;

    @AndroidFindAll({
            @AndroidFindBy(id = "favourite-episodes"),
            @AndroidFindBy(xpath = "android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.Image[1]")
    })
    @FindBy(css = "#favourite-episodes .item:first-child")
    public WebElement podcastItem;

    @FindAll({
            @FindBy(css = ".icon.list-item-delete"),
            @FindBy(css = "#favourite-episodes .delete:first-child")
    })
    public WebElement podcastItemDelete;


    public FavoritesPage(WebDriver driver, int type) {
        if (type == 0) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } else {
            PageFactory.initElements(driver, this);
        }
    }


}
