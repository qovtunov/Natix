package MobileTests;


import Pages.HeaderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderScreenTest extends MainTestMobile {

    HeaderPage headerScreenAndroid;

    @Test (dependsOnMethods = "MobileTests.SignInScreenTest.signInAndroid")
    public void goToShowsTabAndroid() {
        headerScreenAndroid = new HeaderPage(driver, 0);
        clickElement(headerScreenAndroid.showsTab, driver);

        Assert.assertTrue(isRedirectTo("Shows", driver));
    }
}