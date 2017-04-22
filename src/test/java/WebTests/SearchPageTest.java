package WebTests;


import Pages.HeaderPage;
import Pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTest extends MainTestWeb{

    HeaderPage headerPage;
    SearchResultPage searchResultPage;

    @Test (dependsOnMethods = "WebTests.SignInPageTest.signIn")
    public void redirectToSearchResult(){
        headerPage = new HeaderPage(driver, 1);
        inputDataField(headerPage.searchField, "Davi", driver);

        Assert.assertTrue(isRedirectTo("SearchResults", driver));

        searchResultPage = new SearchResultPage(driver, 1);

        Assert.assertTrue(isElementVisible(searchResultPage.searchResultItem, driver));
    }

    @Test(dependsOnMethods = {"WebTests.SignInPageTest.signIn", "redirectToSearchResult"})
    public void filterSearchResult(){
        clickElement(searchResultPage.categoryCheckBox, driver);

        Assert.assertFalse(isElementVisible(searchResultPage.searchResultItem, driver)); //change this assert
    }
}
