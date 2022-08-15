package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListsPageObject extends MyListsPageObject {
    static {
            ARTICLE_BY_TITLE_TPL = "xpath://*[@text = '{ARTICLE_TITLE}']";
            LIST_NAME_TPL = "xpath://*[@text = '{LIST_NAME}']";}

    public AndroidMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
