package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type=search]";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class, 'wikidata-description')][contains(text(), '{SUBSTRING}')]";
        SEARCH_CANCEL_BTN = "css:.header-action>button.cancel";
        SEARCH_EMPTY_RESULT_LABEL = "css:.mw-search-nonefound";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
    }

    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
