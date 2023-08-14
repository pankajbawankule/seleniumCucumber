package com.planit.locators;

import org.openqa.selenium.By;

public class ShopPageLocators {

    //Reusable locators
    /**
     * This function provides locator for buy links depending on litem name
     * @param itemName - item name for shop*/
    public static By buyItem(String itemName){
        return By.xpath("//*[text()='"+itemName+"']/parent::div/descendant::a[text()='Buy']");
    }
}
