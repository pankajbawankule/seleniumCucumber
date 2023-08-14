package com.planit.stepdef;

import com.planit.reusablefunctions.LandingPageOperations;
import cucumber.api.java.en.Given;

public class LandingPageStepDef {
    @Given("^User opens (Contact|Shop|Cart|Login|Home) page$")
    public void openPage(String page) throws Throwable{
        LandingPageOperations.openPage(page);
    }
}
