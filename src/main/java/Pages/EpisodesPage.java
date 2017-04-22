package Pages;


import Driver.MainMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EpisodesPage extends MainMethods {

    @FindBy(id="search-field")
    public WebElement searchField;

    @FindBy(css = "#search-results .item:first-child")
    public WebElement searchResultItem;


    public EpisodesPage(WebDriver driver, int type) {
        if (type == 0) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } else {
            PageFactory.initElements(driver, this);
        }
    }
}
