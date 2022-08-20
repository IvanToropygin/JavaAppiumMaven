package lib.ui.mobile_web;

import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUi extends NavigationUI {
    static {
        MY_LISTS_LINK = "xpath://*[text() = 'Watchlist']";
        OPEN_NAVIGATION = "css:#mw-mf-main-menu-button";
        LOG_IN_BTN = "xpath://*[text() = 'Log in']";
        REMOVE_TOP_ARTICLE_FROM_MY_LIST = "css:#mw-content-text li:first-child > .watched";
        AMOUNT_TITLES_IN_MY_LIST = "css:ul> li.with-watchstar";
    }

    public MWNavigationUi(RemoteWebDriver driver){
        super(driver);
    }
}
