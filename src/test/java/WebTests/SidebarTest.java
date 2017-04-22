package WebTests;

import Pages.ShowDetailPage;
import Pages.Sidebar;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SidebarTest extends MainTestWeb {

    Sidebar sidebar;
    ShowDetailPage showDetailPage;

    @Test(dependsOnMethods = "WebTests.SignInPageTest.signIn")
    public void toggleSidebar() throws InterruptedException {

        sidebar = new Sidebar(driver, 1);
        clickElement(sidebar.sidebarToggle, driver);

        Assert.assertTrue(isElementVisible(sidebar.sideBarShow, driver)&&isElementVisible(sidebar.sideBarPlaylistButton, driver));

    }

    @Test(dependsOnMethods = {"WebTests.SignInPageTest.signIn", "toggleSidebar"})
    public void sidebarRedirectToShow(){
        String sidebarShowTitle = sidebar.sidebarShowTitle.getText();
        clickElement(sidebar.sideBarShow, driver);

        showDetailPage = new ShowDetailPage(driver, 1);
        waitForElement(showDetailPage.showDetailPageTitle, driver);
        String showTitle = showDetailPage.showDetailPageTitle.getText();

        Assert.assertTrue(sidebarShowTitle.contains(showTitle));

    }

    @Test(dependsOnMethods = {"WebTests.SignInPageTest.signIn", "toggleSidebar"})
    public void sidebarRedirectToPlaylist() {
        clickElement(sidebar.sideBarPlaylistButton, driver);

        Assert.assertTrue(isRedirectTo("Playlist", driver));
    }

}
