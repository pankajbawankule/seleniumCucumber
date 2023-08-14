package com.planit.pages;
import com.planit.locators.ContactPageLocators;

import static com.planit.util.PageActions.*;
public class ContactPage {

    /**
     * This page is for having indivudual page level field opoertation
     * This is just a sample page - As i have covered all operations at reusable class level
     * Here functions will look like
     * setForeName()
     * getForeName()
     * clearForeName()
     * */

    public static void enterFields(String fieldName, String value)throws Throwable{
        enterText(ContactPageLocators.textFieldsByLabelName(fieldName),value);
    }

    public static void submitButtonClick() throws Throwable{
        pageScrollDown();
        click(ContactPageLocators.submitButton);
        //Here rather than giving hardcoded wait time we can implement wait till unavailability of sending feedback pop up and  wait till availability of mandatory messages
        Thread.sleep(20000);
    }
}
