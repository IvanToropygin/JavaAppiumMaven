package lib.tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import org.junit.Test;

public class GetStartedTest extends CoreTestCase {
    @Test
    public void testPassThroughWelcome(){
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()){return;}

        WelcomePageObject welcomePageObject = new WelcomePageObject(driver);
        welcomePageObject.waitForLearnMoreLink();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForNewWaysToExplore();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForAddOrEditPreferredLangText();
        welcomePageObject.clickNextButton();

        welcomePageObject.waitForMoreAboutDataCollectedText();
        welcomePageObject.clickGetStartedButton();
    }
}
