package com.planit.stepdef;

import com.planit.reusablefunctions.ContactOperations;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;

public class ContactStepDef {



    @Given("^User enters mandatory data$")
    public void openPage(DataTable dataTable) throws Throwable{
        ContactOperations.enterMandatoryFields(dataTable);
    }

    @Given("^User submits contact form$")
    public void submitContact()throws Throwable{
        ContactOperations.submitForm();
    }

    @Given("^User validates success message$")
    public void validateSuccessMessage(){
        ContactOperations.validateSubmitSuccess();
    }

    @Given("^User validates error message$")
    public void validateAvailabilityErrorMessages()throws Throwable{
        ContactOperations.validateMessagesOnDataEntryForm("Availability");
    }
    @Given("^User validates error message are gone$")
    public void validateUnAvailabilityErrorMessages()throws Throwable{
        ContactOperations.validateMessagesOnDataEntryForm("UnAvailability");
    }
}
