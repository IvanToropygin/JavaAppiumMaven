package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class iOSArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "id:Java (programming language)";
        FOOTER_ELEMENT = "id:View article in browser";
        ADD_TO_READING_LIST_BTN = "id:Save for later";
        CLOSE_ARTICLE_BTN = "id:Back";
    }

    public iOSArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }
}
