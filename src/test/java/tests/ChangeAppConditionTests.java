package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase {
    @Test
    @Features(value = {@Feature(value = "Orientation"), @Feature(value = "Article")})
    @DisplayName("test change screen orientation on search result")
    @Description("assert title don't change after changing screen orientation")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testChangeScreenOrientationOnSearchResult(){
        if (Platform.getInstance().isMW()){
            return;
        }

        String searchLine = "Java";

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.clickByArticleWithSubstring("Island");
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        String titleBeforeRotation = articlePageObject.getArticleTitle();
        this.rotateScreenLandscape();
        String titleAfterRotation = articlePageObject.getArticleTitle();
        Assert.assertEquals("Title not compare after rotation", titleBeforeRotation, titleAfterRotation);
        this.rotateScreenPortrait();
        String titleAfterSecondRotation = articlePageObject.getArticleTitle();
        Assert.assertEquals("Title not compare after rotation", titleBeforeRotation, titleAfterSecondRotation);
    }

    @Test
    @Features(value = {@Feature(value = "Background"), @Feature(value = "Article")})
    @DisplayName("test check search article in background")
    @Description("assert title don't change after going in background and back")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testCheckSearchArticleInBackground(){

        if (Platform.getInstance().isMW()){
            return;
        }

        String searchLine = "Java";

        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.waitForSearchResult("sland");
        this.backgroundApp(2);
        searchPageObject.waitForSearchResult("sland");
    }
}
