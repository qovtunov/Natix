package MobileTests;

import Pages.FavoritesPage;
import Pages.HeaderPage;
import Pages.ShowDetailPage;
import Pages.ShowsPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;


public class ShowDetailScreenTest extends MainTestMobile {

    ShowDetailPage showDetailScreenAndroid;
    HeaderPage headerScreenAndroid;
    FavoritesPage favoritesScreenAndroid;
    ShowsPage showsScreenAndroid;

    @Test(dependsOnMethods = "MobileTests.SignInScreenTest.signInAndroid")
    public void addToFavoritesAndroid() throws InterruptedException {
        showsScreenAndroid = new ShowsPage(driver, 0);
        clickElement(showsScreenAndroid.podcastItem, driver);
        showDetailScreenAndroid = new ShowDetailPage(driver, 0);
        clickElement(showDetailScreenAndroid.podcastItemDots, driver);
        clickElement(showDetailScreenAndroid.addToFavorites, driver);
        headerScreenAndroid = new HeaderPage(driver, 0);
        Thread.sleep(1000);
        wait.until(visibilityOf(headerScreenAndroid.favoritesTab));
        clickElement(headerScreenAndroid.favoritesTab, driver);
        favoritesScreenAndroid = new FavoritesPage(driver, 0);

        Assert.assertTrue(favoritesScreenAndroid.podcastItemTitle.getText().contains("Durable Portfolio Construction"));
    }


    @Test(dependsOnMethods = "MobileTests.SignInScreenTest.signInAndroid")
    public void episodePlay() throws InterruptedException {
        showsScreenAndroid = new ShowsPage(driver, 0);
        clickElement(showsScreenAndroid.podcastItem, driver);
        showDetailScreenAndroid = new ShowDetailPage(driver, 0);
        clickElement(showDetailScreenAndroid.podcastItem, driver);

        ///Assert is not posible on samsung

    }

    @Test(dependsOnMethods = {"MobileTests.SignInScreenTest.signInAndroid", "addToFavoritesAndroid"})
    public void removeFromFavoritesAndroid() throws InterruptedException {
        ((AppiumDriver) driver).context("NATIVE_APP");

        Thread.sleep(6000);
        //WebElement slider = driver.findElement(By.id("favourite-episodes"));
        WebElement slider = driver.findElement(By.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.widget.Image[1]"));
        Point sliderLocation = getCenter(slider);
        ((AppiumDriver) driver).swipe(sliderLocation.getX(), sliderLocation.getY(), sliderLocation.getX()+300, sliderLocation.getY(), 3000);
        //((AppiumDriver) driver).swipe(slider.getLocation().getX(), slider.getLocation().getY(), slider.getLocation().getX()+300, slider.getLocation().getY(), 3000);
        switchToWeb(driver);
        driver.findElement(By.cssSelector("#favourite-episodes .delete:first-child")).click();

        Assert.assertTrue(isElementNotVisible(slider, driver)&&isElementNotVisible(driver.findElement(By.cssSelector("#favourite-episodes .delete:first-child")), driver));
    }


    private Point getCenter(WebElement element) {
        Point upperLeft = element.getLocation();
        Dimension dimensions = element.getSize();
        return new Point(upperLeft.getX() + dimensions.getWidth()/2, upperLeft.getY() + dimensions.getHeight()/2);

    }


}
