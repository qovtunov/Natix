package MobileTests;


import Pages.EpisodesPage;
import Pages.HeaderPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EpisodesScreenTest extends MainTestMobile {

    HeaderPage headerScreenAndroid;
    EpisodesPage episodesScreenAndroid;

    @Test(dependsOnMethods = "MobileTests.SignInScreenTest.signInAndroid")
    public void searchResultAndroid() throws InterruptedException {
        headerScreenAndroid = new HeaderPage(driver, 0);
        clickElement(headerScreenAndroid.episodesTab, driver);

        episodesScreenAndroid = new EpisodesPage(driver, 0);
        Thread.sleep(3000); ///remove it
        waitForElement(episodesScreenAndroid.searchField, driver);
        inputDataField(episodesScreenAndroid.searchField, "Dave", driver);

        Assert.assertTrue(isElementVisible(episodesScreenAndroid.searchResultItem,driver));
    }

}
