package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        ADD_TO_READING_LIST_BTN = "css:#ca-watch";
        OPTIONS_REMOVE_FROM_MY_LIST_BTN = "css:#ca-watch[href$='unwatch']";
    }

    public MWArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }
}
