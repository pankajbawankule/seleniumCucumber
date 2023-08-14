package com.planit.reusablefunctions;

import com.cucumber.listener.Reporter;
import com.planit.locators.ContactPageLocators;
import com.planit.locators.LandingPageLocators;
import com.planit.pages.ContactPage;
import com.planit.util.UtilityFunctions;
import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static com.planit.util.PageActions.*;
public class ContactOperations {
    /**
     * This function identifies all mandatory fields marked with *mark with one space between * and label
     * @return mandatory field lable list on the page
     * */
    private static List<String> getMandatoryFields()throws Throwable{
        List<WebElement> mandatoryFields = getMultipleElement(ContactPageLocators.mandatoryFieldsByStarMark);
        List<String> mandatoryFieldLabel = new ArrayList<String>();
        for(int i=0;i<mandatoryFields.size();i++){
            String mandatoryField = getText(mandatoryFields.get(i));
            mandatoryField = UtilityFunctions.removeLastCharacters(mandatoryField,2);
            mandatoryFieldLabel.add(mandatoryField);
        }
        if(mandatoryFields.size()>0){
            System.setProperty("contactMandatoryFields",String.valueOf(mandatoryFields.size()));
        }
        return mandatoryFieldLabel;
    }
/**
 * This function perform data entry operation for mandatory fields marked with * mark
 * @param dataTable gets the map of user provided mandatory data set*/
    public static void enterMandatoryFields(DataTable dataTable) throws Throwable{
        List<String> mandatoryFields = getMandatoryFields();
        List<Map<String,String>> dataList = dataTable.asMaps(String.class,String.class);
        for(int i=0; i<dataList.size();i++){
            for (int j=0; j<mandatoryFields.size();j++){
                if(UtilityFunctions.isDataPresent(dataList.get(i), mandatoryFields.get(j))){
                    ContactPage.enterFields(mandatoryFields.get(j),dataList.get(i).get(mandatoryFields.get(j)));
                    //Saving mandatory field in systemProperty for success message verification with Forename
                    if(mandatoryFields.get(j).equals("Forename")){
                        System.setProperty("Forename",dataList.get(i).get(mandatoryFields.get(j)));
                    }
                }
            }
        }
        Thread.sleep(10000);
    }

    /**
     * submits contact form*/
    public static void submitForm() throws Throwable{
        ContactPage.submitButtonClick();
    }

    /**validates success message after contact submission
     * Forename field value is dynamic here rest all static
     * */
    public static void validateSubmitSuccess(){
        String successMessage = getText(ContactPageLocators.successMessage);
        Reporter.addStepLog("Success message on screen:-"+successMessage);
        if(!successMessage.equals("Thanks "+System.getProperty("Forename")+", we appreciate your feedback.")){
            Assert.assertFalse("Validation message is not ="+"Thanks "+System.getProperty("Forename")+", we appreciate your feedback.",true);
        }
    }

    /**
     * Validates availability or unavailability of error messages.
     * @param status - Availability or UnAvailability
     * */
    public static void validateMessagesOnDataEntryForm(String status)throws Throwable {
        List<String> mandatoryFields = getMandatoryFields();
        List<String> missingMandatoryMessagesFields = new ArrayList<String>();
        List<String> availableMandatoryMessages = new ArrayList<String>();
        for (int i=0; i<mandatoryFields.size();i++){
            if(getNumberOfElements(ContactPageLocators.mandatoryMessageByLabelName(mandatoryFields.get(i)))==0){
                missingMandatoryMessagesFields.add(mandatoryFields.get(i));
                Reporter.addStepLog(mandatoryFields.get(i)+"- Error message not available for this field.");
            }else{
                availableMandatoryMessages.add(getText(ContactPageLocators.mandatoryMessageByLabelName(mandatoryFields.get(i))));
                Reporter.addStepLog(getText(ContactPageLocators.mandatoryMessageByLabelName(mandatoryFields.get(i))));
            }
        }
        if(status.equals("Availability") && (Integer.parseInt(System.getProperty("contactMandatoryFields"))!=availableMandatoryMessages.size())){
            Assert.assertFalse("Missing mandatory field messages",true);
        }
        if(status.equals("UnAvailability") && (Integer.parseInt(System.getProperty("contactMandatoryFields"))!=missingMandatoryMessagesFields.size())){
            Assert.assertFalse("Available mandatory field messages",true);
        }
    }
}
