package com.planit.locators;

import org.openqa.selenium.By;

public class ContactPageLocators {
    //static locators
    public static By mandatoryFieldsByStarMark = By.xpath("//span[@class='req']/parent::label");
    public static By submitButton = By.xpath("//a[text()='Submit']");
    public static By successMessage = By.xpath("//div[@class='alert alert-success']");


    //Reusable locators - Helps in very less maintanance due to UI change
    /**
     * Below function will provide xpath for mandatory fiel depending on label name visible on screen
     * @param labelName - label name visible on screen
     * @return - instance of By for ,andatory label name
     */
    public static By mandatoryMessageByLabelName(String labelName){
        return By.xpath("//label[contains(text(),'"+labelName+"')]/following-sibling::div/descendant::span[contains(@id,'err')]");
    }

    /**
     * Below function will provide text field and text area by label name
     * @param labelName - Label name for field
     * @return - locator By instance for text fiel*/
    public static By textFieldsByLabelName(String labelName){
        return By.xpath("//label[contains(text(),'"+labelName+"')]/following-sibling::div/child::*[1]");
    }


}
