package WebTests;


import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FavoritesPageTest extends MainTestWeb {
    ShowDetailPage showDetailPage;
    HeaderPage headerPage;
    FavoritesPage favoritesPage;
    ShowsPage showsPage;

    @Test(dependsOnMethods = {"WebTests.SignInPageTest.signIn", "WebTests.WelcomePageTest.showPodcastDetail", "WebTests.ShowDetailPageTest.addToFavorites"})
    public void deleteFromFavorites(){
        favoritesPage = new FavoritesPage(driver, 1);
        clickElement(favoritesPage.podcastItemDelete, driver);

        Assert.assertFalse(isElementVisible(favoritesPage.podcastItemTitle, driver)); //change this assert like in course staleelement

        headerPage = new HeaderPage(driver, 1);
        clickElement(headerPage.showsTab, driver);
        showsPage = new ShowsPage(driver, 1);
        clickElement(showsPage.podcastItem, driver);

        showDetailPage = new ShowDetailPage(driver, 1);

        Assert.assertFalse(showDetailPage.iconFavorites.getAttribute("class").contains("icon icon-favorites icon-favorites-on"));

    }
}
