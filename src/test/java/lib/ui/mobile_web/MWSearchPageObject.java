package lib.ui.mobile_web;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "css:button#searchIcon";
        SEARCH_INPUT = "css:form>input[type=search]";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://div[contains(@class, 'wikipedia-description')][contains(@text, {SUBSTRING})]";
        SEARCH_CANCEL_BTN = "css:button.cancel";
        SEARCh_EMPTY_RESULT_LABEL = "css:p.without-results";
        SEARCH_RESULT_ELEMENT = "css:ul.page-list>li.page-summary";
    }

    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
