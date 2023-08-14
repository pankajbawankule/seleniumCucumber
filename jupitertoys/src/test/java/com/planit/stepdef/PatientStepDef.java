package com.planit.stepdef;

import com.planit.reusablefunctions.PatientOperations;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PatientStepDef {

    @Given("^User navigates to  frontend$")
    public void navigateToFrontEnd() throws Throwable{

    }

    @Then("^User reads the patient analysis then$")
    public void openPage() throws Throwable{
        PatientOperations.getPatientsAnalysis();
    }

    @Then("^Verify the frontend result with backend$")
    public void verifyData() throws Throwable{
        PatientOperations.validateWithAnalysisService();
    }
}
