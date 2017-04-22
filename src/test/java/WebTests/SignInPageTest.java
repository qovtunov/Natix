package WebTests;

import Pages.SignInPage;
import Pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInPageTest extends MainTestWeb {

    SignInPage signInPage;
    WelcomePage welcomePage;

    @Test(groups = {"signuptestweb", "changePassword", "changePasswordError"})
    public void signIn () throws InterruptedException {
        signInPage = new SignInPage(driver, 1);
        signInPage.signInInput(driver, getProperty("login"), getProperty("password"));
        signInPage.clickSignInButton(driver);

        welcomePage = new WelcomePage(driver, 1);

        Assert.assertTrue(isElementVisible(welcomePage.settingsButton, driver));
    }

    @Test(groups = {"signuptestweb"})
    public void signInRefresh() throws InterruptedException {
        signIn();
        driver.navigate().refresh();

        Assert.assertTrue(isElementVisible(signInPage.signInButton, driver));

        System.out.println(signInPage.emailLogin.getCssValue("animation"));
        System.out.println(signInPage.emailLogin.getCssValue("color"));
    }

    @Test(groups = {"signuptestweb"})
    public void signInRemember () throws InterruptedException {
        signInPage = new SignInPage(driver, 1);
        signInPage.signInInput(driver, getProperty("login"), getProperty("password"));
        clickElement(signInPage.rememberMeCheckbox, driver);
        signInPage.clickSignInButton(driver);

        welcomePage = new WelcomePage(driver, 1);


        Assert.assertTrue(isElementVisible(welcomePage.settingsButton, driver));
        

        driver.navigate().refresh();

        Assert.assertTrue(isRedirectTo("Welcome", driver));
    }

    @Test(groups = {"signuptestweb"})
    public void signInError () throws InterruptedException {
        signInPage = new SignInPage(driver, 1);
        signInPage.signInInput(driver, getProperty("login") + "m", getProperty("password") + "1");
        signInPage.clickSignInButton(driver);
        Thread.sleep(2000);

        //Assert.assertTrue(signInPage.emailLogin.getAttribute("ng-change").contains("hideError")&&signInPage.password.getAttribute("ng-change").contains("hideError"));
        System.out.println(signInPage.emailLogin.getCssValue("animation"));
        System.out.println(signInPage.emailLogin.getCssValue("color"));
        Assert.assertTrue(signInPage.emailLogin.getCssValue("animation").contains("shake")&& signInPage.emailLogin.getCssValue("color").equals("rgba(255, 0, 0, 1)"));
    }


}

