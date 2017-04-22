package WebTests;


import Pages.HeaderPage;
import junit.framework.Assert;
import org.testng.annotations.Test;

public class HeaderWebTest extends MainTestWeb {

    HeaderPage headerPage;

    @Test (dependsOnMethods = "WebTests.SignInPageTest.signIn")
    public void goToShowsTab() {
        headerPage = new HeaderPage(driver, 1);
        clickElement(headerPage.showsTab, driver);

        Assert.assertTrue(isRedirectTo("Shows", driver));
    }
}