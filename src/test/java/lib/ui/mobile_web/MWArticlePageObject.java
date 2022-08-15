package lib.ui.mobile_web;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "css:#contact h1";
        FOOTER_ELEMENT = "css:footer";
        ADD_TO_READING_LIST_BTN = "css:#page-actions li#ca-watch.mw-ui-icon-mf-watch button";
        OPTIONS_REMOVE_FROM_MY_LIST_BTN = "css:#page-actions li#ca-watch.mw-ui-icon-mf-watched watched button";
    }

    public MWArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }
}