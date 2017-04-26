package WebTests;

import Pages.SignInPage;
import Pages.WelcomePage;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignInPageTest extends MainTestWeb {

    SignInPage signInPage;
    WelcomePage welcomePage;

    @Test(groups = {"signuptestweb", "changePassword", "changePasswordError"})
    public void signIn () throws InterruptedException, IOException {
        setLogger();
        signInPage = new SignInPage(driver, 1);
        try {
            signInPage.signInInput(driver, getProperty("login"), getProperty("password"));
            signInPage.clickSignInButton(driver);
            logger.info("Login/Password passed, Sign In procedure in progress...");
        } catch (Exception e) {
            e.printStackTrace();
            logger.severe("Sign In procedure failed on entering credentials step!");
        }
        Thread.sleep(2000); ///change wait

       try {
           Assert.assertFalse(signInPage.emailLogin.getCssValue("animation").contains("shake")&& signInPage.emailLogin.getCssValue("color").equals("rgba(255, 0, 0, 1)"), "Sign In failed during submit step. Reason: wrong credentials. Test failed -");
       } catch (NoSuchElementException e){}

        welcomePage = new WelcomePage(driver, 1);

        Assert.assertTrue(isRedirectTo("Welcome", driver), "Sign In failed during submit step. Welcome page is not load. Test failed -");
        logger.info("Sign In completed. Test PASSED");
    }

    @Test(groups = {"signuptestweb"})
    public void signInRefresh() throws InterruptedException, IOException {
        signIn();
        driver.navigate().refresh();
        Assert.assertTrue(isElementVisible(signInPage.signInButton, driver));

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
        Thread.sleep(4000);

        //Assert.assertTrue(signInPage.emailLogin.getAttribute("ng-change").contains("hideError")&&signInPage.password.getAttribute("ng-change").contains("hideError"));
        System.out.println(signInPage.emailLogin.getCssValue("animation"));
        System.out.println(signInPage.emailLogin.getCssValue("color"));
        Assert.assertTrue(signInPage.emailLogin.getCssValue("animation").contains("shake")&& signInPage.emailLogin.getCssValue("color").equals("rgba(255, 0, 0, 1)"));
    }


}

