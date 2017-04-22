package Pages;

import Driver.MainMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ChangePasswordPage extends MainMethods {

    @FindBy(id = "user-password-new" )
    public WebElement passwordNew;

    @FindBy(id="user-password-confirm")
    public WebElement passwordNewConf;

    @FindBy(id="finished-button")
    public WebElement finishButton;

    @FindBy(id="back-button-createpwd")
    public WebElement backButton;

    public ChangePasswordPage(WebDriver driver, int type) {
        if (type == 0) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } else {
            PageFactory.initElements(driver, this);
        }
    }

    public void changePassword(String newPassword, String newConfPassword, WebDriver driver){
        inputDataField(passwordNew, newPassword, driver);
        inputDataField(passwordNewConf, newConfPassword, driver);
    }

}
