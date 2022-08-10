package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

public class MyListTests extends CoreTestCase {
    private static final String nameOfList = "Learning Java";

    @Test
    public void testSaveFirstArticleToMyList(){
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);

        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine("Java");
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        articlePageObject.waitForTitleElement();
        String articleTitle = articlePageObject.getArticleTitle();

        if(Platform.getInstance().isAndroid()){
            articlePageObject.addArticleToNewList(nameOfList);
        } else {
            articlePageObject.addArticlesToMySaved();
        }

        articlePageObject.closeArticle();

        NavigationUI navigationUI = NavigationUIFactory.get(driver);
        navigationUI.clickMyLists();

        MyListsPageObject myListsPageObject = MyListsPageObjectFactory.get(driver);

        if(Platform.getInstance().isAndroid()){
            myListsPageObject.openListByName(nameOfList);
        }

        myListsPageObject.swipeLeftArticleToDelete(articleTitle);
    }

    @Test
    public void testSaveTwoArticlesToMyList(){
        String searchLine = "Java";
        SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        searchPageObject.initSearchInput();
        searchPageObject.typeSearchLine(searchLine);
        searchPageObject.clickByArticleWithSubstring("Object-oriented programming language");
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