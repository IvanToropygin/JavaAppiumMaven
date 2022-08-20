package lib.ui;

import lib.Platform;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject {
    protected static String
            MY_LISTS_LINK,
            LOG_IN_BTN,
            OPEN_NAVIGATION,
            REMOVE_TOP_ARTICLE_FROM_MY_LIST,
            AMOUNT_TITLES_IN_MY_LIST;

    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    public void openNavigation(){
        if(Platform.getInstance().isMW()){
            this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click navigation button.", 5);
        } else {
            System.out.println("Method openNavigation() do nothing for platform: " + Platform.getInstance().getPlatformVar());
        }
    }

    public void clickMyLists()
    {
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My list",
                    5
            );
        } else {
            this.waitForElementAndClick(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My list",
                    5
            );
        }
    }

    public void clickLogIn(){
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(
                    LOG_IN_BTN,
                    "Cannot find 'Log in' button in My list",
                    5
            );
        } else {
            this.waitForElementAndClick(
                    LOG_IN_BTN,
                    "Cannot find 'Log in' button in My list",
                    5
            );
        }
    }

    public void removeTopArticleFromMyList(){
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(
                    REMOVE_TOP_ARTICLE_FROM_MY_LIST,
                    "Cannot find 'removeTopArticleFromMyList' button in My list",
                    5
            );
        } else {
            this.waitForElementAndClick(
                    REMOVE_TOP_ARTICLE_FROM_MY_LIST,
                    "Cannot find 'removeTopArticleFromMyList' button in My list",
                    5
            );
        }
    }

    public void assertAmountArticlesInMyList(int expectedTitlesAmount){
        int amountActual = this.getAmountOfElements(AMOUNT_TITLES_IN_MY_LIST);
        Assert.assertEquals("number of titles displayed is not as expected", expectedTitlesAmount, amountActual);
    }
}
