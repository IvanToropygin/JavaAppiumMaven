package lib.ui.android;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {
    static{
            SEARCH_INIT_ELEMENT = "xpath://*[contains(@text, 'Search Wikipedia')]";
            SEARCH_INPUT = "xpath://*[contains(@text, 'Search…')]";
            SEARCH_FIELD = "id:org.wikipedia:id/search_src_text";
            SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id = 'org.wikipedia:id/page_list_item_container']" +
                    "//*[contains(text(), '{SUBSTRING}')]";
            SEARCH_CANCEL_BTN = "id:org.wikipedia:id/search_close_btn";
            SEARCH_EMPTY_RESULT_LABEL = "xpath://*[@text = 'No results found']";
            SEARCH_RESULT_ITEM_TITLES = "id:org.wikipedia:id/page_list_item_title";
            SEARCH_RESULT_LOCATOR = "xpath://*[@resource-id = 'org.wikipedia:id/search_results_list']//*[@resource-id =" +
                    " 'org.wikipedia:id/page_list_item_container']";
    }

    public AndroidSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
