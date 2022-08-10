package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class iOSMyListsPageObject extends MyListsPageObject {
    static {ARTICLE_BY_TITLE_TPL = "xpath://XCUIElementTypeLink[Contains(@name, '{ARTICLE_TITLE}']";}

    public iOSMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
