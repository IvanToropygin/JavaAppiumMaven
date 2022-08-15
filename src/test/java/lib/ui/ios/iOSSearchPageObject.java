package lib.ui.ios;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia']";
        SEARCH_INPUT = "xpath://XCUIElementTypeSearchField[@value='Search Wikipedia']";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://XCUIElementTypeLink[contains(@name, '{SUBSTRING}')]";
        SEARCH_CANCEL_BTN = "id:Close";
        SEARCh_EMPTY_RESULT_LABEL = "xpath://XCUIElementTypeStaticText[@name = 'No results found']";
        SEARCH_RESULT_ELEMENT = "xpath://XCUIElementTypeLink";
        //Нужно поменять локаторы под ios:
//            SEARCH_RESULT_ITEM_TITLES = "id:org.wikipedia:id/page_list_item_title";
//            SEARCH_RESULT_LOCATOR = "xpath://*[@resource-id = 'org.wikipedia:id/search_results_list']//*[@resource-id =" +
//                    " 'org.wikipedia:id/page_list_item_container']";
//            SEARCH_FIELD = "id:org.wikipedia:id/search_src_text";
    }

    public iOSSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
