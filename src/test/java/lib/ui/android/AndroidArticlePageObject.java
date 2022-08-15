package lib.ui.android;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidArticlePageObject extends ArticlePageObject {
    static {
        TITLE = "id:org.wikipedia:id/view_page_title_text";
        FOOTER_ELEMENT = "xpath://*[@text = 'View page in browser']";
        OPTIONS_BTN = "xpath://android.widget.ImageView[@content-desc='More options']";
        ADD_TO_READING_LIST_BTN = "xpath://*[@text = 'Add to reading list']";
        GOT_IT_BTN = "id:org.wikipedia:id/onboarding_button";
        LIST_NAME_INPUT = "id:org.wikipedia:id/text_input";
        OK_BTN = "xpath://*[@text = 'OK']";
        LIST_NAME_TPL = "xpath://*[@text = '{LIST_NAME}']";
        CLOSE_ARTICLE_BTN = "xpath://android.widget.ImageButton[@content-desc = 'Navigate up']";
    }

    public AndroidArticlePageObject(RemoteWebDriver driver){
        super(driver);
    }
}
