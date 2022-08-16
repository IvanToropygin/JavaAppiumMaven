package lib.tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class ChangeAppConditionTests extends CoreTestCase {
    @Test
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
        assertEquals("Title not compare after rotation", titleBeforeRotation, titleAfterRotation);
        this.rotateScreenPortrait();
        String titleAfterSecondRotation = articlePageObject.getArticleTitle();
        assertEquals("Title not compare after rotation", titleBeforeRotation, titleAfterSecondRotation);
    }

    @Test
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
