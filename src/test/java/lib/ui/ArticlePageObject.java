package lib.ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

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
            OPTIONS_REMOVE_FROM_MY_LIST_BTN,
            CLOSE_ARTICLE_BTN;

    public ArticlePageObject(RemoteWebDriver driver){
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
        } else if (Platform.getInstance().isIOS()){
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }

    }

    public void swipesToFooter(){
        if (Platform.getInstance().isAndroid()){
            this.swipeUpToFindElement(FOOTER_ELEMENT,"Cannot find end of article",40);
        } else if (Platform.getInstance().isIOS()){
            this.swipeUpTitleElementAppear(FOOTER_ELEMENT, "Cannot swipe to footer", 40);
        } else {
            this.scrollWebPageTitleElementNotVisible(FOOTER_ELEMENT,"Cannot find end of article",40);
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
        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
            this.waitForElementAndClick(CLOSE_ARTICLE_BTN,"Cannot find X button click",5);
        } else {
            System.out.println("Method closeArticle() do nothing for platform " + Platform.getInstance().getPlatformVar());
        }
    }

    public void addArticlesToMySaved(){
        if(Platform.getInstance().isMW()){
            this.removeArticleFromSavedIfItAdded();
        }
        this.waitForElementAndClick(ADD_TO_READING_LIST_BTN, "Cannot find and click add to list button", 5);
    }

    public void removeArticleFromSavedIfItAdded(){
        if(this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BTN)) {
            this.waitForElementAndClick(OPTIONS_REMOVE_FROM_MY_LIST_BTN,
                    "Cannot find and click button to remove article from saved", 1);
            this.waitForElementPresent(ADD_TO_READING_LIST_BTN, "Cannot find option to add article to reading list");
        }
    }
}
