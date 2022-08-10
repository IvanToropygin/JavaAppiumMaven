package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject{
    protected static String
            TITLE,
            FOOTER_ELEMENT,
            OPTIONS_BTN,
            ADD_TO_READING_LIST_BTN,
            GOT_IT_BTN,
            LIST_NAME_INPUT,
            OK_BTN,
            LIST_NAME_TPL,
            CLOSE_ARTICLE_BTN;

    public ArticlePageObject(AppiumDriver driver){
        super(driver);
    }

    private static String getListXPathByName(String listName){
        return LIST_NAME_TPL.replace("{LIST_NAME}", listName);
    }

    public WebElement waitForTitleElement(){
        return this.waitForElementPresent(TITLE,
                "Cannot find article title on page", 15);
    }

    public String getArticleTitle(){
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()){
            return waitForTitleElement().getAttribute("text");
        } else {return title_element.getAttribute("name");}

    }

    public void swipesToFooter(){
        if (Platform.getInstance().isAndroid()){
            this.swipeUpToFindElement(FOOTER_ELEMENT,"Cannot find end of article",40);
        } else {
            this.swipeUpTitleElementAppear(FOOTER_ELEMENT, "Cannot swipe to footer", 40);
        }

    }

    public void addArticleToNewList(String newListName){
        this.waitForElementAndClick(OPTIONS_BTN, "Cannot find button to open article options",5);
        this.waitForElementAndClick(ADD_TO_READING_LIST_BTN,"Cannot find option to add article to reading list",5);
        this.waitForElementAndClick(GOT_IT_BTN,"Cannot find 'GOT IT' tip overlay",5);
        this.waitForElementAndClear(LIST_NAME_INPUT,"Cannot find input to clear list name",5);
        this.waitForElementAndSendKeys(LIST_NAME_INPUT, newListName, "Cannot find input to set list name",5);
        this.waitForElementAndClick(OK_BTN,"Cannot find 'OK' button",5);
    }

    public void addArticleToExistingList(String listName){
        this.waitForElementAndClick(OPTIONS_BTN, "Cannot find button to open article options",5);
        this.waitForElementAndClick(ADD_TO_READING_LIST_BTN,"Cannot find option to add article to reading list",5);
        this.waitForElementAndClick(getListXPathByName(listName),"Cannot find existing list name",5);
    }

    public void closeArticle(){
        this.waitForElementAndClick(CLOSE_ARTICLE_BTN,"Cannot find X button click",5);
    }

    public void addArticlesToMySaved(){
        this.waitForElementAndClick(ADD_TO_READING_LIST_BTN, "Cannot find and click add to list button", 5);
    }
}
