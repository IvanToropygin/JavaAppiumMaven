package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class SearchTests extends CoreTestCase {
    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("test check Searching")
    @Description("check the searching line is worked")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testFirstSearch() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForSearchResult("sland");
    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("test cancel search")
    @Description("cancel search after typing in search line")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testCancelSearch(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForCancelBtnToAppear();
        searchPageObject.clickCancelSearch();
        searchPageObject.waitForCancelBtnToDisappear();
    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("test amount of search more then 1")
    @Description("assert amount of search more then 1")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testAmountOfNotEmptySearch(){
        String searchLine = "linkin park discography";

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        int amountSearchResults = searchPageObject.getAmountOfFoundArticles();

        Assert.assertTrue("We not found results", amountSearchResults > 0);
    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("test amount of empty search with incorrect input")
    @Description("assert empty results searching with incorrect input")
    @Severity(value = SeverityLevel.NORMAL)
    public void testAmountOfEmptySearch(){
        String searchLine = "qwerty321";

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.waitForEmptyResultLabel();
        searchPageObject.assertNoResultOfSearch();
    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("test clear search field")
    @Description("assert clear search field after input")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testClearSearch(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clearSearchingField();
    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("test search title text compare 'Search…'")
    @Description("assert search line title text is 'Search…'")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testSearchTitleTextCompare(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.assertTitleHasText("Search…");
    }
}
