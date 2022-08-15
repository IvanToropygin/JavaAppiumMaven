package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject {
    protected static String
            ARTICLE_BY_TITLE_TPL,
            REMOVE_FROM_SAVED_BUTTON,
            LIST_NAME_TPL;

    private static String getListXPathByName(String listName) {
        return LIST_NAME_TPL.replace("{LIST_NAME}", listName);
    }

    private static String getTitleByArticle(String articleTitle) {
        return ARTICLE_BY_TITLE_TPL.replace("{ARTICLE_TITLE}", articleTitle);
    }

    private static String getRemoveButtonByTittle(String articleTitle) {
        return REMOVE_FROM_SAVED_BUTTON.replace("{ARTICLE_TITLE}", articleTitle);
    }

    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void openListByName(String listName) {
        this.waitForElementAndClick(
                getListXPathByName(listName),
                "Cannot find '" + listName + "' list",
                15);
    }

    public void swipeLeftArticleToDelete(String articleTitle) {
        this.waitForArticleToAppearByTitle(articleTitle);
        String article_xpath = getListXPathByName(articleTitle);

        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            this.swipeElementToLeft(
                    getTitleByArticle(articleTitle),
                    "Cannot left swipe article");
        } else {
            String remove_locator = getRemoveButtonByTittle(articleTitle);
            this.waitForElementAndClick(remove_locator, "Cannot click button to remove article from saved.", 10);
        }

        if (Platform.getInstance().isIOS()) {
            this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article");
        }

        if (Platform.getInstance().isMW()){
            driver.navigate().refresh();
        }

        this.waitForArticleToDisappearByTitle(articleTitle);
    }

    public void waitForArticleToDisappearByTitle(String articleTitle) {
        this.waitForElementNotPresent(getTitleByArticle(articleTitle),
                "Article present: " + articleTitle, 15);
    }

    public void waitForArticleToAppearByTitle(String articleTitle) {
        this.waitForElementPresent(getTitleByArticle(articleTitle),
                "Article not displayed: " + articleTitle, 15);
    }
}
