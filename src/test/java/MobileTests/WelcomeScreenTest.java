package MobileTests;

import Pages.ChangePasswordPage;
import Pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WelcomeScreenTest extends MainTestMobile {
    WelcomePage welcomeScreenAndroid;
    ChangePasswordPage changePasswordScreenAndroid;

    @Test(dependsOnMethods = "MobileTests.SignInScreenTest.signInAndroid", groups = "changePassword")
    public void changePasswordAndroid(){
        welcomeScreenAndroid = new WelcomePage(driver, 0);
        clickElement(welcomeScreenAndroid.settingsButton, driver);
        clickElement(welcomeScreenAndroid.settingsChangePasswordOption, driver);

        changePasswordScreenAndroid = new ChangePasswordPage(driver, 0);
        changePasswordScreenAndroid.changePassword(getProperty("password"), getProperty("password"), driver);
        clickElement(changePasswordScreenAndroid.finishButton, driver);
    }

    @Test(dependsOnMethods = "MobileTests.SignInScreenTest.signInAndroid", groups = "changePasswordError")
    public void changePasswordError(){
        welcomeScreenAndroid = new WelcomePage(driver, 0);
        clickElement(welcomeScreenAndroid.settingsButton, driver);
        clickElement(welcomeScreenAndroid.settingsChangePasswordOption, driver);

        changePasswordScreenAndroid = new ChangePasswordPage(driver, 0);
        changePasswordScreenAndroid.changePassword(getProperty("password"), getProperty("password") + 1, driver);
        clickElement(changePasswordScreenAndroid.finishButton, driver);

        Assert.assertTrue(changePasswordScreenAndroid.passwordNewConf.getCssValue("animation").contains("shake")&& changePasswordScreenAndroid.passwordNewConf.getCssValue("color").equals("rgba(255, 0, 0, 1)"));
    }


}
