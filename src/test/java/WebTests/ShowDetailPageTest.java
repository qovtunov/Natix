package WebTests;


import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ShowDetailPageTest extends MainTestWeb {

    ShowDetailPage showDetailPage;
    HeaderPage headerPage;
    FavoritesPage favoritesPage;
    PlaylistPage playlistPage;

    @Test (dependsOnMethods = {"WebTests.SignInPageTest.signIn", "WebTests.WelcomePageTest.showPodcastDetail"})
    public void addToFavorites() throws InterruptedException {
        showDetailPage = new ShowDetailPage(driver, 1);
        clickElement(showDetailPage.iconFavorites, driver);

        Assert.assertTrue(showDetailPage.iconFavorites.getAttribute("class").contains("icon-favorites-on"));

        String podcastItemTitle = showDetailPage.podcastItemTitle.getText().toLowerCase();
        headerPage = new HeaderPage(driver, 1);
        clickElement(headerPage.favoritesTab, driver);
        favoritesPage = new FavoritesPage(driver, 1);
        waitForElement(favoritesPage.podcastItemTitle, driver);

        Assert.assertEquals(podcastItemTitle, favoritesPage.podcastItemTitle.getText().toLowerCase());
    }

    @Test (dependsOnMethods = {"WebTests.SignInPageTest.signIn", "WebTests.WelcomePageTest.showPodcastDetail"})
    public void addToPlaylist(){
        showDetailPage = new ShowDetailPage(driver, 1);
        clickElement(showDetailPage.addToPlaylist, driver);

        Assert.assertTrue(showDetailPage.addToPlaylist.getAttribute("class").contains("icon-playlist-on"));
        String podcastItemTitle = showDetailPage.podcastItemTitle.getText().toLowerCase();

        headerPage = new HeaderPage(driver, 1);
        clickElement(headerPage.playlistTab, driver);
        playlistPage = new PlaylistPage(driver, 1);
        waitForElement(playlistPage.podcastItemTitle, driver);

        Assert.assertEquals(podcastItemTitle, playlistPage.podcastItemTitle.getText().toLowerCase());

    }
}
