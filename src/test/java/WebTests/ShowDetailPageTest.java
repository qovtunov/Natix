package WebTests;


import Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test (dependsOnMethods = {"WebTests.SignInPageTest.signIn", "WebTests.WelcomePageTest.showPodcastDetail"})
    public void subscribe() throws InterruptedException {
        showDetailPage = new ShowDetailPage(driver, 1);
        waitForElement(showDetailPage.podcastItemTitle, driver);

        clickElement(showDetailPage.subscribeButton, driver);
        Assert.assertEquals(showDetailPage.subscribeButton.getText(), "Subscribed");

        ArrayList<String> actualList = new ArrayList<String>();
        ArrayList<String> expectedList = new ArrayList<String>();

        for (int i = 0; i < showDetailPage.podcastTitles.size(); i ++){
            expectedList.add(showDetailPage.podcastTitles.get(i).getText().toLowerCase());
        }

        headerPage = new HeaderPage(driver, 1);
        clickElement(headerPage.playlistTab, driver);
        playlistPage = new PlaylistPage(driver, 1);
        waitForElement(playlistPage.podcastItemTitle, driver);

        for (int i = 0; i < playlistPage.playlistTitles.size(); i ++){
            actualList.add(playlistPage.playlistTitles.get(i).getText().toLowerCase());
        }

        Assert.assertTrue(actualList.equals(expectedList));
    }

    @Test (dependsOnMethods = {"WebTests.SignInPageTest.signIn", "WebTests.WelcomePageTest.showPodcastDetail"})
    public void subscribeInfo() throws InterruptedException {
        showDetailPage = new ShowDetailPage(driver, 1);
        hoverOverElement(showDetailPage.subscribeInfoButton, driver);
        Assert.assertTrue(showDetailPage.subscribeInfoHover.isDisplayed());
    }

}
