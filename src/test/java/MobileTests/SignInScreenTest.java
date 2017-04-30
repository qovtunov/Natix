package MobileTests;

import Pages.SignInPage;
import Pages.WelcomePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;


public class SignInScreenTest extends MainTestMobile {

    SignInPage signInScreenAndroid;
    WelcomePage welcomeScreenAndroid;
    //SignInScreen signInScreeniOS;

    @Test(groups = {"androidtest", "changePassword", "changePasswordError"})
    public void signInAndroid() throws InterruptedException {
        signInScreenAndroid = new SignInPage(driver, 0);
        switchToWeb(driver);
        try {
            signInScreenAndroid.signInInput(driver, getProperty("login"), getProperty("password"));
            signInScreenAndroid.clickSignInButton(driver);
            logger.info("Login/Password passed, Sign In procedure in progress...");
        } catch (Exception e) {
            e.printStackTrace();
            logger.severe("Sign In procedure failed on entering credentials step!");
        }

        try {
            waitForElementStaleness(signInScreenAndroid.signInButton, driver);
            Assert.assertFalse(signInScreenAndroid.emailLogin.getCssValue("animation").contains("shake")&& signInScreenAndroid.emailLogin.getCssValue("color").equals("rgba(255, 0, 0, 1)"), "Sign In failed during submit step. Reason: wrong credentials. Test failed -");
        } catch (Exception e) {}

        welcomeScreenAndroid = new WelcomePage(driver, 0);

        Assert.assertTrue(isElementVisible(welcomeScreenAndroid.settingsButton, driver), "Sign In failed after submit step. Home screen is not loaded. Test failed - ");
        logger.info("Sign In completed. Test PASSED");
    }

    @Test(groups = {"androidtest"})
    public void signInErrorAndroid () throws InterruptedException {
        signInScreenAndroid = new SignInPage(driver, 0);
        switchToWeb(driver);
        signInScreenAndroid.signInInput(driver, getProperty("login") + "m", getProperty("password") + "1");
        signInScreenAndroid.clickSignInButton(driver);
        Thread.sleep(2000);
        System.out.println(signInScreenAndroid.emailLogin.getCssValue("animation"));
        System.out.println(signInScreenAndroid.emailLogin.getCssValue("color"));
        Assert.assertTrue(signInScreenAndroid.emailLogin.getCssValue("animation").contains("shake")&& signInScreenAndroid.emailLogin.getCssValue("color").equals("rgba(255, 0, 0, 1)"));
    }


}
