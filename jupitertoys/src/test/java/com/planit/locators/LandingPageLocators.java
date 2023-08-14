package com.planit.locators;

import org.openqa.selenium.By;

public class LandingPageLocators {
    /**
     * This function will provide locator for top pane links
     * @param linkName - Top pane link name
     * @return - Locator for link*/
    public static By LandingPageLinks(String linkName){
        return By.xpath("//li/a[contains(text(),'"+linkName+"')]");
    }
}
