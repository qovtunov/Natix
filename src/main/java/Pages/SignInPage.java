/*
package Pages;

import Data.ConfigProperties;
import Methods.MainMethods;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends MainMethods {

    @FindBy(xpath = "html/body/div[1]/ion-side-menus/ion-side-menu-content/div/div/ion-content/div/div[1]/div/div/div[3]/div/label[1]/input")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIATextField[1]")
    public WebElement login;

    @FindBy(xpath = "html/body/div[1]/ion-side-menus/ion-side-menu-content/div/div/ion-content/div/div[1]/div/div/div[3]/div/label[2]/input")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIASecureTextField[1]")
    public WebElement password;

    @FindBy(xpath = "html/body/div[1]/ion-side-menus/ion-side-menu-content/div/div/ion-content/div/div[1]/div/div/div[4]/div/button")
    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]")
    public WebElement signInButton;

    @iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[2]/UIAToolbar[1]/UIAButton[3]")
    public WebElement doneButton;


    public SignInPage(WebDriver driver) {

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void signInInput (WebDriver driver) {
        printTextField(login, ConfigProperties.getProperty("login"), driver);
        printTextField(password, ConfigProperties.getProperty("password"), driver);
    }

    public void clickSignInButton(WebDriver driver) {
        clickElement(signInButton, driver);
    }
}
*/
package Pages;

import Data.ConfigProperties;
import Driver.MainMethods;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends MainMethods {

    @FindAll({
            @FindBy(id = "user-email")
    })
    @iOSFindBy(xpath = "")
    public WebElement emailLogin;

    @FindAll({
            @FindBy(id = "user-password")
    })
    @iOSFindBy(xpath = "")
    public WebElement password;

    @FindAll({
            @FindBy(id = "sign-in-button")
    })
    @iOSFindBy(xpath = "")
    public WebElement signInButton;

    @FindBy(id = "remember-me")
    public WebElement rememberMeCheckbox;

    /* public SignInPage(WebDriver driver) {
         PageFactory.initElements(new AppiumFieldDecorator(driver), this);
     }*/

    public SignInPage(WebDriver driver, int type) {                 // переделать в case оператор
        if (type == 0) {
            PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        } else {
            PageFactory.initElements(driver, this);
        }
    }

  /*  public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);}*/


    public void signInInput(WebDriver driver, String login, String pass) {
        inputDataField(emailLogin, login, driver);
        inputDataField(password, pass, driver);
    }

    public void clickSignInButton(WebDriver driver) {

        clickElement(signInButton, driver);

    }
}

