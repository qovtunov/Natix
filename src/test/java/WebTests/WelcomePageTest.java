package WebTests;

import Pages.ChangePasswordPage;
import Pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WelcomePageTest extends MainTestWeb {

    WelcomePage welcomePage;
    ChangePasswordPage changePasswordPage;

    @Test(dependsOnMethods = "WebTests.SignInPageTest.signIn", groups = "changePassword")
    public void changePassword() {
        welcomePage = new WelcomePage(driver, 1);
        clickElement(welcomePage.settingsButton, driver);
        clickElement(welcomePage.settingsChangePasswordOption, driver);

        changePasswordPage = new ChangePasswordPage(driver, 1);
        changePasswordPage.changePassword(getProperty("password"), getProperty("password"), driver);
        clickElement(changePasswordPage.finishButton, driver);
    }

    @Test(dependsOnMethods = "WebTests.SignInPageTest.signIn", groups = "changePasswordError")
    public void changePasswordError() {
        welcomePage = new WelcomePage(driver, 1);
        clickElement(welcomePage.settingsButton, driver);
        clickElement(welcomePage.settingsChangePasswordOption, driver);

        changePasswordPage = new ChangePasswordPage(driver, 1);
        changePasswordPage.changePassword(getProperty("password"), getProperty("password") + 1, driver);
        clickElement(changePasswordPage.finishButton, driver);

        Assert.assertTrue(changePasswordPage.passwordNewConf.getCssValue("animation").contains("shake") && changePasswordPage.passwordNewConf.getCssValue("color").equals("rgba(255, 0, 0, 1)"));
    }

    @Test(dependsOnMethods = "WebTests.SignInPageTest.signIn")
    public void showPodcastDetail() {
        welcomePage = new WelcomePage(driver, 1);
        clickElement(welcomePage.podcastItem, driver);

        Assert.assertTrue(isRedirectTo("durable-portfolio-construction", driver));
    }

    @Test(dependsOnMethods = "WebTests.SignInPageTest.signIn")
    public void viewAll() {
        welcomePage = new WelcomePage(driver, 1);
        clickElement(welcomePage.viewAllButton, driver);

        Assert.assertTrue(isRedirectTo("Episodes", driver));
    }

    @Test(dependsOnMethods = "WebTests.SignInPageTest.signIn")
    public void playPodcast() {
        welcomePage = new WelcomePage(driver, 1);
        clickElement(welcomePage.playButton, driver);

        Assert.assertTrue(isElementVisible(welcomePage.playerFooter, driver));
        System.out.println("nice!");
    }

}
