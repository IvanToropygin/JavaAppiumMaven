package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class SearchPageObject extends MainPageObject {
    protected static String
            SEARCH_FIELD,
            SEARCH_RESULT_ITEM_TITLES,
            SEARCH_RESULT_LOCATOR,

            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_CANCEL_BTN,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_RESULT_ELEMENT,
            SEARCh_EMPTY_RESULT_LABEL;

    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    /*<TEMPLATES METHODS*/
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /*<TEMPLATES METHODS*/

    public void initSearchInput() {
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find search init on Main-page",
                5);
        this.waitForElementPresent(SEARCH_INPUT, "Cannot find search input On Search-page");
    }

    public void typeSearchLine(String searchLine) {
        this.waitForElementAndSendKeys(SEARCH_INPUT, searchLine,
                "Cannot find  and type in searchInput", 5);
    }

    public void waitForSearchResult(String substring) {
        this.waitForElementPresent(getResultSearchElement(substring),
                "Cannot find search result with: " + substring);
    }

    public void clickByArticleWithSubstring(String substring) {
        this.waitForElementAndClick(getResultSearchElement(substring),
                "Cannot find and click search result with: " + substring, 10);
    }

    public void waitForCancelBtnToAppear() {
        this.waitForElementPresent(SEARCH_CANCEL_BTN, "Cannot find search_close_btn", 5);
    }

    public void waitForCancelBtnToDisappear() {
        this.waitForElementPresent(SEARCH_CANCEL_BTN, "Cancel Btn is still displayed", 5);
    }

    public void clickCancelSearch() {
        this.waitForElementAndClick(SEARCH_CANCEL_BTN, "Cannot find and click search_close_btn",
                5);
    }

    public int getAmountOfFoundArticles() {
        this.waitForElementPresent(
                SEARCH_RESULT_LOCATOR,
                "Cannot find request.",
                15);
        return this.getAmountOfElements(SEARCH_RESULT_LOCATOR);
    }

    public void waitForEmptyResultLabel() {
        this.waitForElementPresent(SEARCh_EMPTY_RESULT_LABEL, "Cannot find empty result label", 15);
    }

    public void clearSearchingField() {
        this.waitForElementAndClear(SEARCH_FIELD, "Field don't cleared", 5);
    }

    public void assertNoResultOfSearch() {
        this.assertElementNotPresent(SEARCH_RESULT_LOCATOR, "Search result must be 0");
    }

    public void assertTitleHasText(String searchInputMustHaveText) {
        this.assertElementHasText(SEARCH_FIELD, searchInputMustHaveText, "Text in input field don't compare");
    }

    public void assertTitlesHasText(String titlesMustHaveText) {
        this.assertElementsHasText(SEARCH_RESULT_ITEM_TITLES, titlesMustHaveText);
    }
}
