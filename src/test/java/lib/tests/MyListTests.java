package lib.tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class MyListTests extends CoreTestCase {
    private static final String nameOfList = "Learning Java",
            login = "",
            password = "";

    @Test
    @Features(value = {@Feature(value = "List for reading"), @Feature(value = "Article")})
    @DisplayName("test save first article to my list")
    @Description("assert that save first article to my list is working")
    @Severity(value = SeverityLevel.NORMAL)
    public void testSaveFirstArticleToMyList() {
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();
        String articleTitle = articlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {
            articlePageObject.addArticleToNewList(nameOfList);
        } else {
            articlePageObject.addArticlesToMySaved();
        }
        if (Platform.getInstance().isMW()) {
            AuthorizationPageObject auth = new AuthorizationPageObject(driver);
            auth.clickAuthButton();
            auth.enterLoginData(login, password);
            auth.submitForm();

            articlePageObject.waitForTitleElement();

            Assert.assertEquals("We are not on the same page after login.", articleTitle, articlePageObject.getArticleTitle());

            articlePageObject.addArticlesToMySaved();
        }

        articlePageObject.closeArticle();

        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        navigationUI.openNavigation();
        navigationUI.clickMyLists();

        MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);

        if (Platform.getInstance().isAndroid()) {
            myListsPageObject.openListByName(nameOfList);
        }

        myListsPageObject.swipeLeftArticleToDelete(articleTitle);
    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Article")})
    @DisplayName("test save two articles to my list")
    @Description("save two articles to my list, then delete first article from list")
    @Severity(value = SeverityLevel.NORMAL)
    public void testSaveTwoArticlesToMyList() {
        String searchLine = "Java";
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.clickByArticleWithSubstring("bject-oriented programming language");
        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();

        String firstArticleTitle = articlePageObject.getArticleTitle();
        String nameOfList = "HomeWork";

        articlePageObject.addArticleToNewList(nameOfList);
        articlePageObject.closeArticle();

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.clickByArticleWithSubstring("High-level");
        articlePageObject.waitForTitleElement();
        String secondArticleTitle = articlePageObject.getArticleTitle();
        articlePageObject.addArticleToExistingList(nameOfList);
        articlePageObject.closeArticle();

        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        navigationUI.clickMyLists();

        MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);
        myListsPageObject.openListByName(nameOfList);
        myListsPageObject.swipeLeftArticleToDelete(firstArticleTitle);

        myListsPageObject.waitForArticleToDisappearByTitle(firstArticleTitle);
        myListsPageObject.waitForArticleToAppearByTitle(secondArticleTitle);
    }
}
