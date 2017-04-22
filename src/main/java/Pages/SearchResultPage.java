package Pages;

import Driver.MainMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchResultPage extends MainMethods {

    @FindBy(css = "#search-results-col .sr-episode-item:first-child")
    public WebElement searchResultItem;

    @FindBy(css = "#filter-col .filter-item:first-child")
    public WebElement categoryCheckBox;

    public SearchResultPage (WebDriver driver, int type) {
        if (type == 0) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } else {
            PageFactory.initElements(driver, this);
        }
    }
}
