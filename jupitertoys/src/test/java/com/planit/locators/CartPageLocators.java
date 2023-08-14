package com.planit.locators;

import org.openqa.selenium.By;

public class CartPageLocators {
    /**
     * This functionn provides locator for quantity field for any item on screen - can be used for verification
     * @param itemName - shopped item name
     * @param quantity - shopped quantity
     * @return  - locator matching input condition*/
    public static By itemQuantityOnCart(String itemName, String quantity){
        return By.xpath("//tbody/tr/td[contains(text(),'"+itemName+"')]/following-sibling::td/input[@value='"+quantity+"']");
    }
}
