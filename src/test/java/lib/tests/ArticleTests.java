package lib.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

@Epic("Tests for Articles")
public class ArticleTests extends CoreTestCase {
    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("Compare article title with expected one")
    @Description("We open find 'Java' articles, click at articles with 'sland' and expect title with 'ava'")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testCompareArticleTitle() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("sland");
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();

        String titleExpected = "ava";
        String titleActual = articlePageObject.getArticleTitle();

        Assert.assertEquals("unexpected title", titleActual, titleExpected);
    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("swipe article to the footer")
    @Description("We open find 'Java' articles, click at articles with 'bject-oriented programming language' and scroll to footer")
    @Severity(value = SeverityLevel.MINOR)
    public void testSwipeArticle() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("bject-oriented programming language");
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();
        articlePageObject.swipesToFooter();
    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("test Searching Articles And Cancel")
    @Description("We open find 'Appium' articles, and assert that fins more than one")
    @Severity(value = SeverityLevel.BLOCKER)
    public void testSearchingArticlesAndCancel(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Appium");
        Assert.assertTrue("Result of searching not more than 1",searchPageObject.getAmountOfFoundArticles() > 1);
        searchPageObject.clearSearchingField();
    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("test Articles Contains Searching Text")
    @Description("Search 'Java' articles Contains Searching Text 'Java'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testArticlesContainsSearchingText(){
        String search = "Java";
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(search);
        searchPageObject.assertTitlesHasText(search);
    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("test Articles Contains Searching Text")
    @Description("assert find article 'Java' contains Searching subtitle 'Island'")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testAssertTitle(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Island");
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();
    }
}
