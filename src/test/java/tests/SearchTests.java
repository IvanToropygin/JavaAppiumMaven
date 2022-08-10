package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class SearchTests extends CoreTestCase {
    @Test
    public void testFirstSearch() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForSearchResult("Island");
    }

    @Test
    public void testCancelSearch(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.waitForCancelBtnToAppear();
        searchPageObject.clickCancelSearch();
        searchPageObject.waitForCancelBtnToDisappear();
    }

    @Test
    public void testAmountOfNotEmptySearch(){
        String searchLine = "linkin park discography";

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        int amountSearchResults = searchPageObject.getAmountOfFoundArticles();

        assertTrue("We not found results", amountSearchResults > 0);
    }

    @Test
    public void testAmountOfEmptySearch(){
        String searchLine = "qwerty321";

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.waitForEmptyResultLabel();
        searchPageObject.assertNoResultOfSearch();
    }

    @Test
    public void testClearSearch(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clearSearchingField();
    }

    @Test
    public void testSearchTitleTextCompare(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.assertTitleHasText("Search…");
    }
}
