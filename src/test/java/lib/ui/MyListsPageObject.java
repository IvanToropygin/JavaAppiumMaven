package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

abstract public class MyListsPageObject extends MainPageObject{
    protected static String
            ARTICLE_BY_TITLE_TPL,
            LIST_NAME_TPL;

    private static String getListXPathByName(String listName){
        return LIST_NAME_TPL.replace("{LIST_NAME}", listName);
    }

    private static String getTitleByArticle(String articleTitle){
        return ARTICLE_BY_TITLE_TPL.replace("{ARTICLE_TITLE}", articleTitle);
    }

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void openListByName(String listName){
        this.waitForElementAndClick(
                getListXPathByName(listName),
                "Cannot find '" + listName + "' list",
                15);
    }

    public void swipeLeftArticleToDelete(String articleTitle){
        this.waitForArticleToAppearByTitle(articleTitle);
        String article_xpath = getListXPathByName(articleTitle);
        this.swipeElementToLeft(
                getTitleByArticle(articleTitle),
                "Cannot left swipe article");

        if(Platform.getInstance().isIOS()){
            this.clickElementToTheRightUpperCorner(article_xpath, "Cannot find saved article");
        }

        this.waitForArticleToDisappearByTitle(articleTitle);
    }

    public void waitForArticleToDisappearByTitle(String articleTitle){
        this.waitForElementNotPresent(getTitleByArticle(articleTitle),
                "Article present: " + articleTitle, 15);
    }

    public void waitForArticleToAppearByTitle(String articleTitle){
        this.waitForElementPresent(getTitleByArticle(articleTitle),
                "Article not displayed: " + articleTitle, 15);
    }
}
