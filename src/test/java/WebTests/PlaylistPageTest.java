package WebTests;


import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistPageTest extends MainTestWeb {

    ShowDetailPage showDetailPage;
    HeaderPage headerPage;
    ShowsPage showsPage;
    PlaylistPage playlistPage;

    @Test(dependsOnMethods = {"WebTests.SignInPageTest.signIn", "WebTests.WelcomePageTest.showPodcastDetail", "WebTests.ShowDetailPageTest.addToPlaylist"})
    public void deleteFromPlaylist(){
        playlistPage = new PlaylistPage(driver, 1);
        clickElement(playlistPage.deleteFromPlaylist, driver);

        Assert.assertFalse(isElementVisible(playlistPage.podcastItemTitle, driver));

        headerPage = new HeaderPage(driver, 1);
        clickElement(headerPage.showsTab, driver);

        showsPage = new ShowsPage(driver, 1);
        clickElement(showsPage.podcastItem, driver);

        showDetailPage = new ShowDetailPage(driver, 1);

        Assert.assertFalse(showDetailPage.iconFavorites.getAttribute("class").contains("icon icon-playlist icon-playlist-on"));
    }

}
