package com.planit.reusablefunctions;

import com.planit.locators.LandingPageLocators;
import static com.planit.util.PageActions.*;

public class LandingPageOperations {
    /**
     * This function opens the given page on website which are available top top pane of website
     * pre requisite - website should be open
     * @param pageName this is page name on website
     * */
    public static void openPage(String pageName) {
        waitForPageLoad();
        click(LandingPageLocators.LandingPageLinks(pageName));
    }
}
